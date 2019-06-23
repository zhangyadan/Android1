package com.example.android1.presenter;

import com.example.android1.base.BaseCallback;
import com.example.android1.base.BasePresenter;
import com.example.android1.bean.ZhihuBean;
import com.example.android1.model.LoginModel;
import com.example.android1.view.LoginView;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public class LoginPresenter extends BasePresenter<LoginModel,LoginView>{

    public void getData1(){
        if (myModel != null){
            myModel.getData(new BaseCallback<ZhihuBean>() {
                @Override
                public void OnSuccess(ZhihuBean zhihuBean) {
                    myView.Onsuccess(zhihuBean);
                }

                @Override
                public void OnFailed(String error) {
                    myView.OnFailed(error);
                }
            });
        }
    }


}
