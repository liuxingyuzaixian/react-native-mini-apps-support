package com.reactnative_multibundler.demo;

import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.AsyncReactActivity;
import com.reactnative_multibundler.RnBundle;

import static java.lang.Thread.sleep;

public class Buz1Activity extends AsyncReactActivity {
    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "reactnative_multibundler";
    }

    @Override
    protected RnBundle getBundle(){
        RnBundle bundle = new RnBundle();
        bundle.scriptType = ScriptType.NETWORK;
        bundle.scriptPath = "image.android.bundle";
        bundle.scriptUrl = "http://192.168.174.175:8083/artifactory/android_local/image.android.zhanglei";
        return bundle;
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(Buz1Activity.this,Buz2Activity.class));
            }
        }).start();
    }
}
