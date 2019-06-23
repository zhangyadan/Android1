package com.example.android1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.android1.R;
import com.example.android1.bean.NewslistBean;
import com.example.android1.bean.WechatBeans;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by 张亚丹 on 2019/6/10.
 */

public class WeChatAdapter extends RecyclerView.Adapter<WeChatAdapter.ViewHolder>{

    private ArrayList<NewslistBean> list;
    private Context context;

    public WeChatAdapter(ArrayList<NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.wechat_item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        NewslistBean newslistBean = list.get(position);
        holder.tv_title.setText(newslistBean.getTitle());
        holder.tv_description.setText(newslistBean.getDescription());
        holder.tv_ctime.setText(newslistBean.getCtime());
        Glide.with(context).load(newslistBean.getPicUrl()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.onclick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private TextView tv_ctime;
        private TextView tv_description;
        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_ctime = itemView.findViewById(R.id.tv_ctime);
            tv_description = itemView.findViewById(R.id.tv_description);
            img = itemView.findViewById(R.id.img);

        }
    }
    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public interface OnClick{
        void onclick(View view,int position);
    }
}
