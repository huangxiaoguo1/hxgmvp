package tsou.cn.mvptest.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tsou.cn.mvptest.DaggerActivity;
import tsou.cn.mvptest.presenter.NetWorkPresenter;

/**
 * Created by Administrator on 2018/7/25 0025.
 * 使用Dagger创建对象
 */
@Module
public class NetWorkModule {
    private DaggerActivity mActivity;

    public NetWorkModule(DaggerActivity mActivity) {
        this.mActivity = mActivity;
    }

    //显然我们并不是很多地方都需要某对象，我们在需要用该对象的界面的Module中提供注入即可
    @Singleton
    @Provides
    NetWorkPresenter provideNetWork() {
        return new NetWorkPresenter();
    }
}
