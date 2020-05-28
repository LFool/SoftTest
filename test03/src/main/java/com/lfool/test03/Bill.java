package com.lfool.test03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: Bill
 * @Description: TODO
 * @Author: LFool
 * @Date: 2020/5/28 0:22
 * @Version: 1.0
 */
public class Bill {

    private static final String ERROR_INFO = "Invalid Date";

    public static String charge(String startTime, String endTime) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date startDate = df.parse(startTime);
        Date endDate = df.parse(endTime);

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);

        long diff = (endDate.getTime() - startDate.getTime()) / 1000;

        // 获取输入的时间的月份、天数、星期几、小时
        int month = startCalendar.get(Calendar.MONTH) + 1;
        int day = startCalendar.get(Calendar.DAY_OF_MONTH);
        int week = startCalendar.get(Calendar.DAY_OF_WEEK) - 1;
        int hourStart = startCalendar.get(Calendar.HOUR_OF_DAY);
        int hourEnd = endCalendar.get(Calendar.HOUR_OF_DAY);

        if (diff < 0 || diff / 3600 > 20) {
            if (!(month == 10 && 31 - day < 7 && week == 0 && hourStart == 2 && hourEnd == 2)) {
                return ERROR_INFO;
            }
        }

        // 取得通话时长
        long minutes = diff / 60;
        long seconds = diff % 60;

        String res = "";

        if ((month == 3 && 31 - day <= 7 && week == 0 && hourEnd > 2)
                || (month == 4 && day < 7 && week == 0 && hourEnd > 2)) {
            double fee = feeTransformationSum(minutes, seconds);
            res = String.format("%.2f", fee);
        } else if (month == 10 && 31 - day <= 7 && week == 0) {
            if (hourEnd == 2 && minutes >= 0) {
                double fee1 = feeTransformationAut(minutes, seconds);
                double fee2 = feeTransformationNo(minutes, seconds);
                res = String.format("%.2f", fee1) + " or " + String.format("%.2f", fee2);
            } else if (hourStart == 2 && hourEnd == 2 && minutes < 0) {
                long minu = (diff + 3600) / 60;
                long seco = (diff + 3600) % 60;
                double fee = feeTransformationNo(minu, seco);
                res = String.format("%.2f", fee);
            } else {
                double fee = feeTransformationNo(minutes, seconds);
                res = String.format("%.2f", fee);
            }
        } else {
            double fee = feeTransformationNo(minutes, seconds);
            res = String.format("%.2f", fee);
        }

        return res;
    }

    /**
     * 春夏时制转换收费
     * @param minutes
     * @param seconds
     * @return
     */
    private static double feeTransformationSum(long minutes, long seconds) {
        long totalMinute = minutes - 60;
        return feeTransformationNo(totalMinute, seconds);
    }

    /**
     * 春夏时制转换收费
     * @param minutes
     * @param seconds
     * @return
     */
    private static double feeTransformationAut(long minutes, long seconds) {
        long totalMinute = minutes + 60;
        return feeTransformationNo(totalMinute, seconds);
    }


    /**
     * 无时制转换收费
     * @param minutes
     * @param seconds
     * @return
     */
    private static double feeTransformationNo(long minutes, long seconds) {

        double fee;

        if (seconds == 0) {
            if (minutes <= 20) {
                fee = minutes * 0.05;
            } else {
                fee = 1 + (minutes - 20) * 0.1;
            }
        } else {
            if ((minutes + 1) <= 20) {
                fee = (minutes + 1) * 0.05;
            } else {
                fee = 1 + (minutes + 1 - 20) * 0.1;
            }
        }

        return fee;

    }


    public static void main(String[] args) throws ParseException {
        String res = charge("2020-10-25 01:59:22", "2020-10-25 02:00:20");
        System.out.println(res);
    }

}
