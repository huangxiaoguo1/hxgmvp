package tsou.cn.lib_mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import tsou.cn.lib_mvp.BaseView;
import tsou.cn.lib_mvp.callback.HxgMvpCallBack;
import tsou.cn.lib_mvp.presenter.HxgMvpPresenter;

/**
 * Created by 黄家三少 on 2018/7/24.
 */

public abstract class HxgMvpActivity<V extends BaseView, P extends HxgMvpPresenter<V>>
        extends AppCompatActivity implements HxgMvpCallBack<V, P> {

    //持有目标对象的引用
    private HxgActivityMvpDelegateImpl<V, P> delegate;

    public HxgActivityMvpDelegateImpl<V, P> getMvpDelegate() {
        if (delegate == null) {
            this.delegate = new HxgActivityMvpDelegateImpl<>(this);
        }
        return delegate;
    }

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getMvpDelegate().onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }
}
