package tsou.cn.mvptest.aop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import tsou.cn.lib_hxgaop.HxgAopCheckNet;
import tsou.cn.lib_hxgaop.data.HxgAopContast;
import tsou.cn.mvptest.R;

/**
 * Created by Administrator on 2018/7/25 0025.
 * 处理切点
 */

@Aspect
public class CheckNetSectionAspect {
    /**
     * 找到处理的切点
     * <p>
     * * *(..))处理所有的方法
     * execution：切点的位置（包名+方法名）
     */

    @Pointcut("execution(@tsou.cn.lib_hxgaop.HxgAopCheckNet * *(..))")
    public void checkNetBehavior() {

    }

    /**
     * 处理切面
     */
    @Around("checkNetBehavior()")
    public Object checkNet(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        HxgAopCheckNet checkNet = methodSignature.getMethod().getAnnotation(HxgAopCheckNet.class);
        if (checkNet != null) {
            Object object = joinPoint.getThis();
            Context context = getContext(object);
            if (context != null) {
                if (!isNetworkConnected(context)) {
                    int resId = checkNet.value();
                    //不显示未联网提示，直接拦截
                    if (resId == HxgAopContast.NOHINT_TYPE) {
                        return null;
                    }
                    if (resId != HxgAopContast.DEFAULT_TYPE) {
                        try {
                            Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                        }
                    } else {
                        String text = context.getString(R.string.check_default_string);
                        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
                    }
                    return null;
                }
            }
        }
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    /**
     * 通过对象获取上下文
     *
     * @param object
     * @return
     */
    @SuppressLint("NewApi")
    private Context getContext(Object object) {
        if (object instanceof Activity) {
            return (Activity) object;
        } else if (object instanceof Fragment) {
            Fragment fragment = (Fragment) object;
            return fragment.getContext();
        } else if (object instanceof View) {
            View view = (View) object;
            return view.getContext();
        }
        return null;
    }

    /**
     * 判断网络是否可用
     *
     * @param context
     * @return
     */
    private static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
}
