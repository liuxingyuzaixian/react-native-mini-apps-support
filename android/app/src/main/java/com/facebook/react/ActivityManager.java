package com.facebook.react;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/**
 * 用于处理退出程序时可以退出所有的activity，而编写的通用类
 */
public class ActivityManager {
    private List<Activity> activityList = new LinkedList<Activity>();
    private static ActivityManager instance;
    private WeakReference<Activity> sCurrentActivityWeakRef;

    private ActivityManager() {
    }

    // 单例模式中获取唯一的MyApplication实例
    public static ActivityManager getInstance() {
        if (null == instance) {
            instance = new ActivityManager();
        }
        return instance;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void exitOther() {
        for (int i = 0; i < activityList.size(); i++) {
            if (!activityList.get(i).getLocalClassName().equals("view.HomeActivity")) {
                activityList.get(i).finish();
                activityList.remove(i);
            }
        }
    }

    // 遍历所有Activity并finish
    public void exit() {
        exitAllActivity();
        System.exit(0);
    }

    public void exitAllActivity() {
        if (activityList != null) {
            for (Activity activity : activityList) {
                activity.finish();
            }
        }
    }

    public Activity getCurrentActivity() {
        Activity currentActivity = null;
        if (sCurrentActivityWeakRef != null) {
            currentActivity = sCurrentActivityWeakRef.get();
        }
        return currentActivity;
    }

    // 移除Activity
    public void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public void setCurrentActivity(Activity activity) {
        sCurrentActivityWeakRef = new WeakReference<>(activity);
    }

    public List<Activity> getActivityList() {
        return activityList;
    }
}


