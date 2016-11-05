package com.yooyo.poi.ui.iview;

import com.yooyo.poi.model.bean.RouteVo;
import java.util.List;

public interface MainViewListener{

    int getPageNo();
    void onFailure();
    void onSuccess(List<RouteVo> data);
    void onFinish();
    void onCompleted(int pageNo);
}
