package tsou.cn.mvptest.presenter;

import android.content.Context;

import javax.inject.Inject;

import tsou.cn.lib_hxgokhttp.callback.DefaultHttpCallBack;
import tsou.cn.lib_mvp.presenter.HxgMvpBasePresenter;
import tsou.cn.mvptest.bean.StudyBean;
import tsou.cn.mvptest.interfaceview.NetWorkView;
import tsou.cn.mvptest.model.NetWorkModel;


/**
 * Created by Administrator on 2018/7/24 0024.
 */
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
