package com.onemile.bms.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Description: 日期工具类
 *
 * @author
 * @date 2017年9月11日
 */
public final class DateUtil {
    // 日期显示格式yyyy-MM-dd
    public static final String DATEFORMAT_STR_YMD = "yyyy-MM-dd";

    // 日期显示格式yyyyMMdd
    public static final String DATEFORMAT_STR_YMD1 = "yyyyMMdd";

    public static final String DATEFORMAT_STR_YMD2 = "yyyy.MM.dd";

    // 日期显示格式yyyy-MM
    public static final String DATEFORMAT_STR_YM = "yyyy-MM";

    // 日期显示格式yyyy-MM-dd HH:mm:ss
    public static final String DATEFORMAT_STR_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    // 日期显示格式yyyyMMddHHmmssSSS,精确到毫秒
    public static final String DATEFORMAT_STR_YMDHMSS1 = "yyyyMMddHHmmssSSS";

    // 日期显示格式yyyyMMddHHmmssSSS,精确到毫秒
    public static final String DATEFORMAT_STR_YMDHMSSS = "yyMMddHHmmssSSS";

    // 日期显示格式yyyy-MM-dd HH:mm,精确到分钟
    public static final String DATEFORMAT_STR_YMDHM = "yyyy-MM-dd HH:mm";

    // 日期显示格式yyyyMMddHHmm
    public static final String DATEFORMAT_STR_YMDHM1 = "yyyyMMddHHmm";

    // 日期显示格式yyyyMMddHHmmss
    public static final String DATEFORMAT_STR_YMDHMS1 = "yyyyMMddHHmmss";

    // 日期中文显示格式yyyy年MM月dd日
    public static final String DATEFORMAT_STR_YMD_ZHCN = "yyyy年MM月dd日";

    // 日期中文显示格式yyyy年MM月dd日HH时mm分ss秒
    public static final String DATEFORMAT_STR_YMDHMS_ZHCN = "yyyy年MM月dd日HH时mm分ss秒";

    // 日期中文显示格式yyyy年MM月dd日HH时mm分
    public static final String DATEFORMAT_STR_YMDHM_ZHCN = "yyyy年MM月dd日HH时mm分";

    // 日期结束时间
    public static final String HOUR_END = " 23:59:59";

    // 日期开始时间
    public static final String HOUR_START = " 00:00:00";

    // 精确毫秒
    public static final String DATEFORMAT_STR_HMSS = "HHmmssSSS";

    // 获取天
    public static final String DD = "dd";

    // 获取小时
    public static final String HH_STR = "HH";

    // 默认显示日期时间的格式 精确到分钟
    public static final String DATEFORMAT_STR_MDHM = "MM-dd HH:mm";

    public static final String DATEFORMAT_STR_HM = "HH:mm";

    public static final String DATEFORMAT_STR_MDHM1 = "MM.dd HH:mm";

    public static final String DATEFORMAT_STR_HMS = "HH:mm:ss";

    private DateUtil() {
    }

