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
import com.example.android1.bean.SpBeans;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/9.
 */

public class SpAdapter extends RecyclerView.Adapter<SpAdapter.ViewHolder>{
    private ArrayList<SpBeans.DataBean> list;
    private Context context;

    public SpAdapter(ArrayList<SpBeans.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.sp_item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SpBeans.DataBean dataBean = list.get(position);
        holder.tv_title.setText(dataBean.getName());
        holder.tv_description.setText(dataBean.getDescription());
        RoundedCorners roundedCorners = new RoundedCorners(10);
        RequestOptions override = RequestOptions.bitmapTransform(roundedCorners).override(150, 150);
        Glide.with(context).load(dataBean.getThumbnail()).apply(override).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_description;
        private ImageView img;
        private TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
