package com.example.rikaok1023.mvp.model.api.service;

import com.example.rikaok1023.bean.NewsLogin;
import com.example.rikaok1023.bean.NewsRegin;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    //登录
    @GET("user/login")
    Observable<NewsLogin> requestlogin(@Query("mobile")String mobile,@Query("password")String password);
    //注册
    @GET("user/reg")
    Observable<NewsRegin> requestregin(@Query("mobile")String mobile,@Query("password")String password);

}
