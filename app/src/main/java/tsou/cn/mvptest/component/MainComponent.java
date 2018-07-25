package tsou.cn.mvptest.component;

import javax.inject.Singleton;

import dagger.Component;
import tsou.cn.mvptest.DaggerActivity;
import tsou.cn.mvptest.module.NetWorkModule;

/**
 * Created by Administrator on 2018/7/25 0025.
 * Dagger绑定
 */
@Singleton
@Component(modules = NetWorkModule.class)
public interface MainComponent {
    void inject(DaggerActivity activity);
}
