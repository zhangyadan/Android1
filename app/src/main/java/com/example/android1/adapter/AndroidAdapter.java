package com.example.android1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android1.R;
import com.example.android1.bean.AndroidBean;
import com.youth.banner.Banner;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by 张亚丹 on 2019/6/16.
 */

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.ViewHolder>{

    private ArrayList<AndroidBean.ResultsBean> list;
    private Context context;

    public AndroidAdapter(ArrayList<AndroidBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = View.inflate(context, R.layout.android_item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final AndroidBean.ResultsBean resultsBean = list.get(position);
        holder.tv_desc.setText(resultsBean.getDesc());
        holder.tv_who.setText(resultsBean.getWho());
        holder.tv_publishedAt.setText(resultsBean.getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_desc;
        private TextView tv_who;
        private TextView tv_publishedAt;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_who = itemView.findViewById(R.id.tv_who);
            tv_publishedAt = itemView.findViewById(R.id.tv_publishedAt);


        }
    }
}
