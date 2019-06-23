package com.example.android1.fragmeenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1.R;
import com.example.android1.adapter.GankAdapter;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public class GankFragment extends Fragment {
    private View view;
    private TabLayout mTable;
    private ViewPager mVp;
    private ArrayList<Fragment> fm;
    private ArrayList<String> table;
    private GankAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gank_layot, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTable = (TabLayout) view.findViewById(R.id.Table);
        mVp = (ViewPager) view.findViewById(R.id.Vp);

        mTable.setupWithViewPager(mVp);
        fm = new ArrayList<>();
        fm.add(new AndroidFragment());
        fm.add(new IosFragmemt());
        fm.add(new ForepartFragmemt());
        fm.add(new WelfareFragmemt());
        table = new ArrayList<>();
        table.add("ANDTOID");
        table.add("IOS");
        table.add("前端");
        table.add("福利");
        adapter = new GankAdapter(getChildFragmentManager(), fm, table);
        mVp.setAdapter(adapter);


    }
}
