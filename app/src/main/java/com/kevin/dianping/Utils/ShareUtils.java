package com.kevin.dianping.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/12/6.
 */

public class ShareUtils
{
    private static final String FILE_NAME = "dianping";
    private static final String MODE_NAME = "welcome";
    //获取boolean的值
    public static boolean getWelcomeBoolean(Context context){
        return context.getSharedPreferences(FILE_NAME,context.MODE_PRIVATE).getBoolean(MODE_NAME,false);
    }
    //写入boolean的值
    public static void putWelcomeBoolean(Context context,boolean isFirst){
        SharedPreferences.Editor edit = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).edit();
        edit.putBoolean(MODE_NAME,isFirst);
        edit.commit();
    }
}
