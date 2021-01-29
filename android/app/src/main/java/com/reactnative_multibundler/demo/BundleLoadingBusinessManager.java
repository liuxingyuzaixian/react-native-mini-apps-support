package com.reactnative_multibundler.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.reactnative_multibundler.FileUtils;
import com.reactnative_multibundler.demo.bean.BundleModel;

import java.util.List;

public class BundleLoadingBusinessManager {
    private static BundleLoadingBusinessManager instance;
    private int currentIndex = 0;

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public static BundleLoadingBusinessManager getInstance() {
        if (instance == null) {
            instance = new BundleLoadingBusinessManager();
        }
        return instance;
    }

    public List<BundleModel> getJsonList() {
        String json = FileUtils.getJson("bundleDataMock.json", MainApplication.getContext());
        return new Gson().fromJson(json, new TypeToken<List<BundleModel>>() {
        }.getType());
    }

    public BundleModel getCurrentBundleModel() {
        return getJsonList().get(currentIndex);
    }
}
