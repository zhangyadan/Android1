package com.example.android1.util;

import com.example.android1.MyApplication;
import com.example.android1.bean.NewslistBean;
import com.example.android1.db.DaoSession;

import java.util.List;

/**
 * Created by 张亚丹 on 2019/6/10.
 */

public class DbUtls {

    public static void insert(NewslistBean newslistBean){
        DaoSession daoSession = MyApplication.getDaoSession();
        daoSession.insert(newslistBean);
    }

    public static List<NewslistBean> qurryAll(){
        DaoSession daoSession = MyApplication.getDaoSession();
        return daoSession.loadAll(NewslistBean.class);
    }

}
