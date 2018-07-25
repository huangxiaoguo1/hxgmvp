package tsou.cn.lib_mvp.callback;


import tsou.cn.lib_mvp.BaseView;
import tsou.cn.lib_mvp.presenter.HxgMvpPresenter;

/**
 * Created by Administrator on 2018/7/24 0024.
 * 抽象回调
 *
 * 代理设计模式
 * 针对->MVP
 * MVP绑定和解绑->目标接口
 */

public interface HxgMvpCallBack<V extends BaseView, P extends HxgMvpPresenter<V>> {
    //创建P层
    P createPresenter();
    //创建V层
    V createView();
    //得到P层
    P getPresenter();
    //设置P层
    void setPresenter(P presenter);
    //得到V层
    V getMvpView();
    //设置V层
    void setMvpView(V view);

}











