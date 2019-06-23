package com.example.android1.fragmeenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1.R;
import com.example.android1.adapter.AndroidAdapter;
import com.example.android1.bean.AndroidBean;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/10.
 */

public class AndroidFragment extends Fragment {
    private View view;
    private RecyclerView mRecy;
    private ArrayList<AndroidBean.ResultsBean> list;
    private AndroidAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.android_layout, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.Recy);

        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new AndroidAdapter(list, getActivity());



    }
}
