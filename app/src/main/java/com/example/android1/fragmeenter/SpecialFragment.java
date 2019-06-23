package com.example.android1.fragmeenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1.Apiservice;
import com.example.android1.R;
import com.example.android1.adapter.SpAdapter;
import com.example.android1.bean.SpBeans;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张亚丹 on 2019/6/9.
 */

public class SpecialFragment extends Fragment {
    private View view;
    private RecyclerView mRecy;
    private ArrayList<SpBeans.DataBean> list;
    private SpAdapter adapter;
    private static final String TAG = "SpecialFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sp_alyout, null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Apiservice.spurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apiservice apiservice = retrofit.create(Apiservice.class);
        Call<SpBeans> getsp = apiservice.getsp();
        getsp.enqueue(new Callback<SpBeans>() {
            @Override
            public void onResponse(Call<SpBeans> call, Response<SpBeans> response) {
                List<SpBeans.DataBean> data = response.body().getData();
                list.addAll(data);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SpBeans> call, Throwable t) {
                Log.i(TAG, "onFailure: "+t.getMessage());
            }
        });

    }

    private void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.Recy);

        mRecy.setLayoutManager(new GridLayoutManager(getActivity(),2));
        list = new ArrayList<>();
        adapter = new SpAdapter(list, getActivity());
        mRecy.setAdapter(adapter);


    }
}