    /**
     * Description: 获取当前时间
     *
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static Date now() {
        return Calendar.getInstance(Locale.CHINESE).getTime();
    }

    /**
     * Description: 日期加天
     *
     * @param baseDate
     * @param increaseDate
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static Date daysAfter(Date baseDate, int increaseDate) {
        Calendar calendar = Calendar.getInstance(Locale.CHINESE);
        calendar.setTime(baseDate);
        calendar.add(Calendar.DATE, increaseDate);
        return calendar.getTime();
    }

    /**
     * Description: 日期加小时
     *
     * @param baseDate
     * @param increaseHours
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static Date hoursAfter(Date baseDate, int increaseHours) {
        Calendar calendar = Calendar.getInstance(Locale.CHINESE);
        calendar.setTime(baseDate);
        calendar.add(Calendar.HOUR_OF_DAY, increaseHours);
        return calendar.getTime();
    }

    /**
     * Description: 日期加分钟
     *
     * @param baseDate
     * @param increaseMinutes
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static Date minuteAfter(Date baseDate, int increaseMinutes) {
        Calendar calendar = Calendar.getInstance(Locale.CHINESE);
        calendar.setTime(baseDate);
        calendar.add(Calendar.MINUTE, increaseMinutes);
        return calendar.getTime();
    }

    /**
     * Description: 日期加月份
     *
     * @param baseDate
     * @param increaseMonths
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static Date monthAfter(Date baseDate, int increaseMonths) {
        Calendar calendar = Calendar.getInstance(Locale.CHINESE);
        calendar.setTime(baseDate);
        calendar.add(Calendar.MONTH, increaseMonths);
        return calendar.getTime();
    }

    /**
     * Description: 按自然月方式求截止日期。
     *
     * @param baseDate
     * @param increaseMonths
     * @return
     * @author
     * @date 2017年2月15日
     */
    public static Date monthAfterNatural(Date baseDate, int increaseMonths) {
        Calendar calendar = Calendar.getInstance(Locale.CHINESE);
        calendar.setTime(baseDate);
        int dayOld = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.add(Calendar.MONTH, increaseMonths);
        int dayNext = calendar.get(Calendar.DAY_OF_MONTH);

        if (dayOld == dayNext) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        return calendar.getTime();
    }

    /**
     * Description: 获取所在时区日期相加
     *
     * @param d
     * @param days
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static Date getInternalDateByDay(Date d, int days) {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());
        now.setTime(d);
        now.add(Calendar.DATE, days);
        return now.getTime();
    }

    /**
     * Description: 获取所在时区日期加分钟
     *
     * @param d
     * @param minutes
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static Date getInternalDateByMinute(Date d, int minutes) {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());
        now.setTime(d);
        now.add(Calendar.MINUTE, minutes);
        return now.getTime();
    }

    /**
     * 将Date转换成formatStr格式的字符串
     *
     * @param date
     * @param formatStr
     * @return
     */
    public static String dateToDateString(Date date, String formatStr) {
        if (date == null) {
            return null;
        }
        DateFormat df = getDateFormat(formatStr);
        return df.format(date);
    }

    /**
     * 将Date转换成字符串“yyyy-mm-dd hh:mm:ss”的字符串
     *
     * @param date
     * @return
     */
    public static String formateDate(Date date) {
        return formateDate(date, DATEFORMAT_STR_YMDHMS);
    }

    /**
     * 将Date转换成formatStr格式的字符串
     *
     * @param date
     * @param formatStr
     * @return
     */
    public static String formateDate(Date date, String formatStr) {
        if (date == null) {
            return null;
        }
        return getDateFormat(formatStr).format(date);
    }

