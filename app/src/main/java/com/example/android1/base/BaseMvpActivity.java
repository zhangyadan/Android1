package com.example.android1.base;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public abstract class BaseMvpActivity<P extends BasePresenter,M extends BaseModel,V extends BaseView> extends BaseActivity{

    protected P mypresenter;

    protected void initMvp(){
        mypresenter = initMvpPresenter();
        if (mypresenter != null){
            mypresenter.initModel(initMvpModel());
            mypresenter.attchView(initMvpView());
        }
    }

    protected abstract V initMvpView();

    protected abstract M initMvpModel();

    protected abstract P initMvpPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mypresenter != null){
            mypresenter.destory();
            mypresenter = null;
        }
    }
}
