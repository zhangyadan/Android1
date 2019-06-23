package com.example.android1.app;

import android.os.Environment;


import com.example.android1.base.BaseApplication;

import java.io.File;

/**
 * 项目配置所有常量
 */
public interface AppConstants {

    //选中Fragment页面
    public static final int TYPE_ZHIHU= 0;
    public static final int TYPE_WECHAT= 1;
    public static final int TYPE_GANK= 2;
    public static final int TYPE_GOLD= 3;
    public static final int TYPE_V2EX= 4;
    public static final int TYPE_COLLECT= 5;
    public static final int TYPE_SETTINGS= 6;
    public static final int TYPE_ABOUT= 7;

    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "code" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY="com.baidu.geek.fileprovider";

    //网络缓存的地址
    String PATH_DATA = BaseApplication.getInstance().getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";

}
