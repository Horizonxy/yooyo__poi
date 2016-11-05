package com.yooyo.poi.di.module;

import android.app.Activity;

import com.yooyo.poi.di.ActivityScope;
import com.yooyo.poi.model.data.RouteModel;
import com.yooyo.poi.presenter.RoutePresenter;
import com.yooyo.poi.ui.iview.MainViewListener;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private Activity activity;

    public MainModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public RoutePresenter provideRoutePresenter(){
        return new RoutePresenter(new RouteModel(), (MainViewListener) activity);
    }
}
