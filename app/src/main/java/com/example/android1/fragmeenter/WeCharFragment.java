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
import android.widget.Toast;

import com.example.android1.Apiservice;
import com.example.android1.R;
import com.example.android1.adapter.WeChatAdapter;
import com.example.android1.bean.NewslistBean;
import com.example.android1.bean.WechatBeans;
import com.example.android1.util.DbUtls;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public class WeCharFragment extends Fragment {
    private View view;
    private RecyclerView mRecy;
    private ArrayList<NewslistBean> list;
    private WeChatAdapter adapter;
    private static final String TAG = "WeCharFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wechat_layot, null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        new Thread(){
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Apiservice.weurl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Apiservice apiservice = retrofit.create(Apiservice.class);
                Call<WechatBeans> getweurl = apiservice.getweurl();
                getweurl.enqueue(new Callback<WechatBeans>() {
                    @Override
                    public void onResponse(Call<WechatBeans> call, Response<WechatBeans> response) {
                        List<NewslistBean> newslist = response.body().getNewslist();
                        list.addAll(newslist);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<WechatBeans> call, Throwable t) {
                        Log.i(TAG, "onFailure: "+t.getMessage());
                    }
                });
            }
        }.start();
    }

    private void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.Recy);

        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new WeChatAdapter(list, getActivity());
        mRecy.setAdapter(adapter);

        adapter.setOnClick(new WeChatAdapter.OnClick() {
            @Override
            public void onclick(View view, int position) {
                NewslistBean newslistBean = list.get(position);
                DbUtls.insert(newslistBean);
                adapter.notifyDataSetChanged();
                Toast.makeText(getActivity(), "插入成功", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
