package com.example.rentalcar.util;
import org.hibernate.query.criteria.internal.SelectionImplementor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Functions {

    public Date fromStringToDate(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(str);
    }

    public String fromDateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
