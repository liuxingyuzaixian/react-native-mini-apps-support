package com.reactnative_multibundler.demo;

import android.content.Intent;

import com.facebook.react.AsyncReactActivity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.gson.Gson;
import com.reactnative_multibundler.Const;
import com.reactnative_multibundler.demo.bean.BundleModel;
import com.reactnative_multibundler.demo.bean.ReLoadBundleEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class CommModule extends ReactContextBaseJavaModule {

    private ReactApplicationContext mContext;
    public static final String MODULE_NAME = "commModule";

    /**
     * 构造方法必须实现
     *
     * @param reactContext
     */
    public CommModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.mContext = reactContext;
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    /**
     * 在rn代码里面是需要这个名字来调用该类的方法
     *
     * @return
     */
    @Override
    public String getName() {
        return MODULE_NAME;
    }


    /**
     * 更新小程序或者打开另外一个小程序
     */
    @ReactMethod
    public void updateApp(String mainComponentName,String scriptPath,String SCRIPT_URL) {
        /**
         * 更新bundle信息
         */
        Const.setMainComponentName(mainComponentName);
        Const.setScriptPath(scriptPath);
        Const.setScriptType(AsyncReactActivity.ScriptType.NETWORK);
        Const.setScriptUrl(SCRIPT_URL);

        /**
         * 加载新bundle
         */
        EventBus.getDefault().post(new ReLoadBundleEvent());
    }

    /**
     * 更新小程序或者打开另外一个小程序
     */
    @ReactMethod
    public void jumpToNextApp(String mainComponentName,String scriptPath,String SCRIPT_URL) {
        /**
         * 更新bundle信息
         */
        Const.setMainComponentName(mainComponentName);
        Const.setScriptPath(scriptPath);
        Const.setScriptType(AsyncReactActivity.ScriptType.NETWORK);
        Const.setScriptUrl(SCRIPT_URL);

        /**
         * 跳转页面
         */
        Intent intent = new Intent(mContext, BuzActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void update(ReLoadBundleEvent reLoadBundleEvent) {
    }
}
