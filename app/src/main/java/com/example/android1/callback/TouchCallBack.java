package com.example.android1.callback;

/**
 * Created by 张亚丹 on 2019/6/18.
 */

public interface TouchCallBack {
    //上下移动
    void OnItemMove(int fromPosition,int toPosition);
    //左右删除
    void OnItemDelete(int position);
}
