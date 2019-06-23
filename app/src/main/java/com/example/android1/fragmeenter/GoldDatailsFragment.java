package com.example.android1.fragmeenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1.R;
@SuppressLint("ValidFragment")
public class GoldDatailsFragment extends Fragment {

    private String name;
    @SuppressLint("ValidFragment")
    public GoldDatailsFragment(String name) {
        this.name = name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gold_datails, container, false);
    }

}
