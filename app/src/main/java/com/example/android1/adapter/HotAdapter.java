package com.example.android1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.android1.R;
import com.example.android1.bean.HotBeans;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/9.
 */

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {

    private ArrayList<HotBeans.RecentBean> list;
    private Context context;

    public HotAdapter(ArrayList<HotBeans.RecentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.hot_item_layout, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HotBeans.RecentBean recentBean = list.get(position);
        holder.tv_title.setText(recentBean.getTitle());
//        RoundedCorners roundedCorners = new RoundedCorners(30);
//        RequestOptions override = RequestOptions.bitmapTransform(roundedCorners).override(100, 100);
//        Glide.with(context).load(recentBean.getUrl()).apply(override).into(holder.img);
        Glide.with(context).load(recentBean.getThumbnail()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv_title = itemView.findViewById(R.id.tv_title);

        }
    }
}
