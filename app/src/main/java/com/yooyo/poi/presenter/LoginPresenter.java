package com.yooyo.poi.presenter;

import com.yooyo.poi.model.bean.UserInfoVo;
import com.yooyo.poi.model.data.UserModel;
import com.yooyo.poi.ui.iview.LoginViewListener;
import com.yooyo.poi.util.SimpleSubscriber;
import rx.Subscription;
import rx.functions.Action0;

public class LoginPresenter extends BasePresenter {

    private LoginViewListener view;
    private UserModel model;

    public LoginPresenter(LoginViewListener view, UserModel model) {
        this.view = view;
        this.model = model;
    }

    public void login(){
        Subscription subscription = model.userLogin(view.getName(), view.getPwd(), new Action0() {
            @Override
            public void call() {
                view.setBtnEnable(false);
            }
        }, new SimpleSubscriber<UserInfoVo>() {
            @Override
            public void onNextRx(UserInfoVo user) {
                if(user != null) {
                    view.onSuccess();
                } else {
                    view.onFailure();
                    view.setBtnEnable(true);
                }
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                view.onFailure();
                view.setBtnEnable(true);
            }
        });
        addSubscription(subscription);
    }
}
