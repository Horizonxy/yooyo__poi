package com.yooyo.poi.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.yooyo.poi.R;
import com.yooyo.poi.ui.iview.BaseViewListener;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements BaseViewListener {

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pwd)
    EditText etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        tvTitle.setText("登  录");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFinish() {

    }
}
