package com.example.android1.base;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public abstract class BaseMvpFragment<P extends BasePresenter,M extends  BaseModel,V extends BaseView>  extends BaseFragment{

    protected P myPresenter;

    @Override
    protected void initMvp() {
        myPresenter = initPresenter();
        if (myPresenter != null){
            myPresenter.attchView(initMvpView());
            myPresenter.initModel(initMvpModel());
        }
    }

    protected abstract M initMvpModel();

    protected abstract V initMvpView();

    protected abstract P initPresenter();


}
