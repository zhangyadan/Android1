package com.example.android1.base;

import android.app.Application;

/**
 * Created by 张亚丹 on 2019/6/9.
 */

public class BaseApplication extends Application{

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }

    public static BaseApplication getInstance(){
        return baseApplication;
    }
}
