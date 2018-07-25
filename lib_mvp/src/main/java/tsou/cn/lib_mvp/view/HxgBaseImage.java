package tsou.cn.lib_mvp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import tsou.cn.lib_mvp.BaseView;
import tsou.cn.lib_mvp.callback.HxgMvpCallBack;
import tsou.cn.lib_mvp.presenter.HxgMvpPresenter;
import tsou.cn.lib_mvp.proxy.HxgMvpCallbackProxy;

/**
 * Created by Administrator on 2018/7/25 0025.
 */

@SuppressLint("AppCompatCustomView")
public class HxgBaseImage<V extends BaseView, P extends HxgMvpPresenter<V>>
        extends ImageView implements HxgMvpCallBack<V, P> {
    private HxgMvpCallbackProxy<V, P> callbackProxy;

    private HxgMvpCallbackProxy<V, P> getCallbackProxy() {
        //代理对象
        if (callbackProxy == null)
            this.callbackProxy = new HxgMvpCallbackProxy<V, P>(this);
        return this.callbackProxy;
    }

    private P presenter;
    private V view;

    @Override
    public P createPresenter() {
        return this.presenter;
    }

    @Override
    public V createView() {
        return this.view;
    }

    @Override
    public P getPresenter() {
        return this.presenter;
    }

    @Override
    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override
    public V getMvpView() {
        return this.view;
    }

    @Override
    public void setMvpView(V view) {
        this.view = view;
    }

    public HxgBaseImage(Context context) {
        super(context);
    }

    public HxgBaseImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HxgBaseImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    public HxgBaseImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //绑定实现
        //回调
        getCallbackProxy().createPresenter();
        getCallbackProxy().createView();
        getCallbackProxy().attachView();
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getCallbackProxy().detachView();
    }
}
