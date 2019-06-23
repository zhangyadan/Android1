package com.example.android1.base;

import com.example.android1.bean.ZhihuBean;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public interface BaseCallback<T> {
    void OnSuccess(T t);
    void OnFailed(String error);
}
