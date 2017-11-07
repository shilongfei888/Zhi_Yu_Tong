package com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener;

import rx.Observable;

/**
 * 回调ober对象
 */

public interface HttpOnNextSubListener {

    /**
     * ober成功回调
     * @param observable
     * @param method
     */
    void onNext(Observable observable,String method);
}
