package tsou.cn.mvptest.interfaceview;

import tsou.cn.lib_mvp.BaseView;
import tsou.cn.mvptest.bean.StudyBean;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
//用于V层和M层进行交互的接口
public interface NetWorkView extends BaseView {
     void onNetWorkResult(StudyBean studyBean);
}
