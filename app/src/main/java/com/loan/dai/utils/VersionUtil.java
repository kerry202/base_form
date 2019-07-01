package com.loan.dai.utils;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class VersionUtil {
    public static String getLocalVersion(Activity activity) {
        String localVersion = "";
        try {
            PackageInfo packageInfo = activity.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(activity.getPackageName(), 0);
            localVersion = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }
}
