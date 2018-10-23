package com.example.rikaok1023.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rikaok1023.R;
import com.example.rikaok1023.bean.NewsRegin;
import com.example.rikaok1023.di.component.DaggerReginComponent;
import com.example.rikaok1023.di.module.ReginModule;
import com.example.rikaok1023.mvp.contract.ReginContract;
import com.example.rikaok1023.mvp.presenter.ReginPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class ReginActivity extends BaseActivity<ReginPresenter> implements ReginContract.View {

    @BindView(R.id.edit_phone01)
    EditText editPhone01;
    @BindView(R.id.edit_password01)
    EditText editPassword01;
    @BindView(R.id.btn_regin01)
    Button btnRegin01;
    private String phone;
    private String password;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerReginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .reginModule(new ReginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_regin; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
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

    @OnClick(R.id.btn_regin01)
    public void onViewClicked() {
       phone = editPhone01.getText().toString();
       password = editPassword01.getText().toString();
       mPresenter.regin(phone,password);
    }

    @Override
    public void dataregin(NewsRegin newsRegin) {
        String s1 = newsRegin.getCode();
        String s2 = newsRegin.getMsg();
        Toast.makeText(this, s2, Toast.LENGTH_SHORT).show();
        if(s1.equals(0)){
            Toast.makeText(this, s2, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("phone",phone);
            bundle.putString("passoword",password);
            intent.putExtras(bundle);
            setResult(1,intent);
            finish();
        }

    }
}
