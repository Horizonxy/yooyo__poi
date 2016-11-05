package com.yooyo.poi.di.module;

import android.app.Activity;

import com.yooyo.poi.di.ActivityScope;
import com.yooyo.poi.model.data.UserModel;
import com.yooyo.poi.presenter.LoginPresenter;
import com.yooyo.poi.ui.iview.BaseViewListener;
import com.yooyo.poi.ui.iview.LoginViewListener;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private Activity activity;

    public LoginModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public LoginPresenter provideLoginPresenter (){
        return new LoginPresenter((LoginViewListener) activity, new UserModel());
    }
}
