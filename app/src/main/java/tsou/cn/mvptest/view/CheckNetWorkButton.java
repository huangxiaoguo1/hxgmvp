package tsou.cn.mvptest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import tsou.cn.lib_hxgaop.HxgAopCheckNet;
import tsou.cn.lib_hxgaop.data.HxgAopContast;
import tsou.cn.lib_mvp.view.HxgBaseButton;
import tsou.cn.mvptest.bean.StudyBean;
import tsou.cn.mvptest.interfaceview.NetWorkView;
import tsou.cn.mvptest.presenter.NetWorkPresenter;

/**
 * Created by Administrator on 2018/7/24 0024.
 * 带有检查网络的Button
 */

public class CheckNetWorkButton extends HxgBaseButton<NetWorkView, NetWorkPresenter>
        implements NetWorkView, View.OnClickListener {
    public CheckNetWorkButton(Context context) {
        super(context);
    }

    public CheckNetWorkButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckNetWorkButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CheckNetWorkButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(this);
    }

    @Override
    public NetWorkPresenter createPresenter() {
        return new NetWorkPresenter();
    }

    @Override
    public NetWorkView createView() {
        return this;
    }


    @Override
    @HxgAopCheckNet(HxgAopContast.DEFAULT_TYPE)
    public void onClick(View v) {
        getPresenter().getNetWork(getContext());
    }

    @Override
    public void onNetWorkResult(StudyBean studyBean) {
        Toast.makeText(getContext(), studyBean.toString(), Toast.LENGTH_LONG).show();
    }


}
