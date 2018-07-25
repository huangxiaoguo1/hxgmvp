package tsou.cn.mvptest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;

import tsou.cn.lib_hxgioc.HxgCheckNet;
import tsou.cn.lib_hxgioc.HxgContentView;
import tsou.cn.lib_hxgioc.HxgOnClick;
import tsou.cn.lib_hxgioc.HxgViewUtils;
import tsou.cn.lib_hxgioc.data.HxgContast;
import tsou.cn.lib_mvp.activity.HxgMvpActivity;
import tsou.cn.mvptest.bean.StudyBean;
import tsou.cn.mvptest.component.DaggerMainComponent;
import tsou.cn.mvptest.interfaceview.NetWorkView;
import tsou.cn.mvptest.module.NetWorkModule;
import tsou.cn.mvptest.presenter.NetWorkPresenter;

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
