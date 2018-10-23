package com.example.rikaok1023.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.rikaok1023.di.module.MainModule;

import com.jess.arms.di.scope.ActivityScope;
import com.example.rikaok1023.mvp.ui.activity.MainActivity;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}