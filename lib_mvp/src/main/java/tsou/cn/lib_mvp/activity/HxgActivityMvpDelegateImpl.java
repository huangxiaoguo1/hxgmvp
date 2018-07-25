package tsou.cn.lib_mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import tsou.cn.lib_mvp.BaseView;
import tsou.cn.lib_mvp.callback.HxgMvpCallBack;
import tsou.cn.lib_mvp.presenter.HxgMvpPresenter;
import tsou.cn.lib_mvp.proxy.HxgMvpCallbackProxy;


/**
 * Created by 黄家三少 on 2018/7/24.
 */
//目标对象，具体的实现->生命周期实现
public class HxgActivityMvpDelegateImpl<V extends BaseView, P extends HxgMvpPresenter<V>>
        implements HxgActivityMvpDelegate {
    private HxgMvpCallBack<V, P> callBack;
    private HxgMvpCallbackProxy<V, P> callbackProxy;
    public HxgActivityMvpDelegateImpl(HxgMvpCallBack<V, P> callBack) {
        this.callBack=callBack;
    }
    private HxgMvpCallbackProxy<V, P> getCallbackProxy(){
        //代理对象
        if (callBack != null) {
            this.callbackProxy = new HxgMvpCallbackProxy<V, P>(callBack);
        }
        return this.callbackProxy;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //绑定实现
        //回调
        getCallbackProxy().createPresenter();
        getCallbackProxy().createView();
        getCallbackProxy().attachView();
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
    public void onRestart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        getCallbackProxy().detachView();
    }
}
