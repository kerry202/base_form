package com.loan.dai.utils;

import android.app.Activity;

import com.loan.dai.logs.Logs;
import com.loan.dai.widget.progress.MyProgress;

public class ProgressUtil {

    private static MyProgress dialog;

    public static void showDialog(Activity activity) {
        if (dialog == null) {
            dialog = new MyProgress(activity).setStyle(MyProgress.Style.SPIN_INDETERMINATE).setCancellable(true)
                    .setAnimationSpeed(2)
                    .setDimAmount(0.5f)
                    .show();
            Logs.s("  showDialog  1  ");
        } else {
            Logs.s("  showDialog  2  ");
            dialog.show();
        }
    }

    public static void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
