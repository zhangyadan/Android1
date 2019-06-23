package com.example.android1.activity;

import android.bluetooth.le.AdvertiseData;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.android1.R;
import com.example.android1.adapter.DailyDetalisAdapter;
import com.example.android1.bean.Bean;

import java.util.ArrayList;

public class DailyDetailsActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private RecyclerView mRecy;
    private AppBarLayout mAppBar;
    private DailyDetalisAdapter adapter;
    private ArrayList<Bean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_details);
        initView();
        initTool();
        initData();
    }

    private void initData() {

        for (int i = 0; i < 20; i++) {
            list.add(new Bean("安安"+i));
            adapter.notifyDataSetChanged();
        }
    }

    private void initTool() {

        mToolBar.setTitle("日报详情");
        setSupportActionBar(mToolBar);
    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.ToolBar);
        mRecy = (RecyclerView) findViewById(R.id.Recy);
        mAppBar = (AppBarLayout) findViewById(R.id.appBar);


        mRecy.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new DailyDetalisAdapter(list, this);
        mRecy.setAdapter(adapter);
    }
}
