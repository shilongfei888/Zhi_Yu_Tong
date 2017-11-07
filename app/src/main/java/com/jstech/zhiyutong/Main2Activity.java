package com.jstech.zhiyutong;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.jaiky.imagespickers.ImageConfig;
import com.jaiky.imagespickers.ImageSelector;
import com.jstech.zhiyutong.base.BaseActivity;
import com.jstech.zhiyutong.utils.GlideUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class Main2Activity extends BaseActivity {

    private ArrayList<String> path = new ArrayList<>();

    public static final int REQUEST_CODE = 123;

    private ImageConfig imageConfig;

    @BindView(R.id.llContainer)
     LinearLayout llContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void initView() {

    }

    @OnClick(R.id.select_img)
    public void select(View view){

        imageConfig = new ImageConfig.Builder(
         GlideUtils.getInstance(0))
                .steepToolBarColor(getResources().getColor(R.color.titleBlue))
                .titleBgColor(getResources().getColor(R.color.titleBlue))
                .titleSubmitTextColor(getResources().getColor(R.color.white))
                .titleTextColor(getResources().getColor(R.color.white))
                // 开启单选   （默认为多选）
                .singleSelect()
                // 裁剪 (只有单选可裁剪)
                .crop()
                // 开启拍照功能 （默认关闭）
                .showCamera()
                //设置显示容器
                .setContainer(llContainer)
                .requestCode(REQUEST_CODE)
                .build();
        ImageSelector.open(this, imageConfig);

    }

}
