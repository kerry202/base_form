package com.loan.dai.utils;


import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalFormatUtil {

    public static String format(Double d) {

        DecimalFormat df3 = new DecimalFormat("###,###,###,##0.0000");

        String format = df3.format(d);

        return format;
    }

    public static String format8(Double d) {

        DecimalFormat df3 = new DecimalFormat("###,###,###,##0.00000000");

        String format = df3.format(d);

        return format;
    }

    public static String format3(Double d) {

        DecimalFormat df3 = new DecimalFormat("###,###,###,###");

        String format = df3.format(d);

        return format;
    }

    public static String format5(Long d) {

        DecimalFormat df3 = new DecimalFormat("###,###,###,###");

        String format = df3.format(d);

        return format;
    }

    public static String format2(Double d) {

        DecimalFormat df3 = new DecimalFormat("##0.00");

        String format = df3.format(d);

        return format;
    }

    public static String format1(double d, int p) {
        try {
            BigDecimal bigDecimalBtc = new BigDecimal(d);
            String format = bigDecimalBtc.setScale(p, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
            return format;
        } catch (Exception e) {

        }
        return "";
    }

}
