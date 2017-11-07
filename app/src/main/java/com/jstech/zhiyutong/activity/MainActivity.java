package com.jstech.zhiyutong.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.bumptech.glide.Glide;
import com.jstech.zhiyutong.R;
import com.jstech.zhiyutong.base.BaseActivity;
import com.jstech.zhiyutong.base.BaseFragmentAdapter;
import com.jstech.zhiyutong.fragment.HomeFragment;
import com.jstech.zhiyutong.fragment.MessageFragment;
import com.jstech.zhiyutong.fragment.MyFragment;
import com.jstech.zhiyutong.weight.ViewPagerFixed;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPagerFixed viewPager;
    private BaseFragmentAdapter adapter;
    private ArrayList<Fragment> fragmentList;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 监测用户是否打开开发者模式的不保留活动
         */
        int alwaysFinish = Settings.Global.getInt(getContentResolver(), Settings.Global.ALWAYS_FINISH_ACTIVITIES, 0);
        if (alwaysFinish == 1) {
            Dialog dialog = null;
            dialog = new AlertDialog.Builder(this)
                    .setMessage(
                            "由于您已开启'不保留活动',导致i呼部分功能无法正常使用.我们建议您点击左下方'设置'按钮,在'开发者选项'中关闭'不保留活动'功能.")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).setPositiveButton("设置", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(
                                    Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
                            startActivity(intent);
                        }
                    }).create();
            dialog.show();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 设置不显示返回按钮
     * @return
     */
    @Override
    protected boolean isShowBacking() {
        return false;
    }

    @Override
    public void initView() {

        setToolBarTitle("智渔通");
        setToolSubBarTitle("");

        initFragment();
        adapter = new BaseFragmentAdapter(getSupportFragmentManager(), fragmentList);
        initaction();

    }

    private void initaction() {

        viewPager.setNotTouchScoll(false);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

            }
        });

    }

    private void initFragment() {

        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new MessageFragment());
        fragmentList.add(new MyFragment());

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override public void onTrimMemory ( int level ) {
        super . onTrimMemory ( level );

        Glide. with ( this ). onTrimMemory ( level );

    }


    @Override public void onLowMemory () {
        super . onLowMemory ();
        Glide . with ( this ). onLowMemory ();
    }

    @OnClick({ R.id.home, R.id.message, R.id.my })
    public void check(View view){
        switch (view.getId()){
            case R.id.home:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.message:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.my:
                viewPager.setCurrentItem(2,false);
                break;
        }
    }




}
