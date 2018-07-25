package tsou.cn.lib_mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import tsou.cn.lib_mvp.BaseView;
import tsou.cn.lib_mvp.presenter.HxgMvpPresenter;


/**
 * Created by Administrator on 2018/7/25 0025.
 */

public interface HxgFragmentMvpDelegate<V extends BaseView, P extends HxgMvpPresenter<V>> {
    void onCreate(@Nullable Bundle savedInstanceState);

    void onActivityCreated(@Nullable Bundle savedInstanceState);

    void onViewCreated(View view, @Nullable Bundle savedInstanceState);

    void onStart();

    void onPause();

    void onResume();

    void onStop();

    void onDestroyView();

    void onDestroy();
}
