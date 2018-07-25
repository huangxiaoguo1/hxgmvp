package tsou.cn.mvptest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import tsou.cn.lib_mvp.view.HxgBaseTextView;
import tsou.cn.mvptest.bean.StudyBean;
import tsou.cn.mvptest.interfaceview.NetWorkView;
import tsou.cn.mvptest.presenter.NetWorkPresenter;

/**
 * Created by Administrator on 2018/7/25 0025.
 */

public class NetWorkTextView extends HxgBaseTextView<NetWorkView, NetWorkPresenter>
        implements NetWorkView, View.OnClickListener {

    public NetWorkTextView(Context context) {
        super(context);
    }

    public NetWorkTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NetWorkTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NetWorkTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
    public void onClick(View v) {
        getPresenter().getNetWork(getContext());
    }

    @Override
    public void onNetWorkResult(StudyBean studyBean) {
        Toast.makeText(getContext(), studyBean.toString(), Toast.LENGTH_LONG).show();
    }
}
