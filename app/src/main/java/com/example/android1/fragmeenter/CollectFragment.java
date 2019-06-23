package com.example.android1.fragmeenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1.R;
import com.example.android1.adapter.CollectAdapter;
import com.example.android1.bean.NewslistBean;
import com.example.android1.util.DbUtls;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public class CollectFragment extends Fragment {
    private View view;
    private RecyclerView mRecy;
    private ArrayList<NewslistBean> list;
    private CollectAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collect_layot, null);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        List<NewslistBean> newslistBeans = DbUtls.qurryAll();
        list.addAll(newslistBeans);
        adapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.Recy);

        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new CollectAdapter(list, getActivity());
        mRecy.setAdapter(adapter);

    }
}
