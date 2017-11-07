package com.jstech.zhiyutong.fragment;

import android.widget.ImageView;

import com.jstech.zhiyutong.R;
import com.jstech.zhiyutong.api.SubjectGetUserApi;
import com.jstech.zhiyutong.base.BaseFragment;
import com.jstech.zhiyutong.utils.GlideUtils;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

import butterknife.BindView;

public class MyFragment extends BaseFragment implements HttpOnNextListener{

    //是否已经加载完毕
    private boolean isPrepared;

    //是否已经加载过一次  已经加载过再次显示fragment不会再加载网络数据
    private boolean isHasLoadOnce;

    //http加载网络
    private HttpManager manager;

    //post请求接口信息
    private SubjectGetUserApi postEntity;

    @BindView(R.id.head_img)
    ImageView headview;


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    protected void LazyLoad() {

        if(!isPrepared || !isVisible || isHasLoadOnce){
            return;
        }
        isHasLoadOnce=true;
        //这块的懒加载的意思就是说只有在
        //我们看见Fragment的时候才去加载数据
        doSomething();
    }

    private void doSomething() {
//        manager.doHttpDeal(postEntity);
        GlideUtils.displayCircleImage(getActivity(),"http://img2.imgtn.bdimg.com/it/u=1451470882,134157376&fm=27&gp=0.jpg",headview);
    }


    @Override
    public int getLayoutResource() {
        return R.layout.fragment_my;
    }

    @Override
    public void initView() {

        isPrepared=true;
        manager = new HttpManager(this, (RxAppCompatActivity) getActivity());
        postEntity = new SubjectGetUserApi();
        LazyLoad();

    }

    @Override
    public void onNext(String resulte, String method) {

    }

    @Override
    public void onError(ApiException e) {

    }

}
