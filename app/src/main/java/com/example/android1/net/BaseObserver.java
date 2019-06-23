package com.example.android1.net;


import com.example.android1.utils.Logger;
import com.example.android1.utils.ToastUtil;

import io.reactivex.Observer;

/**
 * Created by $lzj on 2019/6/4.
 */
public abstract class BaseObserver<T>  implements Observer<T> {

    private final String TAG = getClass().getName();

    @Override
    public void onError(Throwable e) {
        Logger.logD(TAG, "onError: "+e.toString());
        ToastUtil.showShort("数据加载失败");
    }

    @Override
    public void onComplete() {
        Logger.logD(TAG, "onComplete");
    }
}
