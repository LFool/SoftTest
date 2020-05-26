package com.lfool.test01;

/**
 * @ClassName: NextData
 * @Description: TODO
 * @Author: LFool
 * @Date: 2020/5/26 22:29
 * @Version: 1.0
 */
public class NextDate {

    /*********************************************************
     **Method: run
     **Returns: string
     **Description: This method will return a string depicting the nextDate in the from MM/DD/YY
     ***********************************************************/

    public static String run(int month, int day, int year) {

        /* Restrictions that the year must have the following invariant: 1801 <= year <= 2021 */
        if (day < 1 || month < 1 || month >12 || year < 1801 || year > 2021) {
            return "invalid Input Date";
        }

        /* these variables will hold the proper values for the nextDate's day, month, and year values, respectively */
        int tomorrowDay = day;
        int tomorrowMonth = month;
        int tomorrowYear = year;

        /* Is this month with 31 days? */
        if(isThirtyOneDayMonth(month)) {
            /* if the day is not 31, just increment the day */
            if (day < 31) {
                tomorrowDay = day +1;
            } else{ //day = 31, set tomorrow's day to 1 and increment the month
                tomorrowDay = 1;
                tomorrowMonth = month + 1;
            }
        }
        /* is this month a month with 30 days? */
        else if (isThirtyDayMonth(month)) {
            /* if the day is not 30, just increment the day */
            if(day <30){
                tomorrowDay = day + 1;
            } else {
                if (day == 30) {
                    tomorrowDay = 1;
                    tomorrowMonth = month + 1;
                } else { //invalid input ... too many days
                    return "Invalid Input Date";
                }
            }

        }
        /* is this month December? */
        else if(isDecember(month)) {
            /* if the day is not 31, just increment the next day */
            if (day < 31) {
                tomorrowDay = day + 1;
            } else { // day is 31, reset the day and month to 1 and increment the year
                tomorrowDay = 1;
                tomorrowMonth = 1;
                /* m ake sure the next year is within ht permissible range */
                if (year == 2021) {
                    return "Invalid Next Year";
                } else {  //it was a permissible year - go ahead and increment the year
                    tomorrowYear = year + 1;
                }
            }
        }
        //is this month February? we need to check for leap years and such
        else if(isFebruary(month)) {
            /* just a standard day - increment the day */
            if(day < 28) {
                tomorrowDay =day +1;
            } else {
                /* if this is not a leap year, reset day and increment the day */
                if(day == 28) {
                    /* was a leap year */
                    if (isLeapYear(year)) {
                        tomorrowDay = 29;
                    } else {  // was not a leap year
                        tomorrowDay = 1;
                        tomorrowMonth = 3;
                    }
                    /* 29th date of February */
                } else if(day == 29){
                    /* AND a leap year - reset the day to 1, month to 3 */
                    if (isLeapYear(year)) {
                        tomorrowDay = 1;
                        tomorrowMonth = 3;
                    } else {
                        return "Invalid Input Date";
                    }
                    /* invalid input as February will never have more than 29 days */
                } else {
                    return "Invalid Input Date";
                }
            }
        }
        /* return the string representing the nextDate, in the form MM/DD/YY */
        return tomorrowMonth + "/" + tomorrowDay + "/" + tomorrowYear;

    }


    /*********************************************
     * Method: isThirtyOneDayMonth
     * @param month
     * @returns boolean
     * Description: This method will return true is 'month' corresponds to a
     * month that contains 31 days, excluding December
     */

    private static boolean isThirtyOneDayMonth(int month) {
        return month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10;
    }


    /*************************************************
     * Method: isThirtyDayMonth
     * @param month
     * @returns boolean
     * Description: This method will return true if 'month' corresponds to a
     * month that contains 30 days.	 *
     */

    private static boolean isThirtyDayMonth(int month) {
        return month == 4 || month == 6 || month == 9 || month == 11;
    }


    /**************************************************
     * Method: isDecember
     * @param month
     * @returns boolean
     * Description: This method will return true if 'month' corresponds to
     * December
     */

    private static boolean isDecember(int month) {
        return month == 12;
    }


    /****************************************************
     * Method: isFebruary
     * @param month
     * @returns boolean
     * Description: This method will return true if 'month' corresponds to
     * February
     */

    private static boolean isFebruary(int month) {
        return month == 2;
    }


    /*****************************************************
     * Method: isLeapYear
     * @param year
     * @returns boolean
     * Description: This method will return true if 'year' corresponds to a
     * leap year. It works like this:
     * 			*If the year is not a century year and divisible by 4,
     * 			then it is a leap year
     * 			*If the year is a century year, it is a leap year if and only if
     * 			it is divisible by 400
     */

    private static boolean isLeapYear(int year) {
        if((year % 100) == 0) {
            return (year % 400) == 0;
        } else {
            return (year % 4) == 0;
        }
    }

}
