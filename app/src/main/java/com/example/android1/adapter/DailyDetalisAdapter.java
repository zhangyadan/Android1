package com.example.android1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android1.R;
import com.example.android1.bean.Bean;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/19.
 */

public class DailyDetalisAdapter extends RecyclerView.Adapter<DailyDetalisAdapter.ViewHolder>{

    private ArrayList<Bean> list;
    private Context context;

    public DailyDetalisAdapter(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final View view = View.inflate(context, R.layout.item_dailydetalis_layout, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_txt.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_txt;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_txt = itemView.findViewById(R.id.tv_txt);

        }
    }
}
