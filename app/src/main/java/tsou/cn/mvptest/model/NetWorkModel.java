package tsou.cn.mvptest.model;

import android.content.Context;
import android.support.v4.util.ArrayMap;

import java.util.Map;

import tsou.cn.lib_hxgokhttp.HxgHttpUtils;
import tsou.cn.lib_hxgokhttp.callback.DefaultHttpCallBack;
import tsou.cn.mvptest.bean.StudyBean;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
//M层
public class NetWorkModel {
    public void getNetWork(Context context,
                           DefaultHttpCallBack<StudyBean> callBack) {
        Map<String, Object> field = new ArrayMap<>();
        field.put("currentPage", "1");
        field.put("pageSize", "15");
        field.put("indexFlag", "1");
        HxgHttpUtils.with(context)
                .post()
                .url("https://university.1035.mobi/app/course/index.do")
                .addParam(field)
                .execeute(callBack);
    }
}
