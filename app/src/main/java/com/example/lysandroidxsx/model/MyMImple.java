package com.example.lysandroidxsx.model;

import com.example.lysandroidxsx.api.MyService;
import com.example.lysandroidxsx.bean.ArtBean;
import com.example.lysandroidxsx.callback.CallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyMImple implements MyM {
    @Override
    public void getData(final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyService myService = retrofit.create(MyService.class);
        Observable<ArtBean> art = myService.art();
        art.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArtBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArtBean bean) {
                        if (bean != null) {
                            if (bean.getCode() == 200) {
                                callBack.onSuccess(bean);
                            } else {
                                callBack.onFail(bean.getMessage());
                            }
                        } else {
                            callBack.onFail("失败");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
