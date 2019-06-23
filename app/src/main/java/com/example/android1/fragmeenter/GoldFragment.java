package com.example.android1.fragmeenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android1.GoldDatalisActivity;
import com.example.android1.R;
import com.example.android1.adapter.VpGoldAdapter;
import com.example.android1.base.BaseFragment;
import com.example.android1.bean.GoldBean;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public class GoldFragment extends BaseFragment {

    private String[] type = new String[]{"all","Android","ios","休息视频","拓展资源","瞎推荐","前端"};

    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.Table)
    TabLayout mTable;
    @BindView(R.id.Vp)
    ViewPager mVp;
    private View view;
    private ArrayList<String> title;
    private ArrayList<Fragment> fm;
    private VpGoldAdapter adapter;
    private ArrayList<GoldBean> list;

    @Override
    protected int getLayoutId() {
        return R.layout.gold_layot;
    }
    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if (i % 3 == 0){
               GoldBean goldBean = new GoldBean(type[i],true);
                list.add(goldBean);
            }else {
                GoldBean goldBean = new GoldBean(type[i],false);
                list.add(goldBean);
            }

        }
        title = new ArrayList<>();
        fm = new ArrayList<>();
    }

    @Override
    protected void initData() {
        super.initData();
        for (int i = 0; i < list.size(); i++) {
            final GoldBean goldBean = list.get(i);
            if (goldBean.getSearch()){
                fm.add(new GoldDatailsFragment(goldBean.getName()));
                title.add(goldBean.getName());
            }
        }
        adapter = new VpGoldAdapter(getChildFragmentManager(), title, fm);
        mVp.setAdapter(adapter);
        mTable.setupWithViewPager(mVp);
    }

    @Override
    protected void initListener() {
        super.initListener();

        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(getContext(), GoldDatalisActivity.class);
                intent.putExtra("list",list);
                startActivityForResult(intent,100);

            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == Activity.RESULT_OK){
            list = (ArrayList<GoldBean>) data.getSerializableExtra("list");
            fm.clear();
            title.clear();
            initData();

        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}
