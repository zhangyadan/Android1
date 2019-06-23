package com.example.android1;

import com.example.android1.bean.HotBeans;
import com.example.android1.bean.SpBeans;
import com.example.android1.bean.WechatBeans;
import com.example.android1.bean.ZhihuBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public interface Apiservice {

    //http://news-at.zhihu.com/api/4/news/hot
    // http://news-at.zhihu.com/api/4/news/latest
    //http://news-at.zhihu.com/api/4/sections
    //http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1

    String weurl = "http://api.tianapi.com/";
    String sreachurl = "http://api.tianapi.com/";
    String url = "http://news-at.zhihu.com/";
    String spurl = "http://news-at.zhihu.com/";
    String hot = "http://news-at.zhihu.com";

    @GET("api/4/news/latest")
    Call<ZhihuBean> geturl();

    @GET("api/4/sections")
    Call<SpBeans> getsp();

    @GET("/api/4/news/hot")
    Call<HotBeans> gethot();

    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Call<WechatBeans> getweurl();

    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WechatBeans> getsreach(@Query("word") String word);

}
