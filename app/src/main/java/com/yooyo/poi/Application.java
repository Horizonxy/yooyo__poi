package com.yooyo.poi;

import com.orhanobut.logger.Logger;
import com.yooyo.poi.di.component.DaggerAppComponent;
import com.yooyo.poi.di.module.ApiModule;
import com.yooyo.poi.di.module.AppModule;
import com.yooyo.poi.model.api.ApiService;
import javax.inject.Inject;
import dagger.Lazy;

public class Application extends android.app.Application {

    public static Application application;

    @Inject
    Lazy<ApiService> apiService;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().apiModule(new ApiModule()).appModule(new AppModule(this)).build().inject(this);
        application = this;
        Logger.init(getResources().getString(R.string.app_name));

    }

    public ApiService getApiService(){
        return apiService.get();
    }
}
