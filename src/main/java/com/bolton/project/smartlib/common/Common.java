package com.bolton.project.smartlib.common;

import java.io.IOException;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Common {

    public int monthBetween(Date d1, Date d2) {
        if (d2 == null || d1 == null) {
            return -1;//Error

        }
        Calendar m_calendar = Calendar.getInstance();
        m_calendar.setTime(d1);
        int nMonth1 = 12 * m_calendar.get(Calendar.YEAR) + m_calendar.get(Calendar.MONTH);
        m_calendar.setTime(d2);
        int nMonth2 = 12 * m_calendar.get(Calendar.YEAR) + m_calendar.get(Calendar.MONTH);
        System.out.println("Date between - " + java.lang.Math.abs(nMonth2 - nMonth1));
        return java.lang.Math.abs(nMonth2 - nMonth1);
    }


    public static long betweenDates(Date firstDate, Date secondDate) throws IOException {
    	long day = ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
        System.out.println("Days - "+ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant()));
        return day;
    }
}
