package com.tipme.utils;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Lazy
public class DateFormatter {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static DateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private static DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final Map<Integer, String> monthsOfYear;
    private static final Map<Integer, String> daysOfWeek;
    static {
        Map<Integer, String> unmodMonthMap = new HashMap<>();
        Map<Integer, String> unmodDayMap = new HashMap<>();

        unmodMonthMap.put(1, "January");
        unmodMonthMap.put(2, "February");
        unmodMonthMap.put(3, "March");
        unmodMonthMap.put(4, "April");
        unmodMonthMap.put(5, "May");
        unmodMonthMap.put(6, "June");
        unmodMonthMap.put(7, "July");
        unmodMonthMap.put(8, "August");
        unmodMonthMap.put(9, "September");
        unmodMonthMap.put(10, "October");
        unmodMonthMap.put(11, "November");
        unmodMonthMap.put(12, "December");
        unmodDayMap.put(0, "Sunday");
        unmodDayMap.put(1, "Monday");
        unmodDayMap.put(2, "Tuesday");
        unmodDayMap.put(3, "Wednesday");
        unmodDayMap.put(4, "Thursday");
        unmodDayMap.put(5, "Friday");
        unmodDayMap.put(6, "Saturday");
        monthsOfYear = Collections.unmodifiableMap(unmodMonthMap);
        daysOfWeek = Collections.unmodifiableMap(unmodDayMap);
    }

    public static String DateToString(Date aDate) {
        return dateFormat.format(aDate) + " " + timeFormat.format(aDate);
    }

    public static String DateToStringDate(Date aDate) {
        return dateFormat.format(aDate);
    }

    public static Date StringToDate(String dateText) {
        try {
            return dateFormat.parse(dateText);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date StringToDateTime(String dateText) {
        try {
            return dateTimeFormat.parse(dateText);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String getHourFromDate(Date aDate){
        return timeFormat.format(aDate);
    }

    public static String getMonthStringFromIndex(Integer monthOfYear){
        return monthsOfYear.get(monthOfYear);
    }

    public static String getDayOfWeekStringFromIndex(Integer dayOfWeek){
        return daysOfWeek.get(dayOfWeek);
    }

    public static Boolean isDateBirthdayValid(Date dateBirthday) {
        Boolean isValid = false;

        // 13 Years old
        Calendar calendar  = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -13);
        Date date = calendar.getTime();

        if(dateBirthday.before(date)) {
            isValid = true;
        }

        return isValid;
    }
}
