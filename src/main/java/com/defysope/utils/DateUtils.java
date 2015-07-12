package com.defysope.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;
import org.joda.time.format.DateTimeFormat;

/**
 * @author Sayeed Anjum
 */
public class DateUtils {
	public static final String YMD_TIME_ZONE = "yyyy-MM-dd HH:mm:ss.0 Z";

	public static final String ISO_FORMAT = "yyyy-MM-dd HH:mm:ss.0";

	public static final String DMY_FORMAT = "dd MMM yyyy";

	public static final String DMY_HM_FORMAT = "dd MMM yyyy hh:mm:ss a";

	public static final String TIME_FORMAT_12_HOURS = "h:mm:ss a";

	public static final String TIME_FORMAT_24_HOURS = "HH:mm";

	public static final String YMD_FORMAT = "yyyy-MM-dd";

	public static final int MINUTES_IN_DAY = 1440;

	public static final long ONEDAY = 1000 * 60 * 60 * 24;

	public static final String FULLMONTH_YEAR_FORMAT = "MMMMMMMMMMMM yyyy";

	public static final String ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

public static final String[] ALLOWED_DATE_FORMATS = { 
			DMY_HM_FORMAT, DMY_FORMAT, ISO_FORMAT, YMD_TIME_ZONE, ISO_8601,
			"dd-MMM-yyyy", "dd/MM/yyyy", "d/MM/yyyy", "dd-MMM-yy", "dd-MM-yyyy"};

