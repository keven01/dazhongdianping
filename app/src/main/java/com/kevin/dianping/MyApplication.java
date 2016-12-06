package com.kevin.dianping;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/12/6.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
