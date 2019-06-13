package com.example.lysandroidxsx.presenter;

import com.example.lysandroidxsx.bean.ArtBean;
import com.example.lysandroidxsx.callback.CallBack;
import com.example.lysandroidxsx.model.MyM;
import com.example.lysandroidxsx.view.MyV;

public class MyPImple implements MyP, CallBack {

    private MyM myM;
    private MyV myV;

    public MyPImple(MyM myM, MyV myV) {
        this.myM = myM;
        this.myV = myV;
    }

    @Override
    public void getData() {
        if (myM != null) {
            myM.getData(this);
        }
    }

    @Override
    public void onSuccess(ArtBean bean) {
        myV.onSuccess(bean);
    }

    @Override
    public void onFail(String msg) {
        myV.onFail(msg);
    }
}
