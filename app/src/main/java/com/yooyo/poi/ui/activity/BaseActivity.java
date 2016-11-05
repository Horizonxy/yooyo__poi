package com.yooyo.poi.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.yooyo.poi.R;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AutoLayoutActivity {

    @BindView(R.id.btn_left)
    ImageView btnLeft;
    @BindView(R.id.btn_right)
    ImageView btnRight;
    @BindView(R.id.btn_right1)
    ImageView btnRight1;
    @BindView(R.id.tv_title)
    public TextView tvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
    }

    protected abstract void initView();

    protected abstract int getLayoutId();
}
