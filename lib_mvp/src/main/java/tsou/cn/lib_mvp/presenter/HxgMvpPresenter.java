package tsou.cn.lib_mvp.presenter;

import tsou.cn.lib_mvp.BaseView;

//P层：高度抽象
public interface HxgMvpPresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

}