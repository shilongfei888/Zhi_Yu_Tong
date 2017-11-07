package com.jstech.zhiyutong.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jstech.zhiyutong.R;
import com.jstech.zhiyutong.api.SubjectPostregisterApi;
import com.jstech.zhiyutong.base.BaseActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements HttpOnNextListener{
    @BindView(R.id.edit_1)
    EditText editText1;
    @BindView(R.id.edit_2)
    EditText editText2;
    @BindView(R.id.edit_3)
    EditText editText3;
    @BindView(R.id.edit_4)
    EditText editText4;
    @BindView(R.id.register_message)
    TextView register;
    @BindView(R.id.edit_5)
    EditText editText5;
    private HashMap<String,String> map=new HashMap<>();
    private SubjectPostregisterApi subjectPostregisterApi;
    private HttpManager httpManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        httpManager=new HttpManager(this,this);
        subjectPostregisterApi=new SubjectPostregisterApi();
    }

    @Override
    public void onNext(String resulte, String method) {
        register.setText(resulte);
    }

    @Override
    public void onError(ApiException e) {

    }

    @OnClick(R.id.register)
    public void register(View view){

        map.put("surveyorName",editText1.getText().toString());
        map.put("surveyorPassword",editText2.getText().toString());
        map.put("surveyorLevel",editText3.getText().toString());
        map.put("surveyorOrg",editText4.getText().toString());
        map.put("surveyorRemark",editText5.getText().toString());


        subjectPostregisterApi.setMap(map);

        httpManager.doHttpDeal(subjectPostregisterApi);

    }

}
