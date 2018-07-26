# hxgmvp
### 引用方式

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
dependencies {
  implementation 'com.github.huangxiaoguo1:hxgmvp:1.0.0'
}
```

### 简介

    主要封装的类有：HxgMvpActivity，HxgMvpFragment
           控件有：HxgBaseButton，HxgBaseImage，HxgBaseTextView
                  HxgBaseFrameLayout，HxgBaseLinearLayout，HxgBaseRelativeLayout

### MVP使用

###### 创建用于V层和M层进行交互的接口

例如：
```
//用于V层和M层进行交互的接口
public interface NetWorkView extends BaseView {
     void onNetWorkResult(StudyBean studyBean);
}
```

###### M层 处理数据

例如：

```
//M层
public class NetWorkModel {
    public void getNetWork(Context context,
                           DefaultHttpCallBack<StudyBean> callBack) {
        Map<String, Object> field = new ArrayMap<>();
        field.put("currentPage", "1");
        field.put("pageSize", "15");
        field.put("indexFlag", "1");
        HxgHttpUtils.with(context)
                .post()
                .url("https://***.1035.mobi/app/course/index.do")
                .addParam(field)
                .execeute(callBack);
    }
}
```

###### P层 和V层进行交互

例如：
```
//P层
//和V层进行交互
public class NetWorkPresenter extends HxgMvpBasePresenter<NetWorkView> {
    private NetWorkModel netWorkModel;

    //创建于M层的引用
    public NetWorkPresenter() {
        this.netWorkModel = new NetWorkModel();
    }
    public void getNetWork(Context context) {

        this.netWorkModel.getNetWork(context, new DefaultHttpCallBack<StudyBean>() {
            @Override
            public void onSuccess(StudyBean studyBean) {
                if (getView() != null) {
                    getView().onNetWorkResult(studyBean);
                }
            }

            @Override
            public void onFail(Exception e) {
                e.printStackTrace();
            }
        });
    }
}

```

###### Activity处理数据

例如：(记得实现数据回调接口NetWorkView)
```
**
 * 封装好的MVP框架
 * 主要涉及类在：interfaceview包，model包，presenter包中
 */
@HxgContentView(R.layout.activity_main)
public class MainActivity extends HxgMvpActivity<NetWorkView, NetWorkPresenter> implements NetWorkView {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HxgViewUtils.getView().inject(this);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_main, new MainFragment())
                .commitAllowingStateLoss();
    }

    @Override
    public NetWorkPresenter createPresenter() {
        return new NetWorkPresenter();
    }

    @Override
    public NetWorkView createView() {
        return this;
    }


    @HxgOnClick(R.id.btn_network)
    @HxgCheckNet(HxgContast.DEFAULT_TYPE)
    private void btnNetworkClick(Button btnNetwork) {
        getPresenter().getNetWork(this);
    }

    /**
     * 返回的数据
     *
     * @param studyBean
     */
    @Override
    public void onNetWorkResult(StudyBean studyBean) {
        Toast.makeText(this, studyBean.toString(), Toast.LENGTH_LONG).show();
    }

    /**
     * 跳转Dagger页面
     *
     * @param dagger
     */
    @HxgOnClick(R.id.dagger)
    private void daggerClick(Button dagger) {
        startActivity(new Intent(this, DaggerActivity.class));
    }
}
```

###### Fragment处理数据

例如：(记得实现数据回调接口NetWorkView)

```

@HxgContentView(R.layout.fragment_main)
public class MainFragment extends HxgMvpFragment<NetWorkView, NetWorkPresenter> implements NetWorkView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = HxgViewUtils.getView().inject(this, inflater, container);
        return mView;
    }

    @Override
    public NetWorkPresenter createPresenter() {
        return new NetWorkPresenter();
    }

    @Override
    public NetWorkView createView() {
        return this;
    }

    @HxgOnClick(R.id.btn_network)
    @HxgCheckNet(HxgContast.DEFAULT_TYPE)
    private void btnNetworkClick(Button btnNetwork) {
        getPresenter().getNetWork(getContext());
    }

    @Override
    public void onNetWorkResult(StudyBean studyBean) {
        Toast.makeText(getContext(), studyBean.toString(), Toast.LENGTH_LONG).show();
    }


}
```

### 结合dagger2使用

  dagger的作用主要是自动实例化Presenter

#### Activity中使用

###### 实例化Presenter对象

例如：

```
/**
 * Created by Administrator on 2018/7/25 0025.
 * 使用Dagger创建对象
 */
