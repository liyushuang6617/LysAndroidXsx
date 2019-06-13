package com.example.lysandroidxsx.api;

import com.example.lysandroidxsx.bean.ArtBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyService {

    public String url = "https://api.apiopen.top/";

    @GET("getJoke")
    Observable<ArtBean> art();
}
