package com.example.android1.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.android1.bean.GoldBean;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/17.
 */

public class VpGoldAdapter extends FragmentStatePagerAdapter{

    private ArrayList<String> title;
    private ArrayList<Fragment> fm;

    public VpGoldAdapter(FragmentManager fm, ArrayList<String> title, ArrayList<Fragment> f) {
        super(fm);
        this.title = title;
        this.fm = f;
    }

    @Override
    public Fragment getItem(int position) {
        return fm.get(position);
    }

    @Override
    public int getCount() {
        return fm.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
