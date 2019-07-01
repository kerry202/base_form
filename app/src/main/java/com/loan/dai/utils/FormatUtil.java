package com.loan.dai.utils;

import android.text.Html;
import android.text.Spanned;


public class FormatUtil {
    //不同颜色文本
    public static Spanned format(String source, String sub, String color) {
        Spanned spanned = Html.fromHtml(source + "<font color='" + color + "'>" + sub + "</font>");
        return spanned;
    }

    public static String format1(String source, String sub) {
        String format = String.format(source, sub);
        return format;
    }
}