	public static Date parseDate(long timeInMilliSeconds) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeInMillis(timeInMilliSeconds);
		return cal.getTime();
	}

	public static Date parseDate(String date) {
		return parseDate(date, DMY_FORMAT);
	}

	public static Date parseISO8601Date(String date) {
		return parseDate(date, ISO_8601);
	}

	public static Date parseDateTime(String date) {
		return parseDate(date, DMY_HM_FORMAT);
	}

	public static GregorianCalendar parseCalendar(String date) {
		return parseCalendar(date, DMY_FORMAT);
	}

	public static GregorianCalendar parseCalendarTime(String date) {
		return parseCalendar(date, DMY_HM_FORMAT);
	}

	public static Date parseDate(String date, String format) {
		Date result = null;
		SimpleDateFormat df = new SimpleDateFormat(format);
		
		try {
			ParsePosition pp = new ParsePosition(0);
			result = StringUtils.isEmpty(date) ? null : df.parse(date, pp);
			if (date.length() != pp.getIndex()) {
				result = null;
			}
		} catch (Exception e) {
			// do nothing
		}
		return result;
	}

	public static GregorianCalendar parseCalendar(String date, String format) {
		GregorianCalendar result = null;
		Date d = parseDate(date, format);
		if (d != null) {
			result = new GregorianCalendar();
			result.setTime(d);
		}
		return result;
	}

	/**
	 * Formats the given date into ISO format. e.x.: 2003-03-01 00:00:00.0
	 * 
	 * @param date
	 *            The date to be formatted.
	 * @return The formatted date as a string.
	 */
	public static String formatDateISO(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(ISO_FORMAT);
		return date == null ? "" : f.format(date);
	}

	public static String formatISO8601Date(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(ISO_8601);
		return date == null ? "" : f.format(date);
	}

	/**
	 * Formats the given date into ISO format. e.x.: 2003-03-01 00:00:00.0
	 * 
	 * @param cal
	 *            The Gregorian Calendar object to be formatted.
	 * @return The formatted date as a string.
	 */
	public static String formatDateISO(GregorianCalendar cal) {
		SimpleDateFormat f = new SimpleDateFormat(ISO_FORMAT);
		return cal == null ? "" : f.format(cal.getTime());
	}

	/**
	 * Formats the given date into 'h:mm:ss a' format. e.x.: 12:30:00 PM or
	 * 'HH:mm' format e.x.:13:30 based on the given format
	 * 
	 * @param date
	 *            The date to be formatted.
	 * @return The formatted date as a string.
	 */
	public static String formatTime(Date date, String format) {
		SimpleDateFormat f = new SimpleDateFormat(format);
		return date == null ? "" : f.format(date);
	}

	/**
	 * Formats the given date into 'dd MMM yyyy' format. e.x.: 01 May 2003
	 * 
	 * @param date
	 *            The date to be formatted.
	 * @return The formatted date as a string.
	 */
	public static String formatDate(Date d) {
		return formatDate(d, DMY_FORMAT);
	}

	/**
	 * Formats the given calendar into 'dd MMM yyyy' format. e.x.: 01 May 2003
	 * 
	 * @param cal
	 *            The calendar to be formatted.
	 * @return The formatted date as a string.
	 */
	public static String formatDate(GregorianCalendar cal) {
		return cal == null ? "" : formatDate(cal.getTime(), DMY_FORMAT);
	}

	/**
	 * Formats the given timestamp into 'dd MMM yyyy h:mm:ss a' format. e.x.: 01
	 * May 2003 12:30:00 PM
	 * 
	 * @param cal
	 *            The calendar to be formatted.
	 * @return The formatted date as a string.
	 */
	public static String formatDateTime(Timestamp t) {
		return t == null ? ""
				: formatDate(new Date(t.getTime()), DMY_HM_FORMAT);
	}

	/**
	 * Formats the given timestamp into 'dd MMM yyyy h:mm:ss a' format. e.x.: 01
	 * May 2003 12:30:00 PM
	 * 
	 * @param cal
	 *            The calendar to be formatted.
	 * @return The formatted date as a string.
	 */
	public static String formatDateTime(Date d) {
		return d == null ? "" : formatDate(d, DMY_HM_FORMAT);
	}

	/**
	 * Formats the given timestamp into 'dd MMM yyyy h:mm:ss a' format. e.x.: 01
	 * May 2003 12:30:00 PM
	 * 
	 * @param cal
	 *            The calendar to be formatted.
	 * @return The formatted date as a string.
	 */
	public static String formatDateTime(GregorianCalendar c) {
		return c == null ? "" : formatDate(c.getTime(), DMY_HM_FORMAT);
	}

	public static String formatDate(Date d, String format) {
		SimpleDateFormat f = new SimpleDateFormat(format);
		return d == null ? "" : f.format(d);
	}

	public static void blankTimePart(GregorianCalendar cal) {
		cal.set(GregorianCalendar.HOUR, 0);
		cal.set(GregorianCalendar.MINUTE, 0);
		cal.set(GregorianCalendar.SECOND, 0);
		cal.set(GregorianCalendar.MILLISECOND, 0);
		cal.set(GregorianCalendar.AM_PM, GregorianCalendar.AM);
	}

	public static Date blankTimePart(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(GregorianCalendar.HOUR, 0);
		cal.set(GregorianCalendar.MINUTE, 0);
		cal.set(GregorianCalendar.SECOND, 0);
		cal.set(GregorianCalendar.MILLISECOND, 0);
		cal.set(GregorianCalendar.AM_PM, GregorianCalendar.AM);
		return cal.getTime();
	}

	public static long differenceInMonths(Date date1, Date date2) {
		GregorianCalendar d1 = new GregorianCalendar();
		GregorianCalendar d2 = new GregorianCalendar();
		if (date1.before(date2)) {
			d1.setTime(date1);
			d2.setTime(date2);
		} else {
			d1.setTime(date2);
			d2.setTime(date1);
		}
		long result = (d2.get(Calendar.YEAR) * 12 + (d2.get(Calendar.MONTH) + 1))
				- (d1.get(Calendar.YEAR) * 12 + (d1.get(Calendar.MONTH) + 1));
		return result;
	}

	/**
	 * utility function which returns the minutes from HH:mm
	 * 
	 * @param hours
	 * @return
	 */
	public static int getMinutes(String hours) {
		if (StringUtils.isEmpty(hours)) {
			hours = "00:00";
		}
		int hour = NumberUtils.toInt(hours.substring(0, 2));
		int min = NumberUtils.toInt(hours.substring(3));
		int minutes = (hour * 60) + min;
		return minutes;
	}

	/**
	 * Returns week number of the month for the given date
	 * 
	 * @param date
	 * @return integer (WeekNumber of the Month)
	 */
	public static int getWeekOfMonth(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(GregorianCalendar.WEEK_OF_MONTH);
	}

	public static String getISODateString(String dt) throws ParseException {
		return formatDateISO(parseDate(dt));
	}

	/**
	 * Returns the difference in days between two dates.
	 * 
	 * @param lowDate
	 *            The lower date value
	 * @param hiDate
	 *            The higher date value
	 * @return The difference in days between hiDate and lowDate
	 */
	public static long dateDiff(Date lowDate, Date hiDate) {
		long ms = hiDate.getTime() - lowDate.getTime();
		return ms / ONEDAY;
	}

	/**
	 * Returns a string in the format hh:mm
	 * 
	 * @param minutes
	 * @return the formatted string
	 */
	public static String getHourString(int minutes) {
		return StringUtils.leftPad(String.valueOf(minutes / 60), 2, '0') + ":"
				+ StringUtils.leftPad(String.valueOf(minutes % 60), 2, '0');
	}

	/**
	 * @return
	 */
	public static Date now() {
		return new GregorianCalendar().getTime();
	}

	public static Date today() {
		GregorianCalendar cal = new GregorianCalendar();
		DateUtils.blankTimePart(cal);
		return cal.getTime();
	}

	public static Date yesterday() {
		GregorianCalendar cal = new GregorianCalendar();
		DateUtils.blankTimePart(cal);
		cal.add(GregorianCalendar.DATE, -1);
		return cal.getTime();
	}

	public static Date weekFromNow() {
		GregorianCalendar cal = new GregorianCalendar();
		DateUtils.blankTimePart(cal);
		cal.add(GregorianCalendar.DATE, +7);
		return cal.getTime();
	}

	public static Date monthFromNow() {
		GregorianCalendar cal = new GregorianCalendar();
		DateUtils.blankTimePart(cal);
		cal.add(GregorianCalendar.MONTH, +1);
		return cal.getTime();
	}

	public static String getDayAndDateKey(GregorianCalendar cal) {
		final String weekDays[] = { "", "S", "M", "T", "W", "T", "F", "S" };
		String s = weekDays[cal.get(GregorianCalendar.DAY_OF_WEEK)];
		s += "-" + cal.get(GregorianCalendar.DATE);
		return s;
	}

	public static Date firstOfThisMonth() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(GregorianCalendar.DATE, 1);
		return cal.getTime();
	}
	
	public static Date endOfThisMonth() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(GregorianCalendar.DAY_OF_MONTH, cal
				.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
		return cal.getTime();
	}
	
	public static String getMonthName(int key) {
		final String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
				"Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		return months[key];
	}
	
	public static String getFullMonthName(int key) {
		final String months[] = { "January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December" };
		return months[key];
	}
	
	public static String getMonthName(GregorianCalendar cal) {
		return getMonthName(cal.get(GregorianCalendar.MONTH));
	}

	/**
	 * Returns the effective year based on the start month. If start month is 1
	 * (Jan), the year will be the same as the year of date supplied. If start
	 * month is > 1 (Feb, Mar, etc.), the year will be: (year - 1) for months <
	 * start month (year) for months >= start month
	 * 
	 * @param date
	 * @param startMonth
	 * @return the logical year based on the start month
	 */
	public static int getEffectiveYear(Date date, int startMonth) {
		int year = 0;
		if (date == null) {
			return year;
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		DateUtils.blankTimePart(cal);

		--startMonth; // we accept 1-based month but work with 0-based month
		if (startMonth != GregorianCalendar.JANUARY) {
			int lastmonth = startMonth;
			GregorianCalendar lastdate = new GregorianCalendar(cal
					.get(Calendar.YEAR), lastmonth, 1);
			lastdate.add(GregorianCalendar.DATE, -1);
			if (cal.after(lastdate)) {
				year = cal.get(Calendar.YEAR);
			} else {
				year = cal.get(Calendar.YEAR) - 1;
			}
		} else {
			year = cal.get(Calendar.YEAR);
		}
		return year;
	}

	public static Date dateAdd(int datePart, int incrementValue, Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		blankTimePart(cal);
		switch (datePart) {
		case GregorianCalendar.MONTH:
			cal.add(GregorianCalendar.MONTH, incrementValue);
			break;
		case GregorianCalendar.YEAR:
			cal.add(GregorianCalendar.YEAR, incrementValue);
			break;
		case GregorianCalendar.DAY_OF_MONTH:
			cal.add(GregorianCalendar.DAY_OF_MONTH, incrementValue);
			break;
		default:
			break;
		}
		return cal.getTime();
	}

	public static int get(int date_part, Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		switch (date_part) {
		case Calendar.DAY_OF_MONTH:
			return cal.get(Calendar.DAY_OF_MONTH);
		case Calendar.YEAR:
			return cal.get(Calendar.YEAR);
		case Calendar.MONTH:
			return cal.get(Calendar.MONTH);
		default:
			break;
		}
		return 0;
	}

	public static Date parseDateWithAllowedFormat(String dateString) {
		for (int i = 0; i < ALLOWED_DATE_FORMATS.length; i++) {
			Date date = parseDate(dateString, ALLOWED_DATE_FORMATS[i]);
			if (date != null) {
				return date;
			}
		}
		return null;
	}

	public static int differenceInSeconds(Date lowDate, Date hiDate) {
		long ms = hiDate.getTime() - lowDate.getTime();
		return (int) (ms / 1000);

	}

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		ParsePosition pp = new ParsePosition(0);
		String input = "01/05/2004";
		Date d = sdf.parse(input, pp);
		System.out.println(d + ": length=" + input.length() + ", index="
				+ pp.getIndex() + " Match: "
				+ (input.length() == pp.getIndex()));

		pp = new ParsePosition(0);
		input = "05/21/2a00e";
		d = sdf.parse(input, pp);
		System.out.println(d + ": length=" + input.length() + ", index="
				+ pp.getIndex() + " Match: "
				+ (input.length() == pp.getIndex()));
	}

	/**
	 * Returns the number of occurrences of given day in the given date range
	 * 
	 * @param fromDate
	 *            From Date
	 * @param toDate
	 *            To Date
	 * @param day
	 *            The day of the week to be searched.
	 * @return The number of occurrences of day as an integer.
	 */
	public static int getDayCount(GregorianCalendar fromDate,
			GregorianCalendar toDate, int day) {

		long noOfDays = DateUtils
				.dateDiff(fromDate.getTime(), toDate.getTime()) + 1;
		int noOfWeeks = (int) noOfDays / 7;
		int extraDays = (int) noOfDays % 7;

		// Weekdays 1-Sun,2-Mon,3-Tue,4-Wed,5-Thu,6-Fri,7-Sat
		ArrayList<Integer> checkList = new ArrayList<Integer>();
		if (day > 7 || day < 0) {
			day = 1;
		}
		int dayNum = day;
		for (int i = 0; i < extraDays; i++) {
			checkList.add(dayNum--);
			if (dayNum == 0) {
				dayNum = 7;
			}
		}
		int additionalDay = 0;
		for (int i = 0; i < checkList.size(); i++) {
			if (fromDate.get(GregorianCalendar.DAY_OF_WEEK) == checkList.get(i)) {
				additionalDay = 1;
				break;
			}
		}
		return (noOfWeeks + additionalDay);
	}

	public DateTime blankTimePart(DateTime date) {
		Property millisOfDay = date.millisOfDay();
		return date.minus(millisOfDay.get());
	}

	public static String formatDate(DateTime fromDate, String pattern) {
		return DateTimeFormat.forPattern(pattern).print(fromDate);
	}

	public static DateTime toDateTime(String date, String pattern) {
		return DateTimeFormat.forPattern(pattern).parseDateTime(date);
	}

	public static DateTime toDateTime(String date) {
		return DateTimeFormat.forPattern(DMY_FORMAT).parseDateTime(date);
	}
}