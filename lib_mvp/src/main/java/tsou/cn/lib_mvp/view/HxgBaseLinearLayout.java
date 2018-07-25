package tsou.cn.lib_mvp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import tsou.cn.lib_mvp.BaseView;
import tsou.cn.lib_mvp.callback.HxgMvpCallBack;
import tsou.cn.lib_mvp.presenter.HxgMvpPresenter;
import tsou.cn.lib_mvp.proxy.HxgMvpCallbackProxy;

/**
 * Created by Administrator on 2018/7/24 0024.
 */

public abstract class HxgBaseLinearLayout<V extends BaseView, P extends HxgMvpPresenter<V>>
        extends LinearLayout implements HxgMvpCallBack<V, P> {

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

    public HxgBaseLinearLayout(Context context) {
        super(context);
    }

    public HxgBaseLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HxgBaseLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    public HxgBaseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
