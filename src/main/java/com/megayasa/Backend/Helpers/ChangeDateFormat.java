package com.megayasa.Backend.Helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeDateFormat {

    public static java.sql.Date stringToDateSql(String format, String value) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date parsedDate = simpleDateFormat.parse(value);
            return new java.sql.Date(parsedDate.getTime());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
