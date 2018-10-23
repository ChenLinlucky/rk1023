package com.example.rikaok1023.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rikaok1023.R;
import com.example.rikaok1023.bean.NewsLogin;
import com.example.rikaok1023.di.component.DaggerMainComponent;
import com.example.rikaok1023.di.module.MainModule;
import com.example.rikaok1023.mvp.contract.MainContract;
import com.example.rikaok1023.mvp.presenter.MainPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_regin)
    Button btnRegin;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_regin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String phone = editPhone.getText().toString();
                String passoword = editPassword.getText().toString();
                mPresenter.login(phone,passoword);
                break;
            case R.id.btn_regin:
                Intent intent = new Intent(MainActivity.this, ReginActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void datalogin(NewsLogin newsLogin) {
        String s1 = newsLogin.getCode();
        String s2 = newsLogin.getMsg();
        Toast.makeText(this, s2, Toast.LENGTH_SHORT).show();
        if(s1.equals(0)){
            String mobile = newsLogin.getData().getMobile();
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("mobile",mobile);
            intent.putExtras(bundle);
            setResult(1,intent);
            finish();
        }
    }
}
