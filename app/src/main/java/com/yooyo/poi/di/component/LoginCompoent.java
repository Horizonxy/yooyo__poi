package com.yooyo.poi.di.component;

import com.yooyo.poi.di.ActivityScope;
import com.yooyo.poi.di.module.LoginModule;
import com.yooyo.poi.ui.activity.LoginActivity;

import dagger.Component;

@ActivityScope
@Component(modules = LoginModule.class)
public interface LoginCompoent {

    LoginActivity inject(LoginActivity loginActivity);
}
