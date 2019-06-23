package com.example.android1.base;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/6/8.
 */

public abstract class BasePresenter<M extends BaseModel,V extends BaseView> {

    private ArrayList<BaseModel> list = new ArrayList<>();

    protected M myModel;
    protected V myView;

    public void initModel(M myModel) {
        this.myModel = myModel;
        list.add(myModel);
    }



    public void attchView(V myView) {
        this.myView = myView;

    }

    public void destory(){
        if (list != null && list.size() > 0){
            for (BaseModel baseModel:list){
                baseModel.destory();
            }
        }

        if (myModel != null){
            myModel = null;
        }

       if (myView != null){
           myView = null;
       }

    }


}
