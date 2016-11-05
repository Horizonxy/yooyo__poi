package com.yooyo.poi.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding.view.RxView;
import com.orhanobut.logger.Logger;
import com.yooyo.poi.MainActivity;
import com.yooyo.poi.R;
import com.yooyo.poi.di.component.DaggerLoginCompoent;
import com.yooyo.poi.di.module.LoginModule;
import com.yooyo.poi.presenter.LoginPresenter;
import com.yooyo.poi.ui.iview.LoginViewListener;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import butterknife.BindView;
import rx.functions.Action1;

public class LoginActivity extends BaseActivity implements LoginViewListener {

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerLoginCompoent.builder().loginModule(new LoginModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
        tvTitle.setText("登  录");
        RxView.clicks(btnLogin).throttleFirst(1, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                presenter.login();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onFailure() {
        Logger.e("login failure...");
    }

    @Override
    public void onSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public String getName() {
        return etName.getText().toString();
    }

    @Override
    public String getPwd() {
        return etPwd.getText().toString();
    }

    @Override
    public void setBtnEnable(boolean isEnable) {
        btnLogin.setEnabled(isEnable);
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.onDestroy();
        }
        super.onDestroy();
    }
}
