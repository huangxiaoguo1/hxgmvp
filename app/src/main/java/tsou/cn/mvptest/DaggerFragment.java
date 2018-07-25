package tsou.cn.mvptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;

import tsou.cn.lib_hxgioc.HxgCheckNet;
import tsou.cn.lib_hxgioc.HxgContentView;
import tsou.cn.lib_hxgioc.HxgOnClick;
import tsou.cn.lib_hxgioc.HxgViewUtils;
import tsou.cn.lib_hxgioc.data.HxgContast;
import tsou.cn.lib_mvp.fragment.HxgMvpFragment;
import tsou.cn.mvptest.bean.StudyBean;
import tsou.cn.mvptest.component.DaggerFragmentComponent;
import tsou.cn.mvptest.interfaceview.NetWorkView;
import tsou.cn.mvptest.module.NetWorkFragmentModule;
import tsou.cn.mvptest.presenter.NetWorkPresenter;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
@HxgContentView(R.layout.fragment_main)
public class DaggerFragment extends HxgMvpFragment<NetWorkView, NetWorkPresenter> implements NetWorkView {

    @Inject
    NetWorkPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = HxgViewUtils.getView().inject(this, inflater, container);
        DaggerFragmentComponent.builder()
                .netWorkFragmentModule(new NetWorkFragmentModule(this))
                .build()
                .inject(this);
        return mView;
    }

    @Override
    public NetWorkPresenter createPresenter() {
        return presenter;
    }

    @Override
    public NetWorkView createView() {
        return this;
    }

    @HxgOnClick(R.id.btn_network)
    @HxgCheckNet(HxgContast.DEFAULT_TYPE)
    private void btnNetworkClick(Button btnNetwork) {
        getPresenter().getNetWork(getContext());
    }

    @Override
    public void onNetWorkResult(StudyBean studyBean) {
        Toast.makeText(getContext(), studyBean.toString(), Toast.LENGTH_LONG).show();
    }
}
