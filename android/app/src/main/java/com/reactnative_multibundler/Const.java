package com.reactnative_multibundler;

import com.facebook.react.AsyncReactActivity;

/**
 * 记录当前的bundle，用于加载或者更新
 */
public class Const {
    /**
     * js为开发模式还是打包模式
     */
    public static final boolean DEBUG = true;

    private static String mainComponentName = "reactnative_multibundler";
    private static AsyncReactActivity.ScriptType scriptType = AsyncReactActivity.ScriptType.NETWORK;
    private static String scriptPath = "android_1";
    private static String SCRIPT_URL = "http://192.168.174.26:8083/artifactory/rn_wgt/android_1.wgt";

    public static String getMainComponentName() {
        return mainComponentName;
    }

    public static void setMainComponentName(String mainComponentName) {
        Const.mainComponentName = mainComponentName;
    }

    public static AsyncReactActivity.ScriptType getScriptType() {
        if (DEBUG) {
            return AsyncReactActivity.ScriptType.ASSET;
        } else {
            return scriptType;
        }
    }

    public static void setScriptType(AsyncReactActivity.ScriptType scriptType) {
        Const.scriptType = scriptType;
    }

    public static String getScriptPath() {
        if (DEBUG) {
            return "android_1";
        } else {
            return scriptPath;
        }
    }

    public static void setScriptPath(String scriptPath) {
        Const.scriptPath = scriptPath;
    }

    public static String getScriptUrl() {
        if (DEBUG) {
            return "android_1";
        } else {
            return SCRIPT_URL;
        }
    }

    public static void setScriptUrl(String scriptUrl) {
        SCRIPT_URL = scriptUrl;
    }
}
