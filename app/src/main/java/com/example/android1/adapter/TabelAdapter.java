package com.example.android1.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/9.
 */

public class TabelAdapter extends FragmentStatePagerAdapter{
    private ArrayList<Fragment> fm;
    private ArrayList<String> table;

    public TabelAdapter(FragmentManager fm, ArrayList<Fragment> f, ArrayList<String> table) {
        super(fm);
        this.fm = f;
        this.table = table;
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
        return table.get(position);
    }
}
