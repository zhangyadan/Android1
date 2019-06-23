package com.example.android1.fragmeenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1.Apiservice;
import com.example.android1.R;
import com.example.android1.adapter.DailyAdapter;
import com.example.android1.bean.ZhihuBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张亚丹 on 2019/6/9.
 */

public class DailyFragment extends Fragment {
    private View view;
    private RecyclerView mRecy;
    private ArrayList<ZhihuBean.TopStoriesBean> artlist;
    private ArrayList<ZhihuBean.TopStoriesBean> bannerlist;
    private DailyAdapter adapter;
    private static final String TAG = "DailyFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.daily_layout, null);
        initView(view);
        initBanner();
        return view;
    }

    private void initBanner() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Apiservice.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apiservice apiservice = retrofit.create(Apiservice.class);
        Call<ZhihuBean> geturl = apiservice.geturl();
        geturl.enqueue(new Callback<ZhihuBean>() {
            @Override
            public void onResponse(Call<ZhihuBean> call, Response<ZhihuBean> response) {
                List<ZhihuBean.TopStoriesBean> top_stories = response.body().getTop_stories();
                artlist.addAll(top_stories);
                bannerlist.addAll(top_stories);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ZhihuBean> call, Throwable t) {
                Log.i(TAG, "onFailure: "+t.getMessage());
            }
        });

    }

    private void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.Recy);

        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        artlist = new ArrayList<>();
        bannerlist = new ArrayList<>();
        adapter = new DailyAdapter(artlist, bannerlist, getActivity());
        mRecy.setAdapter(adapter);

    }
}
