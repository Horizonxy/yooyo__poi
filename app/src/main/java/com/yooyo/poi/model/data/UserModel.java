package com.yooyo.poi.model.data;

import com.yooyo.poi.model.bean.UserInfoVo;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

public class UserModel {

    public Subscription userLogin(String name, String pwd, Action0 onSubscribe, Subscriber<UserInfoVo> subscriber) {
        return Observable.create(new Observable.OnSubscribe<UserInfoVo>() {
            @Override
            public void call(Subscriber<? super UserInfoVo> subscriber) {
                subscriber.onNext(new UserInfoVo());
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).doOnSubscribe(onSubscribe).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }
}
