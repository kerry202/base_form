package com.loan.dai.base;

import android.app.Application;
import android.content.Context;

import com.loan.dai.config.ApiConfig;
import com.tencent.bugly.crashreport.CrashReport;

import org.greenrobot.eventbus.EventBus;

public class LoanApp extends Application {

    public static Context mContext;
    public static EventBus mEventBus = EventBus.getDefault();

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        CrashReport.initCrashReport(getApplicationContext(), ApiConfig.BUGLY_ID, false);
    }
}
