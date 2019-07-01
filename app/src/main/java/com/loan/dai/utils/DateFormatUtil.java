package com.loan.dai.utils;


import java.text.SimpleDateFormat;

public class DateFormatUtil {
    public static String getHMS(Long timetemp) {
        SimpleDateFormat fmat = new SimpleDateFormat("HH:mm:ss");
        String time = fmat.format(timetemp);
        return time;
    }

    public static String getYMDHMS(Long timetemp) {
        SimpleDateFormat fmat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = fmat.format(timetemp);

        return time;
    }

}
