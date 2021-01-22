package com.reactnative_multibundler.demo;

import com.facebook.react.AsyncReactActivity;
import com.reactnative_multibundler.RnBundle;

public class Buz2Activity extends AsyncReactActivity {
    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "reactnative_multibundler2";
    }

    @Override
    protected RnBundle getBundle(){
        RnBundle bundle = new RnBundle();
        bundle.scriptType = ScriptType.NETWORK;
        bundle.scriptPath = "index2.android.bundle";
        bundle.scriptUrl = "http://192.168.174.175:8083/artifactory/android_local/index2.android.bundle.zip";
        return bundle;
    }
}
