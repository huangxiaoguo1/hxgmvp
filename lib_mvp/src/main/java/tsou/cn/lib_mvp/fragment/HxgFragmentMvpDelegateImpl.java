package tsou.cn.lib_mvp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import tsou.cn.lib_mvp.BaseView;
import tsou.cn.lib_mvp.callback.HxgMvpCallBack;
import tsou.cn.lib_mvp.presenter.HxgMvpPresenter;
import tsou.cn.lib_mvp.proxy.HxgMvpCallbackProxy;


/**
 * Created by Administrator on 2018/7/25 0025.
 */

public class HxgFragmentMvpDelegateImpl<V extends BaseView, P extends HxgMvpPresenter<V>> implements HxgFragmentMvpDelegate<V, P> {

    //绑定UI层和解除绑定
    private HxgMvpCallBack<V, P> callBack;
    private HxgMvpCallbackProxy<V, P> callbackProxy;

    public HxgFragmentMvpDelegateImpl(HxgMvpCallBack<V, P> callBack) {
        this.callBack = callBack;
    }

    private HxgMvpCallbackProxy<V, P> getCallbackProxy() {
        //代理对象
        if (callBack != null) {
            this.callbackProxy = new HxgMvpCallbackProxy<V, P>(callBack);
        }
        return this.callbackProxy;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //绑定实现
        //回调
        getCallbackProxy().createPresenter();
        getCallbackProxy().createView();
        getCallbackProxy().attachView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroyView() {

    }

    @Override
    public void onDestroy() {
        getCallbackProxy().detachView();
    }
}
