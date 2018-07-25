package tsou.cn.mvptest.component;

import javax.inject.Singleton;

import dagger.Component;
import tsou.cn.mvptest.DaggerFragment;
import tsou.cn.mvptest.module.NetWorkFragmentModule;

/**
 * Created by Administrator on 2018/7/25 0025.
 * Dagger绑定
 */
@Singleton
@Component(modules = NetWorkFragmentModule.class)
public interface FragmentComponent {
    void inject(DaggerFragment fragment);
}
