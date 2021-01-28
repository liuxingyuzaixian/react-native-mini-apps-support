package com.reactnative_multibundler.demo.bean;

import com.facebook.react.AsyncReactActivity;

public class BundleModel {
    private String mainComponentName = "reactnative_multibundler";
    private AsyncReactActivity.ScriptType scriptType = AsyncReactActivity.ScriptType.NETWORK;
    private String scriptPath = "index2.android.bundle";
    private String SCRIPT_URL = "http://192.168.174.175:8083/artifactory/android_local/index2.android.bundle.zip";

    public String getMainComponentName() {
        return mainComponentName;
    }

    public void setMainComponentName(String mainComponentName) {
        this.mainComponentName = mainComponentName;
    }

    public AsyncReactActivity.ScriptType getScriptType() {
        return scriptType;
    }

    public void setScriptType(AsyncReactActivity.ScriptType scriptType) {
        this.scriptType = scriptType;
    }

    public String getScriptPath() {
        return scriptPath;
    }

    public void setScriptPath(String scriptPath) {
        this.scriptPath = scriptPath;
    }

    public String getSCRIPT_URL() {
        return SCRIPT_URL;
    }

    public void setSCRIPT_URL(String SCRIPT_URL) {
        this.SCRIPT_URL = SCRIPT_URL;
    }

    public BundleModel() {
    }

    public BundleModel(String scriptPath, String SCRIPT_URL) {
        this.scriptPath = scriptPath;
        this.SCRIPT_URL = SCRIPT_URL;
    }
}
