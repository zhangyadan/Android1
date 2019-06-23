package com.example.android1.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.service.autofill.LuhnChecksumValidator;
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
import com.example.android1.bean.ZhihuBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/9.
 */

public class DailyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<ZhihuBean.TopStoriesBean> list;
    private ArrayList<ZhihuBean.TopStoriesBean> bannerlist;
    private Context context;

    public DailyAdapter(ArrayList<ZhihuBean.TopStoriesBean> list, ArrayList<ZhihuBean.TopStoriesBean> bannerlist, Context context) {
        this.list = list;
        this.bannerlist = bannerlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0){
            View view = View.inflate(context, R.layout.banner_layout, null);
            return new ViewHolder1(view);
        }else {
            View view = View.inflate(context, R.layout.item_layout, null);
            return new ViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == 0){
            ViewHolder1 holder1 = (ViewHolder1) holder;

            holder1.tv.setText(list.get(position).getTitle());
            holder1.banner.setImages(bannerlist).setImageLoader(new Imag()).start();
        }else {
            ViewHolder2 holder2 = (ViewHolder2) holder;
            if (bannerlist.size() > 0){
                position = position-1;
            }
            holder2.tv_title.setText(list.get(position).getTitle());
//            RoundedCorners roundedCorners = new RoundedCorners(30);
//            RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);
//            Glide.with(context).load(list.get(position).getImage()).apply(requestOptions).into(((ViewHolder2) holder).img);
            Glide.with(context).load(list.get(position).getImage()).into(holder2.img);
        }
    }

    @Override
    public int getItemCount() {
        if (bannerlist.size()>0){
            return bannerlist.size()+1;
        }else {
            return bannerlist.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (bannerlist.size() > 0 && position == 0){
            return 0;
        }else {
            return 1;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder{

        private TextView tv;
        private Banner banner;

        public ViewHolder1(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.Banner);
            tv = itemView.findViewById(R.id.tv);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{

        private TextView tv_title;
        private ImageView img;

        public ViewHolder2(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            img = itemView.findViewById(R.id.img);
        }
    }
    class Imag extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            ZhihuBean.TopStoriesBean path1 = (ZhihuBean.TopStoriesBean) path;
            Glide.with(context).load(path1.getImage()).into(imageView);
        }
    }
}
