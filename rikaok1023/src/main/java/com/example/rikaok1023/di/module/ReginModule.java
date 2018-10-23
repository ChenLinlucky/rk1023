package com.example.rikaok1023.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.example.rikaok1023.mvp.contract.ReginContract;
import com.example.rikaok1023.mvp.model.ReginModel;


@Module
public class ReginModule {
    private ReginContract.View view;

    /**
     * 构建ReginModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ReginModule(ReginContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ReginContract.View provideReginView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ReginContract.Model provideReginModel(ReginModel model) {
        return model;
    }
}