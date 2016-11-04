package com.yooyo.poi.di.module;

import com.yooyo.poi.Application;

import dagger.Module;

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
        this.application = application;
    }

}
