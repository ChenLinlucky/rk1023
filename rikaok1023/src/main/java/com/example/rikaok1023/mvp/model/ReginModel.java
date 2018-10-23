package com.example.rikaok1023.mvp.model;

import android.app.Application;

import com.example.rikaok1023.bean.NewsRegin;
import com.example.rikaok1023.mvp.model.api.service.ApiService;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.example.rikaok1023.mvp.contract.ReginContract;

import io.reactivex.Observable;


@ActivityScope
public class ReginModel extends BaseModel implements ReginContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public ReginModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<NewsRegin> regin(String mobile, String password) {
        Observable<NewsRegin> regin = mRepositoryManager.obtainRetrofitService(ApiService.class).requestregin(mobile, password);
        return regin;
    }
}