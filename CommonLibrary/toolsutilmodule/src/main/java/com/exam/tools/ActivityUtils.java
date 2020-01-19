package com.exam.tools;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;

import java.util.List;

/**
 * Function:
 * Author Name: yuexingxing
 * Date: 2020-01-17
 * Copyright © 2006-2018 高顿网校, All Rights Reserved.
 **/
public class ActivityUtils {

    /**
     * 判断某个界面是否在前台
     *
     * @param activity 要判断的Activity
     * @return 是否在前台显示
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public static boolean isForeground(Activity activity) {
        return isForeground(activity, activity.getClass().getName());//这里有个小细节，获取类的名称
    }

    /**
     * 判断某个界面是否在前台
     *
     * @param context   Context
     * @param className 界面的类名
     * @return 是否在前台显示
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public static boolean isForeground(Context context, String className) {
        if (context == null || TextUtils.isEmpty(className))
            return false;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(1);
        if (list != null && list.size() > 0) {
            ComponentName cpn = list.get(0).topActivity;
            if (className.equals(cpn.getClassName()))
                return true;
        }
        return false;
    }
}

