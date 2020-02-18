package com.travix.medusa.busyflights.util;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * Method to parse date from string
     * @param date to be parsed
     * @return Date object of the input date
     * @throws ParseException
     */
    public static Date formatDate(@NotNull final String date) throws ParseException {
       return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

}
