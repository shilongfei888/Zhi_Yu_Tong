package com.jstech.zhiyutong.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by 史隆飞 on 2017/9/8.
 */

public class FlieUtils {

    /**
     * app保存文件的根目录
     */
    public static String getRootPath() {

        String path = null;
        if (isSd()) {
            path = Environment.getExternalStorageDirectory() + File.separator + "com.jstech.zhiyutong";
        } else {
            path = Environment.getDataDirectory() + File.separator + "com.jstech.zhiyutong";
        }

        File rootFile = new File(path);
        if (!rootFile.exists()) {
            rootFile.mkdir();
        }
        return path;
    }

    /**
     * 数据库统一保存的路径
     */

    public static String getGreenDaoPath() {
        String greendaoPath = getRootPath() + File.separator + "greendao";
        File imageFile = new File(greendaoPath);
        if (!imageFile.exists()) {
            imageFile.mkdirs();
        }
        return greendaoPath;
    }


    /**
     * 判断是否有sd卡
     * @return
     */
    public static boolean isSd(){

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            return true;
        }

        return false;

    }

}
