package tsou.cn.lib_mvp.proxy;


import tsou.cn.lib_mvp.BaseView;
import tsou.cn.lib_mvp.callback.HxgMvpCallBack;
import tsou.cn.lib_mvp.presenter.HxgMvpPresenter;

/**
 * Created by 黄家三少 on 2018/7/24.
 */
//代理对象：代理实现（HxgMvpCallbackProxy）
public class HxgMvpCallbackProxy<V extends BaseView, P extends HxgMvpPresenter<V>>
        implements HxgMvpCallBack<V, P> {
    //持有目标对象的引用
    private HxgMvpCallBack<V, P> callBack;

    public HxgMvpCallbackProxy(HxgMvpCallBack<V, P> callBack) {
        this.callBack = callBack;
    }

    @Override
    public P createPresenter() {
        P presenter = this.callBack.getPresenter();
        if (presenter == null) {
            presenter = this.callBack.createPresenter();
        }
        if (presenter == null) {
            throw new NullPointerException("presenter is null");
        }
        this.callBack.setPresenter(presenter);
        return presenter;
    }

    @Override
    public V createView() {
        V view = this.callBack.getMvpView();
        if (view == null) {
            view = this.callBack.createView();
        }
        if (view == null) {
            throw new NullPointerException("view is null");
        }
        this.callBack.setMvpView(view);
        return view;
    }

    @Override
    public P getPresenter() {
        P presenter = this.callBack.getPresenter();
        if (presenter == null) {
            throw new NullPointerException("presenter is null");
        }
        return presenter;
    }

    @Override
    public void setPresenter(P presenter) {
        this.callBack.setPresenter(presenter);
    }

    @Override
    public V getMvpView() {
        V view = this.callBack.getMvpView();
        if (view == null) {
            throw new NullPointerException("view is null");
        }
        return view;
    }

    @Override
    public void setMvpView(V view) {
        this.callBack.setMvpView(view);
    }

    public void attachView() {
        getPresenter().attachView(getMvpView());
    }

    public void detachView() {
        getPresenter().detachView();
    }


}
