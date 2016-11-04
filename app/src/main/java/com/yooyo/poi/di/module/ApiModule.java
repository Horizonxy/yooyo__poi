package com.yooyo.poi.di.module;


import com.yooyo.poi.model.api.ApiService;
import com.yooyo.poi.util.RetrofitUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApiModule {

    @Singleton
    @Provides
    public ApiService provideApiService(){
        return  RetrofitUtil.createRetrofit().create(ApiService.class);
    }
}
