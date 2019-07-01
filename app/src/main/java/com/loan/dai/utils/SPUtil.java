package com.loan.dai.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.loan.dai.base.LoanApp;


public class SPUtil {

    private static String KEY = "finance";

    private static SharedPreferences getSp(Context context) {
        SharedPreferences sp = null;
        try {
            if (context != null) {
                sp = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
            } else {
                sp = LoanApp.mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
            }
        } catch (Exception e) {
            sp = LoanApp.mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        }

        return sp;
    }

    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = getSp(context);
        sp.edit().putBoolean(key, value).commit();
    }


    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getBoolean(key, defValue);
    }

    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, false);
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = getSp(context);
        sp.edit().putString(key, value).commit();
    }

    public static void putLong(Context context, String key, long value) {
        SharedPreferences sp = getSp(context);
        sp.edit().putLong(key, value).commit();
    }

    public static long getLong(Context context, String key, long defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getLong(key, defValue);
    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getString(key, defValue);
    }


    public static String getString(Context context, String key) {
        return getString(context, key, "");
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences sp = getSp(context);
        sp.edit().putInt(key, value).commit();
    }


    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getInt(key, defValue);
    }


    public static int getInt(Context context, String key) {
        return getInt(context, key, -1);
    }

    public static void clear(Context context) {
        SharedPreferences sp = getSp(context);
        sp.edit().clear().commit();
    }

    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }
}
