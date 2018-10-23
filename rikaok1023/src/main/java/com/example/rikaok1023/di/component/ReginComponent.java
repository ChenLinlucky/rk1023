package com.example.rikaok1023.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.rikaok1023.di.module.ReginModule;

import com.jess.arms.di.scope.ActivityScope;
import com.example.rikaok1023.mvp.ui.activity.ReginActivity;

@ActivityScope
@Component(modules = ReginModule.class, dependencies = AppComponent.class)
public interface ReginComponent {
    void inject(ReginActivity activity);
}