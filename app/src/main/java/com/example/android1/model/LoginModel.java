package com.example.android1.model;

import com.example.android1.Apiservice;
import com.example.android1.base.BaseCallback;
import com.example.android1.base.BaseModel;
import com.example.android1.bean.ZhihuBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public class LoginModel extends BaseModel{

    public void getData(final BaseCallback<ZhihuBean> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Apiservice.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Apiservice apiservice = retrofit.create(Apiservice.class);
        Call<ZhihuBean> geturl = apiservice.geturl();
        geturl.enqueue(new Callback<ZhihuBean>() {
            @Override
            public void onResponse(Call<ZhihuBean> call, Response<ZhihuBean> response) {
                callback.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ZhihuBean> call, Throwable t) {
                callback.OnFailed(t.getMessage());
            }
        });
    }

}
