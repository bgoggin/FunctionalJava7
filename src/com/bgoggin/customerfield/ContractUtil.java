package com.bgoggin.customerfield;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ContractUtil {
    public static Calendar parseDateString(String string) {
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date outDate = null;
        try {
            outDate = formatter.parse(string);
        } catch (ParseException pe) {
            System.err.println("ParseException: " + pe.getMessage());
        }
        return dateToCalendar(outDate);
    }
    public static Calendar dateToCalendar(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }
}
