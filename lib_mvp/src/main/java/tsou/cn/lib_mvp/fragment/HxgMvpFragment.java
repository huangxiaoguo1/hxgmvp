package tsou.cn.lib_mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import tsou.cn.lib_mvp.BaseView;
import tsou.cn.lib_mvp.callback.HxgMvpCallBack;
import tsou.cn.lib_mvp.presenter.HxgMvpPresenter;

/**
 * Created by Administrator on 2018/7/25 0025.
 */

public class HxgMvpFragment<V extends BaseView, P extends HxgMvpPresenter<V>> extends Fragment
        implements HxgMvpCallBack<V, P> {
    private P presenter;
    private V view;

    @Override
    public P createPresenter() {
        return this.presenter;
    }

    @Override
    public V createView() {
        return this.view;
    }

    @Override
    public P getPresenter() {
        return this.presenter;
    }

    @Override
    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override
    public V getMvpView() {
        return this.view;
    }

    @Override
    public void setMvpView(V view) {
        this.view = view;
    }

    //持有目标对象的引用
    private HxgFragmentMvpDelegateImpl<V, P> delegate;

    public HxgFragmentMvpDelegateImpl<V, P> getMvpDelegate() {
        if (delegate == null) {
            this.delegate = new HxgFragmentMvpDelegateImpl<>(this);
        }
        return delegate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getMvpDelegate().onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        getMvpDelegate().onViewCreated(view,savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getMvpDelegate().onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }
}
