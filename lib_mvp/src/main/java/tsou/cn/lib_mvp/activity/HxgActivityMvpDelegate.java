package tsou.cn.lib_mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import tsou.cn.lib_mvp.BaseView;
import tsou.cn.lib_mvp.presenter.HxgMvpBasePresenter;

/**
 * Created by 黄家三少 on 2018/7/24.
 */
//目标接口：针对Activity目标接口——>生命周期进行代理
public interface HxgActivityMvpDelegate<V extends BaseView, P extends HxgMvpBasePresenter<V>> {
    void onCreate(@Nullable Bundle savedInstanceState);

    void onStart();

    void onPause();

    void onResume();

    void onRestart();

    void onStop();

    void onDestroy();
}
