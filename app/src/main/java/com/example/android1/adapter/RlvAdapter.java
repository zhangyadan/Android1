package com.example.android1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.android1.R;
import com.example.android1.bean.GoldBean;
import com.example.android1.callback.TouchCallBack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 张亚丹 on 2019/6/18.
 */

public class RlvAdapter extends RecyclerView.Adapter implements TouchCallBack{

    private ArrayList<GoldBean> list;
    private Context context;

    public RlvAdapter(ArrayList<GoldBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = View.inflate(context, R.layout.item_rlv_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        final GoldBean goldBean = list.get(position);
        holder1.tv_name.setText(goldBean.getName());
        holder1.swich.setChecked(goldBean.getSearch());
        holder1.swich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                goldBean.setSearch(b);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void OnItemMove(int fromPosition, int toPosition) {
        //上下交换位置
        Collections.swap(list,fromPosition,toPosition);
        //局部刷新
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void OnItemDelete(int position) {
        list.remove(position);
        notifyItemRemoved(position);

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private Switch swich;

        public ViewHolder(View itemView) {
            super(itemView);
            swich = itemView.findViewById(R.id.swich);
            tv_name = itemView.findViewById(R.id.tv_name);

        }
    }
}
