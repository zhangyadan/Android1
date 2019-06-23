package com.example.android1.fragmeenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1.R;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public class V2EXFragment extends Fragment {
    private View view;
    private Toolbar ToolBar;
    private RecyclerView Recy;
    private AppBarLayout AppBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.v2ex_layot, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ToolBar = (Toolbar) view.findViewById(R.id.ToolBar);
        Recy = (RecyclerView) view.findViewById(R.id.Recy);
        AppBar = (AppBarLayout) view.findViewById(R.id.appBar);




    }
}
