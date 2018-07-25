package tsou.cn.mvptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Button;
import android.widget.Toast;

import tsou.cn.lib_hxgioc.HxgCheckNet;
import tsou.cn.lib_hxgioc.HxgContentView;
import tsou.cn.lib_hxgioc.HxgOnClick;
import tsou.cn.lib_hxgioc.HxgViewUtils;
import tsou.cn.lib_hxgioc.data.HxgContast;
import tsou.cn.lib_mvp.activity.HxgMvpActivity;
import tsou.cn.mvptest.bean.StudyBean;
import tsou.cn.mvptest.interfaceview.NetWorkView;
import tsou.cn.mvptest.presenter.NetWorkPresenter;

@HxgContentView(R.layout.activity_main)
public class MainActivity extends HxgMvpActivity<NetWorkView, NetWorkPresenter> implements NetWorkView {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HxgViewUtils.getView().inject(this);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_main, new MainFragment())
                .commitAllowingStateLoss();
    }

    @Override
    public NetWorkPresenter createPresenter() {
        return new NetWorkPresenter();
    }

    @Override
    public NetWorkView createView() {
        return this;
    }


    @HxgOnClick(R.id.btn_network)
    @HxgCheckNet(HxgContast.DEFAULT_TYPE)
    private void btnNetworkClick(Button btnNetwork) {
        getPresenter().getNetWork(this);
    }

    /**
     * 返回的数据
     *
     * @param studyBean
     */
    @Override
    public void onNetWorkResult(StudyBean studyBean) {
        Toast.makeText(this, studyBean.toString(), Toast.LENGTH_LONG).show();
    }

    /**
     * 跳转Dagger页面
     *
     * @param dagger
     */
    @HxgOnClick(R.id.dagger)
    private void daggerClick(Button dagger) {
        startActivity(new Intent(this, DaggerActivity.class));
    }
}
