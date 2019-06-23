package com.example.android1.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public abstract class BaseFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(),null);
        ButterKnife.bind(this, inflate);
        initMvp();
        initView(inflate);
        initData();
        initListener();
        return inflate;

    }

    protected void initMvp() {

    }

    protected void initView(View inflate) {

    }

    protected void initData() {

    }

    protected void initListener() {

    }
    protected abstract int getLayoutId();




}