    /**
     * 按照默认formatStr的格式，转化dateTimeStr为Date类型 dateTimeStr必须是formatStr的形式
     *
     * @param dateTimeStr
     * @param formatStr
     * @return
     */
    public static Date getDate(String dateTimeStr, String formatStr) {
        try {
            DateFormat sdf = new SimpleDateFormat(formatStr);
            return sdf.parse(dateTimeStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCurDate() {
        return formateDate(Calendar.getInstance().getTime(), DATEFORMAT_STR_YMD);
    }

    public static String getCurHour() {
        return formateDate(Calendar.getInstance().getTime(), HH_STR);
    }

    public static int getThisMonth() {
        Calendar c = Calendar.getInstance(Locale.CHINESE);
        return c.get(Calendar.MONTH) + 1;

    }

    /**
     * Description: 获取SimpleDateFormat
     *
     * @param formatStr
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static SimpleDateFormat getDateFormat(final String formatStr) {
        return new SimpleDateFormat(formatStr);
    }

    /**
     * Description: 获取当前月第一天日期
     *
     * @param date
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static String getFirstDateOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DateFormat format = new SimpleDateFormat(DATEFORMAT_STR_YMD);
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        return format.format(calendar.getTime());
    }

    /**
     * Description: 获取当前月最后一天日期
     *
     * @param date
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static String getLastDateOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DateFormat format = new SimpleDateFormat(DATEFORMAT_STR_YMD);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        return format.format(calendar.getTime());
    }

    /**
     * 获取两个毫秒间隔的分钟
     *
     * @param t1
     * @param t2
     * @return
     */
    public static int getMinutesBetweenMillis(long t1, long t2) {
        return (int) ((t1 - t2) / (60 * 1000));
    }

    /**
     * 判断目标时间是否处于某一时间段内
     *
     * @param target
     * @param begin
     * @param end
     * @return
     */
    public static boolean compareTargetTime(Date target, String begin, String end) {
        // 格式化时间 暂时不考虑传入参数的判断，其他地方如果要调用，最好扩展判断一下入参问题
        String targetTime = formateDate(target, DATEFORMAT_STR_YMDHMS).substring(11);// HH:mm:ss
        if (targetTime.compareTo(begin) >= 0 && end.compareTo(targetTime) >= 0) {
            return true;
        }
        return false;
    }

    /**
     * Description: 比较日期
     *
     * @param time1
     * @param time2
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static boolean compareTime(Date time1, Date time2) {
        long start = time1.getTime();
        long end = time2.getTime();
        if (start < end) {
            return true;
        }

        return false;
    }

    /**
     * Description: 获取间隔天数
     *
     * @param time1
     * @param time2
     * @return
     */
    public static long getBetweenDays(String time1, String time2) {
        long quot = 0;
        SimpleDateFormat ft = new SimpleDateFormat(DATEFORMAT_STR_YMD);
        try {
            Date date1 = ft.parse(time1);
            Date date2 = ft.parse(time2);
            quot = date1.getTime() - date2.getTime();
            quot = quot / 86400000;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return quot;
    }

    /**
     * Description: 获取间隔天数
     *
     * @param time1
     * @param time2
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static long getBetweenDays(Date time1, Date time2) {
        if (time1 == null || time2 == null) {
            return -1;
        }
        long quot = time1.getTime() - time2.getTime();
        quot = quot / 86400000;
        return quot;
    }

    /**
     * 计算2个日期相差的月数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonth(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int result = 0;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        try {
            c1.setTime(sdf.parse(date1));
            c2.setTime(sdf.parse(date2));
            result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result == 0 ? 1 : Math.abs(result);
    }

    /**
     * 计算2个日期相差的月数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonth(Date date1, Date date2) {
        int iMonth = 0;
        int flag = 0;
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);

            if (cal2.equals(cal1)) {
                return 0;
            }
            if (cal1.after(cal2)) {
                Calendar temp = cal1;
                cal1 = cal2;
                cal2 = temp;
            }
            if (cal2.get(Calendar.DAY_OF_MONTH) < cal1.get(Calendar.DAY_OF_MONTH)) {
                flag = 1;
            }

            if (cal2.get(Calendar.YEAR) > cal1.get(Calendar.YEAR)) {
                iMonth = ((cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR)) * 12 + cal2.get(Calendar.MONTH) - flag) - cal1.get(Calendar.MONTH);
            } else {
                iMonth = cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH) - flag;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iMonth;
    }

    /**
     * 获取和当前时间相差的分钟数
     *
     * @param begin
     * @return
     */
    public static long getDiffenceValue(Date begin) {
        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();
        return (now.getTime() - begin.getTime()) / 1000 / 60;
    }

    /**
     * Description: 获取和当前时间相差毫秒数
     *
     * @param date1
     * @param date2
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static long getMillsBetweenTwoDate(Date date1, Date date2) {
        return date1.getTime() - date2.getTime();
    }

    /**
     * 求多少天前/后的日期
     *
     * @param field 单位：年，月，日
     * @param day   多少天
     * @return
     */
    public static final Date addDate(int field, int day) {
        Calendar nowCalendar = Calendar.getInstance(Locale.CHINESE);
        nowCalendar.setTime(DateUtil.now());
        nowCalendar.add(field, day);
        return nowCalendar.getTime();
    }

    /**
     * 获取本月第一天
     *
     * @return
     */
    public static final String getCurrFirstDay() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        return formateDate(c.getTime(), DATEFORMAT_STR_YMD);
    }

    /**
     * 获取本月最后一天
     *
     * @return
     */
    public static final String getCurrLastDay() {
        // 获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return formateDate(ca.getTime(), DATEFORMAT_STR_YMD);
    }

    /**
     * 获取当月最后一天
     *
     * @return
     * @see
     */
    public static final Date getCurrLastDay2Date() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return ca.getTime();
    }

    /**
     * 获取当前日期是本年第几周
     *
     * @return
     */
    public static int getThisWeek() {
        Calendar c = Calendar.getInstance(Locale.CHINESE);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        return c.get(Calendar.WEEK_OF_YEAR);

    }

    /**
     * 获取本周第一天日期
     *
     * @return yyyy-MM-dd
     */
    public static String getWeekFirstDay(String dataStr) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat(DATEFORMAT_STR_YMD).parse(dataStr));
        int d;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        return new SimpleDateFormat(DATEFORMAT_STR_YMD).format(cal.getTime());
    }

