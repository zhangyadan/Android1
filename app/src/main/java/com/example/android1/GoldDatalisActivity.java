package com.example.android1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.example.android1.adapter.RlvAdapter;
import com.example.android1.base.BaseActivity;
import com.example.android1.bean.GoldBean;
import com.example.android1.callback.SimpleItemTouchHelpCallBack;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoldDatalisActivity extends BaseActivity {

    @BindView(R.id.Rlv)
    RecyclerView mRlv;
    private RlvAdapter adapter;
    private ArrayList<GoldBean> mAbcm;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gold_datalis;
    }

    @Override
    protected void initView() {
        mAbcm = (ArrayList<GoldBean>) getIntent().getSerializableExtra("list");
        mRlv = (RecyclerView) findViewById(R.id.Rlv);

        mRlv.setLayoutManager(new LinearLayoutManager(this));
      //  mAbcm = new ArrayList<>();
        adapter = new RlvAdapter(mAbcm, this);
        mRlv.setAdapter(adapter);

        // 为RecycleView添加ItemTouchHelper
        SimpleItemTouchHelpCallBack simpleItem = new SimpleItemTouchHelpCallBack(adapter);
        final ItemTouchHelper helper = new ItemTouchHelper(simpleItem);
        helper.attachToRecyclerView(mRlv);
    }
}
