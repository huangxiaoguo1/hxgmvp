package tsou.cn.lib_mvp.presenter;

import tsou.cn.lib_mvp.BaseView;

//Presenter抽象父类，防止多次绑定
public class HxgMvpBasePresenter<V extends BaseView> implements HxgMvpPresenter<V> {

    private V view;

    public V getView() {
        return view;
    }

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

}