package com.jstech.zhiyutong.utils;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by Administrator on 2017/8/4.
 *
 * 自定义 glide 图片磁盘缓存路径
 *
 *
 */

@GlideModule
public final class CustomAppGlideModule extends AppGlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        super.applyOptions(context, builder);

        /**
         * 缓存大小200M
         */
        int cacheSize100MegaBytes = 1024*1024*200;

        /**
         * 存储sd卡android 私有路径
         */
        if (FlieUtils.isSd()){

            builder.setDiskCache(new ExternalCacheDiskCacheFactory(context,"glide_image_cache", cacheSize100MegaBytes));

            /**
             * 没有sd卡 存储内部私有路径
              */
        }else {

            builder.setDiskCache(new InternalCacheDiskCacheFactory(context,"glide_image_cache", cacheSize100MegaBytes));

        }

    }
}