package com.yooyo.poi.presenter;


import com.yooyo.poi.model.bean.RouteVo;
import com.yooyo.poi.model.data.RouteModel;
import com.yooyo.poi.ui.iview.MainViewListener;
import com.yooyo.poi.util.SimpleSubscriber;

import java.util.List;

import rx.Subscription;
import rx.functions.Action1;

public class RoutePresenter extends BasePresenter {

    private MainViewListener view;
    private RouteModel model;

    public RoutePresenter(RouteModel model, MainViewListener view) {
        this.model = model;
        this.view = view;
    }

    public void getRouteList(){
        int pageNo = view.getPageNo();
        Subscription subscription = model.getRouteList(pageNo, new Action1<List<RouteVo>>() {
            @Override
            public void call(List<RouteVo> routeVos) {
                view.onCompleted(pageNo);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                view.onCompleted(pageNo);
            }
        }, new SimpleSubscriber<List<RouteVo>>() {
            @Override
            public void onNextRx(List<RouteVo> obj) {
                dealData(obj);
            }

            @Override
            public void onError(Throwable e) {
                view.onFailure();
            }
        });
        addSubscription(subscription);
    }

    private void dealData(List<RouteVo> data){
        if (data == null) {
            view.onFailure();
            return;
        }
        if (data.size() > 0) {
            view.onSuccess(data);
        } else {
            view.onFinish();
        }
    }
}
