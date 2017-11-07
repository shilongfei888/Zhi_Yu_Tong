package com.jstech.zhiyutong.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;

/**
 * Created by 史隆飞 on 2017/9/8. 自定义greendao 数据库保存路径
 */

public class GreenDaoContext extends ContextWrapper {


    public GreenDaoContext(Context base) {
        super(base);
    }

    /**
     * 获得数据库路径，如果不存在，则创建对象
     * @param
     */

    @Override
    public File getDatabasePath(String dbName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(FlieUtils.getGreenDaoPath());
        buffer.append(File.separator);
        buffer.append(File.separator);
        buffer.append(dbName);
        return new File(buffer.toString());
    }

    /**
     * 重载这个方法，是用来打开SD卡上的数据库的，android 2.3及以下会调用这个方法。
     *
     * @param name
     * @param mode
     * @param factory
     */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode,
                                               SQLiteDatabase.CursorFactory factory) {
        SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), factory);
        return result;
    }


    /**
     * Android 4.0会调用此方法获取数据库。
     *
     * @param name
     * @param mode
     * @param factory
     * @param errorHandler
     * @see ContextWrapper#openOrCreateDatabase(String, int,
     * SQLiteDatabase.CursorFactory,
     * DatabaseErrorHandler)
     */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory,
                                               DatabaseErrorHandler errorHandler) {
        SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), factory);

        return result;
    }

}
