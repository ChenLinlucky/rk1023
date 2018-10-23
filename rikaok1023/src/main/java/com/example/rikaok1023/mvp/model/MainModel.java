package com.example.rikaok1023.mvp.model;

import android.app.Application;

import com.example.rikaok1023.bean.NewsLogin;
import com.example.rikaok1023.mvp.model.api.service.ApiService;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.example.rikaok1023.mvp.contract.MainContract;

import io.reactivex.Observable;


@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<NewsLogin> requestlogin(String mobile, String password) {
        Observable<NewsLogin> login = mRepositoryManager.obtainRetrofitService(ApiService.class).requestlogin(mobile, password);
        return login;
    }
}