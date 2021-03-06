package com.vdreamers.vutilsjava;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 线程安全日期工具类
 * <p>
 * date 2019/04/12 11:24:57
 *
 * @author <a href="mailto:danhuangpai@2dfire.com">蛋黄派</a>
 */
@SuppressWarnings("unused")
public class DateUtils {

    private static ThreadLocal<SimpleDateFormat> sSimpleDateFormatThreadLocal = new ThreadLocal<>();
    /**
     * 简单的日期格式化
     */
    public static final String FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_PATTERN2 = "yyyy:MM:dd HH:mm:ss";
    public static final String FORMAT_PATTERN3 = "yyyy:MM:dd";
    public static final String FORMAT_PATTERN4 = "yyyy-MM-dd";
    public static final String FORMAT_PATTERN5 = "yyyy.MM.dd";
    public static final String FORMAT_PATTERN6 = "yyyy-MM";
    public static final String FORMAT_PATTERN7 = "yyyyMMdd";
    public static final String FORMAT_PATTERN8 = "yyyyMMddHHmmssSSS";
    public static final String FORMAT_PATTERN9 = "yyyy.MM.dd HH:mm";
    public static final String FORMAT_PATTERN10 = "yyyy-MM-dd";
    public static final String FORMAT_PATTERN11 = "yyyy-MM-ddHH:mm";
    public static final String FORMAT_PATTERN12 = "yyyyMM";
    public static final String FORMAT_PATTERN13 = "M.d";

    private DateUtils() {
        throw new UnsupportedOperationException("DateUtils can't instantiate ...");
    }

    public static String format(Date date, String pattern) {
        DateFormat df = getFormat(pattern);
        return df.format(date);
    }

    private static DateFormat getFormat(String pattern) {
        if (pattern == null) {
            pattern = FORMAT_PATTERN;
        }
        SimpleDateFormat df = sSimpleDateFormatThreadLocal.get();
        if (df == null) {
            df = new SimpleDateFormat(pattern, Locale.getDefault());
            sSimpleDateFormatThreadLocal.set(df);
        } else if (!pattern.equals(df.toPattern())) {
            df = new SimpleDateFormat(pattern, Locale.getDefault());
            sSimpleDateFormatThreadLocal.set(df);
        }
        return df;
    }

}
