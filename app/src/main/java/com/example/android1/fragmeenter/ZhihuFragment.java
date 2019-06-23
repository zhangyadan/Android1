package com.example.android1.fragmeenter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.android1.R;
import com.example.android1.adapter.TabelAdapter;
import com.example.android1.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public class ZhihuFragment extends BaseFragment {
    @BindView(R.id.Table)
    TabLayout mTable;
    @BindView(R.id.Vp)
    ViewPager mVp;
    private View view;
    private Unbinder unbinder;
    private ArrayList<Fragment> fm;
    private ArrayList<String> table;
    private TabelAdapter tableadapter;

    @Override
    protected int getLayoutId() {
        return R.layout.zhihu_layot;
    }



    @Override
    protected void initView(View inflate) {
        fm = new ArrayList<>();
        fm.add(new DailyFragment());
        fm.add(new ThemeFragment());
        fm.add(new SpecialFragment());
        fm.add(new HotFragment());
        table = new ArrayList<>();
        table.add("日报");
        table.add("主题");
        table.add("专栏");
        table.add("热门");
        tableadapter = new TabelAdapter(getActivity().getSupportFragmentManager(), fm, table);
        mVp.setAdapter(tableadapter);
        mTable.setupWithViewPager(mVp);
    }



}
