package com.reactnative_multibundler.demo;

import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.AsyncReactActivity;
import com.reactnative_multibundler.RnBundle;

import static java.lang.Thread.sleep;

public class BuzActivity extends AsyncReactActivity {
    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return BundleLoadingBusinessManager.getInstance().getCurrentBundleModel().getMainComponentName();
    }

    @Override
    protected RnBundle getBundle() {
        RnBundle bundle = new RnBundle();
        bundle.scriptType = BundleLoadingBusinessManager.getInstance().getCurrentBundleModel().getScriptType();
        bundle.scriptPath = BundleLoadingBusinessManager.getInstance().getCurrentBundleModel().getScriptPath();
        bundle.scriptUrl = BundleLoadingBusinessManager.getInstance().getCurrentBundleModel().getSCRIPT_URL();
        return bundle;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (BundleLoadingBusinessManager.getInstance().getCurrentIndex()<BundleLoadingBusinessManager.getInstance().getJsonList().size()-1){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    BundleLoadingBusinessManager.getInstance().setCurrentIndex(BundleLoadingBusinessManager.getInstance().getCurrentIndex()+1);
                    startActivity(new Intent(BuzActivity.this,BuzActivity.class));
                }
            }).start();
        }

    }
}
