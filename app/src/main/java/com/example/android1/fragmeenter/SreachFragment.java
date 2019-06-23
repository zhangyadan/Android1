package com.example.android1.fragmeenter;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1.Apiservice;
import com.example.android1.R;
import com.example.android1.adapter.WeChatAdapter;
import com.example.android1.base.BaseFragment;
import com.example.android1.bean.NewslistBean;
import com.example.android1.bean.WechatBeans;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SreachFragment extends BaseFragment {

    @BindView(R.id.Recy)
    RecyclerView mRecy;
    private View view;
    private Unbinder unbinder;
    private ArrayList<NewslistBean> list;
    private WeChatAdapter adapter;
    private String word;
    private static final String TAG = "SreachFragment";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sreach;
    }

    @Override
    protected void initView(View inflate) {
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new WeChatAdapter(list, getActivity());
        mRecy.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        final String abc = getArguments().getString("abc");
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Apiservice.sreachurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        final Apiservice apiservice = retrofit.create(Apiservice.class);
        final Observable<WechatBeans> getsreach = apiservice.getsreach(abc);
        getsreach.observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WechatBeans>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WechatBeans wechatBeans) {
                        final List<NewslistBean> newslist = wechatBeans.getNewslist();
                        list.addAll(newslist);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }




}
