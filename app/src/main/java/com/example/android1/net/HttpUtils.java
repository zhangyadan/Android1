package com.example.android1.net;
import com.example.android1.app.AppConstants;
import com.example.android1.utils.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by $lzj on 2019/6/4.
 */
public class HttpUtils {

    private final Retrofit.Builder builder;

    private HttpUtils(){
        builder = new Retrofit.Builder()
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    private OkHttpClient getOkHttpClient() {
        //设置本地缓存文件
        File cacheFile = new File(AppConstants.PATH_CACHE);
        //设置缓存文件大小
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        return new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new MyCacheinterceptor())
                .addNetworkInterceptor(new MyCacheinterceptor())
                .connectTimeout(20,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }


    /**
     * 网络缓存
     */
    private class MyCacheinterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //这里就是说判读我们的网络条件，要是有网络的话我么就直接获取网络上
            // 面的数据，要是没有网络的话我么就去缓存里面取数据
            if (!SystemUtil.isNetworkConnected()) {//判断是否有网，没网加载缓存数据
                request = request
                        .newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response originalResponse = chain.proceed(request);//发起网络请求
            if (SystemUtil.isNetworkConnected()) {//有网，加载网络数据
                int maxAge = 0;
                // 有网络时, 不缓存, 最大保存时长为0
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {//没网，加载缓存数据
                //s秒
                int maxStale = 60 * 60 * 24;
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        //这里的设置的是我们的没有网络的缓存时间，
                        // 想设置多少就是多少。
                        .header("Cache-Control", "public, only-if-cached," +
                                " max-stale=" + maxStale)
                        .build();
            }

        }
    }

    private class Myinterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {

            //1.获取所有请求对象：获取   设置
            Request request = chain.request();
            HttpUrl url = request.url();
            String method = request.method();
            Headers headers = request.headers();
            RequestBody body = request.body();
            Request.Builder builder = request.newBuilder();

            //2.发起网络请求
            Response response = chain.proceed(request);

            //3.获取响应数据：获取  设置
            int code = response.code();
            String message = response.message();
            Protocol protocol = response.protocol();
            ResponseBody body1 = response.body();
            Headers headers1 = response.headers();
            Response.Builder builder1 = response.newBuilder();
            builder1.body(body1);

            return response;
        }
    }

    private static volatile HttpUtils httpUtils;

    public static HttpUtils getInstance() {
        if (httpUtils == null){
            synchronized (HttpUtils.class){
                if (httpUtils == null){
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    //获取网络请求的是对应实体对象
    public <T> T getApiServer(String baseUrl,Class<T> tClass){
       return builder.baseUrl(baseUrl).build().create(tClass);
    }
}
