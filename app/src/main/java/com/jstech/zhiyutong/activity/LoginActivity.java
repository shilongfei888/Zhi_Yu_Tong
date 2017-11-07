package com.jstech.zhiyutong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.jstech.zhiyutong.R;
import com.jstech.zhiyutong.api.SubjectPostLoginApi;
import com.jstech.zhiyutong.base.BaseActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements HttpOnNextListener{

    @BindView(R.id.name)
    EditText editText_name;

    @BindView(R.id.password)
    EditText editText_password;

    private SubjectPostLoginApi subjectPostLoginApi;

    //http加载网络
    private HttpManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void initView() {
        manager=new HttpManager(this,this);
        subjectPostLoginApi=new SubjectPostLoginApi();
    }


    @Override
    public void onNext(String resulte, String method) {


    }

    @Override
    public void onError(ApiException e) {

    }


    @OnClick(R.id.login)
    public void login(View view){

//        subjectPostLoginApi.setName(editText_name.getText().toString());
//        subjectPostLoginApi.setPassword(editText_password.getText().toString());
//
//        manager.doHttpDeal(subjectPostLoginApi);

        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        finish();

    }


//    @OnClick(R.id.register)
//    public void register(View view){
//        startActivity(new Intent(this,RegisterActivity.class));
//
//    }

}
