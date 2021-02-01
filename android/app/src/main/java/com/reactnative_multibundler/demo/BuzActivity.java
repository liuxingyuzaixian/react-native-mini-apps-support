package com.reactnative_multibundler.demo;

import android.os.Bundle;

import com.facebook.react.AsyncReactActivity;
import com.reactnative_multibundler.Const;
import com.reactnative_multibundler.RnBundle;
import com.reactnative_multibundler.demo.bean.ReLoadBundleEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static java.lang.Thread.sleep;

public class BuzActivity extends AsyncReactActivity {
    private boolean isActive=false;
    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return Const.getMainComponentName();
    }

    @Override
    protected RnBundle getBundle() {
        RnBundle bundle = new RnBundle();
        bundle.scriptType = Const.getScriptType();
        bundle.scriptPath = Const.getScriptPath();
        bundle.scriptUrl = Const.getScriptUrl();
        return bundle;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        isActive = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isActive = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isActive = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void update(ReLoadBundleEvent reLoadBundleEvent) {
        if (isActive) {
            loadScript();
        }
    }
}
