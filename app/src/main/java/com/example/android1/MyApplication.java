package com.example.android1;


import android.app.Application;

import com.example.android1.db.DaoMaster;
import com.example.android1.db.DaoSession;

/**
 * Created by 张亚丹 on 2019/6/10.
 */

public class MyApplication extends Application {

    private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initData();

    }

    private void initData() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "aa.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mDaoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession(){
        return mDaoSession;
    }
}
