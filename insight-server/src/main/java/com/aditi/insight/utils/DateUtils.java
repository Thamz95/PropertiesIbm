package com.aditi.insight.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtils {

	public static XMLGregorianCalendar convertInstantToXMLGregorianCalendar(Instant instant) throws Exception {

		GregorianCalendar grCal = new GregorianCalendar();
		grCal.setTimeInMillis(instant.toEpochMilli());
		XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(grCal);
		return xmlGregorianCalendar;
	}

	public static XMLGregorianCalendar convertDateToXMLGregorianCalendar(Date date) throws Exception {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		return xmlGregorianCalendar;
	}

	public static String getDateAString(Date input) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(input);

	}

}
