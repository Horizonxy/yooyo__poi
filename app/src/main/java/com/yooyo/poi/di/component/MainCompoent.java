package com.yooyo.poi.di.component;

import com.yooyo.poi.MainActivity;
import com.yooyo.poi.di.ActivityScope;
import com.yooyo.poi.di.module.LoginModule;
import com.yooyo.poi.di.module.MainModule;
import com.yooyo.poi.ui.activity.LoginActivity;

import dagger.Component;

@ActivityScope
@Component(modules = MainModule.class)
public interface MainCompoent {

    MainActivity inject(MainActivity mainActivity);
}
