package com.example.android1.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public abstract class BaseModel {

    CompositeDisposable mCompositeDisposablem = new CompositeDisposable();

    public void destory() {
        mCompositeDisposablem.clear();
    }
}