    /**
     * 获取本周最后一天日期
     *
     * @return yyyy-MM-dd
     */
    public static String getWeekLastDay(String dataStr) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat(DATEFORMAT_STR_YMD).parse(dataStr));
        int d;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d + 6);
        return new SimpleDateFormat(DATEFORMAT_STR_YMD).format(cal.getTime());
    }

    /**
     * 获取当前月的某一天
     *
     * @param day
     * @param hour
     * @param min
     * @param sec
     * @return
     */
    public static final Date getDayOfMonth(int day, int hour, int min, int sec) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, min);
        c.set(Calendar.SECOND, sec);
        return c.getTime();
    }

    /**
     * 获取日期前后苦干个月
     *
     * @param date
     * @param month
     * @return
     */
    public static Date getBeforeOrAfterMonths(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 获取日期前后苦干年
     *
     * @param date
     * @param years
     * @return
     */
    public static Date getBeforeOrAfterYears(Date date, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    /**
     * Description: 获取当前日期-按指定格式格式化
     *
     * @param formatStr
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static final String getCurrentDay(String formatStr) {
        Calendar ca = Calendar.getInstance();
        return formateDate(ca.getTime(), formatStr);
    }

    /**
     * Description: 获取昨天日期-按指定格式格式化
     *
     * @param formartstr
     * @return
     * @author
     * @date 2016年9月11日
     */
    public static final String getYesterday(String formartstr) {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DAY_OF_MONTH, -1);
        return formateDate(ca.getTime(), formartstr);
    }

    /**
     * Description: long型时间转成formartstr格式的String类型时间
     *
     * @param time
     * @param formartstr
     * @return
     * @author
     * @date 2016年9月13日
     */
    public static final String convertLongTimeToString(long time, String formartstr) {
        return formateDate(new Date(time), formartstr);
    }

    /**
     * Description: String类型时间转为Date类型时间
     *
     * @param timestr
     * @param formartstr
     * @return
     * @author
     * @date 2016年9月13日
     */
    public static final Date convertStringTimeToDate(String timestr, String formartstr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formartstr);
        Date date = null;
        try {
            date = sdf.parse(timestr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    /**
     * Description: Date类型时间转为long类型时间
     *
     * @param date
     * @return
     * @author
     * @date 2016年9月13日
     */
    public static long convertDatetimeToLongtime(Date date) {
        return date.getTime();
    }

    /**
     * Description: 获取当前日期-Date型 yyyy-MM-dd
     *
     * @return Date yyyy-MM-dd
     * @author
     * @date 2016年9月13日
     */
    public static final Date today() {
        return convertStringTimeToDate(getCurDate(), DATEFORMAT_STR_YMD);
    }

    /**
     * Description: Date : HH:mm:ss
     *
     * @return
     * @author
     * @date 2017-1-12
     */
    public static final Date todayHms() {
        String dateStr = formateDate(Calendar.getInstance().getTime(), DATEFORMAT_STR_HMS);
        return convertStringTimeToDate(dateStr, DATEFORMAT_STR_HMS);
    }

    /**
     * Description: 获取当前日期-long型
     *
     * @return
     * @author
     * @date 2016年9月13日
     */
    public static final long getCurrentLongTime() {
        Date now = new Date();
        return now.getTime();
    }

    /**
     * Description: 获取日期前后若干天日期
     *
     * @param date 日期格式：yyyy-MM-dd
     * @param day
     * @return Date
     * @author
     * @date 2016年9月13日
     */
    public static Date getBeforeOrAfterDaysDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * Description: 获取日期前后若干天日期
     *
     * @param date
     * @param day
     * @return 返回格式：yyyy-MM-dd
     * @author
     * @date 2016年9月13日
     */
    public static String getBeforeOrAfterDays(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        date = calendar.getTime();
        return formateDate(date, DATEFORMAT_STR_YMD);
    }

    /**
     * Description: 获取日期前后若干天日期
     *
     * @param datestr 日期格式：yyyy-MM-dd
     * @param day
     * @return 返回格式：yyyy-MM-dd
     * @author
     * @date 2016年9月13日
     */
    public static String getBeforeOrAfterDays(String datestr, int day) {
        Date date = getDate(datestr, DATEFORMAT_STR_YMD);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        date = calendar.getTime();
        return formateDate(date, DATEFORMAT_STR_YMD);
    }

    /**
     * Description: 获取日期前后若干天日期
     *
     * @param datestr 日期格式：yyyy-MM-dd
     * @param day
     * @return Date
     * @author
     * @date 2016年9月13日
     */
    public static Date getBeforeOrAfterDaysDate(String datestr, int day) {
        Date date = getDate(datestr, DATEFORMAT_STR_YMD);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * Description: 获取指定时期所属月份的天数
     *
     * @param dateTimeStr 日期格式：yyyy-MM-dd
     * @return
     * @author
     * @date 2016年9月13日
     */
    public static int getDayOfMonth(String dateTimeStr) {
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.setTime(getDate(dateTimeStr, DATEFORMAT_STR_YMD));
        return aCalendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * Description: 获取指定时期所属月份的天数
     *
     * @param date
     * @return
     * @author
     * @date 2016年9月13日
     */
    public static int getDayOfMonth(Date date) {
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.setTime(date);
        return aCalendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * Description: 获取当前月份天数
     *
     * @return
     * @author
     * @date 2016年9月13日
     */
    public static int getDayOfCurrentMonth() {
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        return aCalendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * Description: 获取指定时间与当前时间的时间差
     *
     * @param date
     * @return
     * @author
     * @date 2016年9月13日
     */
    public static String getPerTime(Date date) {

        Date now = DateUtil.now();

        if (null == date) {
            date = now;
        }

        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = l / (60 * 60 * 1000) - day * 24;
        long min = l / (60 * 1000) - day * 24 * 60 - hour * 60;
        long s = l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60;

        String pstr = null;

        if (day >= 1) {
            pstr = formateDate(date, DATEFORMAT_STR_MDHM);
        } else if (hour >= 1 && hour <= 24) {
            pstr = hour + "小时前";
        } else {
            if (min == 0 && s >= 0) {
                min = 1;
            }
            pstr = min + "分钟前";
        }

        return pstr;
    }


    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到豪秒的字符串
     * @param format
     * @return
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds)));
    }
    /**
     * 日期格式字符串转换成时间戳
     * @param date_str 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得当前时间戳（精确到秒）
     * @return
     */
    public static String timeStamp(){
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);
        return t;
    }


}
