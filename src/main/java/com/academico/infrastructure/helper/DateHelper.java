package com.academico.infrastructure.helper;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateHelper {

    private static SimpleDateFormat getSimpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    public static String dateToString(Date date) {
        return getSimpleDateFormat().format(date);
    }

    public static Date stringToDate(String date) {

        try {
            return getSimpleDateFormat().parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}