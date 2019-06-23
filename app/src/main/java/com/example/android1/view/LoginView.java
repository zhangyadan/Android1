package com.example.android1.view;

import com.example.android1.base.BaseView;
import com.example.android1.bean.ZhihuBean;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public interface LoginView extends BaseView {
    void Onsuccess(ZhihuBean zhihuBean);
    void OnFailed(String error);
}