@Module
public class NetWorkModule {
    private DaggerActivity mActivity;

    public NetWorkModule(DaggerActivity mActivity) {
        this.mActivity = mActivity;
    }

    //显然我们并不是很多地方都需要某对象，我们在需要用该对象的界面的Module中提供注入即可
    @Singleton
    @Provides
    NetWorkPresenter provideNetWork() {
        return new NetWorkPresenter();
    }
}

```

###### Dagger绑定

```
/**
 * Created by Administrator on 2018/7/25 0025.
 * Dagger绑定
 */
@Singleton
@Component(modules = NetWorkModule.class)
public interface MainComponent {
    void inject(DaggerActivity activity);
}


```

###### dagger注入（以activity为例）

```
 @Inject
 NetWorkPresenter presenter;
  
  
  记得注入要在onCreate方法的 super.onCreate(savedInstanceState);之前
 DaggerMainComponent.builder()
                 .netWorkModule(new NetWorkModule(this))
                 .build()
                 .inject(this);
    
```
createPresenter 返回注入的对象
```
    @Override
    public NetWorkPresenter createPresenter() {
        return presenter;
    }
```
         
 整个Activity的内容如下
 
 ```
 /**
  * 带有Dagger的Activity
  * Dagger主要涉及类在：component包，module包
  *
  */
 @HxgContentView(R.layout.activity_dagger)
 public class DaggerActivity extends HxgMvpActivity<NetWorkView, NetWorkPresenter>
         implements NetWorkView {
     @Inject
     NetWorkPresenter presenter;
     private FragmentManager fragmentManager;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         DaggerMainComponent.builder()
                 .netWorkModule(new NetWorkModule(this))
                 .build()
                 .inject(this);
         super.onCreate(savedInstanceState);
         HxgViewUtils.getView().inject(this);
         fragmentManager = getSupportFragmentManager();
         fragmentManager.beginTransaction().replace(R.id.fl_main, new MainFragment())
                 .commitAllowingStateLoss();
     }
 
     @Override
     public NetWorkPresenter createPresenter() {
         return presenter;
     }
 
     @Override
     public NetWorkView createView() {
         return this;
     }
 
     @HxgOnClick(R.id.butten)
     @HxgCheckNet(HxgContast.DEFAULT_TYPE)
     private void buttenClick(Button butten) {
         getPresenter().getNetWork(this);
     }
 
     /**
      * 返回的数据
      *
      * @param studyBean
      */
     @Override
     public void onNetWorkResult(StudyBean studyBean) {
         Toast.makeText(this, studyBean.toString(), Toast.LENGTH_LONG).show();
     }
 }
 ```
   
 ### 结合MVP自定义View
 
 ###### 自定义MVP控件(以Button网络请求为例)
 
 ```
 
public class NetWorkButton extends HxgBaseButton<NetWorkView, NetWorkPresenter>
        implements NetWorkView, View.OnClickListener {
    public NetWorkButton(Context context) {
        super(context);
    }

    public NetWorkButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NetWorkButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NetWorkButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(this);
    }

    @Override
    public NetWorkPresenter createPresenter() {
        return new NetWorkPresenter();
    }

    @Override
    public NetWorkView createView() {
        return this;
    }


    @Override
    public void onClick(View v) {
        getPresenter().getNetWork(getContext());
    }

    @Override
    public void onNetWorkResult(StudyBean studyBean) {
        Toast.makeText(getContext(), studyBean.toString(), Toast.LENGTH_LONG).show();
    }


}
 ```
 
 详细请下载demo查看

 
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
