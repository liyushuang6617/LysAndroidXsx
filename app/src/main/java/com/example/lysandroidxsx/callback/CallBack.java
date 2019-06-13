package com.example.lysandroidxsx.callback;

import com.example.lysandroidxsx.bean.ArtBean;

public interface CallBack {

    void onSuccess(ArtBean bean);

    void onFail(String msg);
}
