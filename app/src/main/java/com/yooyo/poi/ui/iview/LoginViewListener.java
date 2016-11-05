package com.yooyo.poi.ui.iview;

public interface LoginViewListener extends BaseViewListener {

    String getName();
    String getPwd();
    void setBtnEnable(boolean isEnable);
}
