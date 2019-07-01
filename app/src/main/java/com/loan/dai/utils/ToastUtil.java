package com.loan.dai.utils;


import android.view.Gravity;
import android.widget.Toast;

import com.loan.dai.base.LoanApp;
import com.loan.dai.logs.Logs;

public class ToastUtil {

    public static final String TAG = "ToastUtil";

    public static void ShowToast(String message) {
        Toast toast = Toast.makeText(LoanApp.mContext, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Logs.a(TAG, message);
    }
}
