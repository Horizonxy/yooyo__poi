package com.yooyo.poi.model.data;

import com.yooyo.poi.Constants;
import com.yooyo.poi.model.bean.RouteVo;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class RouteModel {

    public Subscription getRouteList(int pageNo, Action1<List<RouteVo>> onNext, Action1<Throwable> onError, Subscriber<List<RouteVo>> subscriber) {
        return Observable.create(new Observable.OnSubscribe<List<RouteVo>>() {
            @Override
            public void call(Subscriber<? super List<RouteVo>> subscriber) {
                List<RouteVo> list = new ArrayList<RouteVo>();
                if(pageNo == 10){
                    subscriber.onNext(list);
                } else {
                    for (int i = (pageNo - 1) * Constants.PAGE_SIZE; i < pageNo * Constants.PAGE_SIZE; i++) {
                        RouteVo routeVo = new RouteVo();
                        routeVo.setRoute_name("xian lu " + i);
                        list.add(routeVo);
                    }
                    subscriber.onNext(list);
                }
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnNext(onNext).doOnError(onError).subscribe(subscriber);
    }
}
