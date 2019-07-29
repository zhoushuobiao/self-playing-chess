package com.ab.lxoa.utils.data;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;


public class DateUtils{
	private static final long ONE_HOUR_MILLION_SECONDS = 1000L * 60 * 60;
	private static final long ONE_MINUTE_MILLISECONDS = 1000L * 60;

	/**
	 * 服务器当前时间，格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getCurrentTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 获取当前年份
	 * @return
	 */
	public static int getCurYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 今天起始秒数 TODO 这里如果不同时区的用户的话这里需要不同，需要根据用户设置的时区信息来计算
	 * 
	 * @return
	 */
	public static int getTodayStartDateline() {
		String curDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		try {
			long milliseconds = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(curDate + " 00:00:00").getTime();
			return (int) (milliseconds / 1000);
		} catch (ParseException ex) {
			// 这种情况不会发生
			return (int) new Date().getTime() / 1000;
		}
	}

	/**
	 * 返回自从 Unix 新纪元（格林威治时间 1970 年 1 月 1 日 00:00:00）到当前时间的秒数 TODO
	 * 这里如果不同时区的用户的话这里需要不同，需要根据用户设置的时区信息来计算
	 * 
	 * @return
	 */
	public static int getCurrTimeSeconds() {
		// 到秒
		return (int) (System.currentTimeMillis() / 1000);
	}

	public static int toSeconds(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * TODO 这里如果不同时区的用户的话这里需要不同，需要根据用户设置的时区信息来计算
	 * 
	 * @param format
	 * @return
	 */
	public static String getTodayDate(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}

	/**
	 * 秒数转换为yyyy-MM-dd HH:mm的格式返回
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateToFormatStr(Integer date) {
		return getDateToFormatStr(date, false);
	}

	/**
	 * 秒数转换为yyyy-MM-dd 的格式返回
	 * 
	 * @param date
	 * @param subFlag
	 *            截取日期
	 * @return
	 */
	public static String getDateToFormatStr(Integer date, boolean subFlag) {
		if (date == null) {
			return StringUtils.EMPTY;
		}
		String formatStr = "yyyy-MM-dd HH:mm";
		if (subFlag) {
			formatStr = "yyyy-MM-dd";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date * 1000L);
		return (new SimpleDateFormat(formatStr).format(cal.getTime()));
	}

	public static String getDateToStr(Long date) {
		if (date == null) {
			return StringUtils.EMPTY;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date);
		Calendar currentCal = Calendar.getInstance();
		Long dateToNow = System.currentTimeMillis() - date;
		if (currentCal.get(Calendar.YEAR) != cal.get(Calendar.YEAR)) {
			return (new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(cal
					.getTime()));
		}
		if (currentCal.get(Calendar.MONTH) != cal.get(Calendar.MONTH)
				|| currentCal.get(Calendar.DATE) != cal.get(Calendar.DATE)) {
			return (new SimpleDateFormat("MM月dd日 HH:mm").format(cal.getTime()));
		}
		if (dateToNow > ONE_HOUR_MILLION_SECONDS) {
			return (new SimpleDateFormat("今天 HH:mm").format(cal.getTime()));
		}
		if (dateToNow > ONE_MINUTE_MILLISECONDS) {
			return dateToNow / ONE_MINUTE_MILLISECONDS + "分钟前";
		}
		if (dateToNow / 1000 <= 2) {
			// 刚发的
			return "2秒前";
		}
		return dateToNow / 1000 + "秒前";
	}

	public static String getDateToStr(Integer date) {
		if (date == null) {
			return StringUtils.EMPTY;
		}
		return getDateToStr(Long.valueOf(date) * 1000);
	}

	public static String getFeedDirectoryStr(Integer date) {
		Long time = Long.valueOf(date) * 1000;
		return new SimpleDateFormat("yyyyMM").format(new Date(time));
	}

	/**
	 * 一周前秒数 TODO 这里如果不同时区的用户的话这里需要不同，需要根据用户设置的时区信息来计算
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int getAWeekEarlierDateline() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		System.out.println(cal.getTime().toLocaleString());
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 一周前秒数 TODO 这里如果不同时区的用户的话这里需要不同，需要根据用户设置的时区信息来计算
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int getAWeekEarlierDateline(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		System.out.println(cal.getTime().toLocaleString());
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 一月前秒数 TODO 这里如果不同时区的用户的话这里需要不同，需要根据用户设置的时区信息来计算
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int getAMonthEarlierDateline() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, -1);
		System.out.println(cal.getTime().toLocaleString());
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 一月前秒数 TODO 这里如果不同时区的用户的话这里需要不同，需要根据用户设置的时区信息来计算
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int getAMonthEarlierDateline(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		System.out.println(cal.getTime().toLocaleString());
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获取当前周的第一天
	 * 
	 * @param dateStr
	 *            当前时间 "yyyy-MM-dd HH:mm:ss"
	 * @return 当前周的第一天的字符串形式
	 */
	public static int getFirstDayOfWeek(String dateStr) {
		if (StringUtils.isBlank(dateStr))
			return 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(dateStr);
			return getFirstDayOfWeek(date);
		} catch (ParseException e) {
			return 0;
		}
	}

	/**
	 * 获取当前周的第一天
	 * 
	 * @param date
	 *            当前时间
	 * @return 当前周的第一天的字符串形式
	 */
	public static int getFirstDayOfWeek(Date date) {
		if (date == null)
			return 0;
		@SuppressWarnings("unused")
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获取当前周的最后一天
	 * 
	 * @param dateStr
	 *            当前时间
	 * @return 当前周的第一天的字符串形式
	 */
	public static int getLastDayOfWeek(String dateStr) {
		if (StringUtils.isBlank(dateStr))
			return 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(dateStr);
			return getLastDayOfWeek(date);
		} catch (ParseException e) {
			return 0;
		}
	}

	/**
	 * 获取当前周的第一天
	 * 
	 * @param date
	 *            当前时间
	 * @return 当前周的第一天的字符串形式
	 */
	public static int getLastDayOfWeek(Date date) {
		if (date == null)
			return 0;
		@SuppressWarnings("unused")
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 6);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 获取当前月的第一天
	 * 
	 * @param dateStr
	 *            当前时间 "yyyy-MM-dd HH:mm:ss"
	 * @return 当前月的第一天的字符串形式
	 */
	public static int getFirstDayOfMonth(String dateStr) {
		if (StringUtils.isBlank(dateStr))
			return 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(dateStr);
			return getFirstDayOfMonth(date);
		} catch (ParseException e) {
			return 0;
		}
	}

	/**
	 * 获取当前月的第一天
	 * 
	 * @param date
	 *            当前时间
	 * @return 当前月的第一天的字符串形式
	 */
	public static int getFirstDayOfMonth(Date date) {
		if (date == null)
			return 0;
		@SuppressWarnings("unused")
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获取当前月的最后一天
	 * 
	 * @param dateStr
	 *            当前时间 "yyyy-MM-dd HH:mm:ss"
	 * @return 当前月的最后一天的字符串形式
	 */
	public static int getLastDayOfMonth(String dateStr) {
		if (StringUtils.isBlank(dateStr))
			return 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(dateStr);
			return getLastDayOfMonth(date);
		} catch (ParseException e) {
			return 0;
		}
	}

	/**
	 * 获取当前月的最后一天
	 * 
	 * @param date
	 *            当前时间
	 * @return 当前月的最后一天的字符串形式
	 */
	public static int getLastDayOfMonth(Date date) {
		if (date == null)
			return 0;
		@SuppressWarnings("unused")
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		cal.roll(Calendar.DATE, -1);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获取距离格林威治标准时间的天数 1970-01-01 00:00:00
	 * 
	 * @return
	 */
	public static int daysFromGMT() {
		int seconds = DateUtils.getCurrTimeSeconds();
		return seconds / (3600 * 24);
	}

	/**
	 * 转换UTC时间
	 * 
	 * @param utc
	 *            UTC时间字符串 "2015-07-16T11:37:30Z"
	 * @return 转化为秒形式
	 */
	public static int formatUTCToSeconds(String utc) {
		if (StringUtils.isBlank(utc)) {
			return 0;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			return (int) (df.parse(utc).getTime() / 1000);
		} catch (ParseException e) {
			return 0;
		}
	}

	/**
	 * 将 2015-01-01 这种的时间转换成date类型的时间
	 * 
	 * @param sdate
	 * @return
	 */
	public static Date getString2Date(String sdate) {
		if (StringUtils.isEmpty(sdate)) {
			return null;
		}
		String[] sdates = sdate.split("-");
		if (sdates.length != 3) {
			return null;
		}
		try {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(sdates[0]));
			cal.set(Calendar.MONTH, Integer.parseInt(sdates[1]) - 1);
			cal.set(Calendar.DATE, Integer.parseInt(sdates[2]));
			return cal.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(DateUtils.getCurrTimeSeconds());
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		System.out.println(getDateToStr(cal.getTimeInMillis()));

		cal.add(Calendar.SECOND, -10);
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")
				.format(cal.getTime()));
		System.out.println(getDateToStr(cal.getTimeInMillis()));

		cal.add(Calendar.MINUTE, -2);
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")
				.format(cal.getTime()));
		System.out.println(getDateToStr(cal.getTimeInMillis()));

		cal.add(Calendar.HOUR, -1);
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")
				.format(cal.getTime()));
		System.out.println(getDateToStr(cal.getTimeInMillis()));

		cal.add(Calendar.DATE, -1);
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")
				.format(cal.getTime()));
		System.out.println(getDateToStr(cal.getTimeInMillis()));

		/****/
		String dateStr = "2014-02-18 00:00:00";
		System.out.println(getFirstDayOfWeek(dateStr));
		System.out.println(getLastDayOfWeek(dateStr));
		System.out.println(getFirstDayOfMonth(dateStr));
		System.out.println(getLastDayOfMonth(dateStr));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			System.out.println(getAWeekEarlierDateline(sdf
					.parse("2014-02-01 12:00:00")));
			System.out.println(getAMonthEarlierDateline(sdf
					.parse("2014-02-28 12:00:00")));
		} catch (Exception e) {

		}

		try {
			System.out
					.println(sdf.parse("2014-02-06 08:05:00").getTime() / 1000);
			System.out
					.println(sdf.parse("2014-02-28 23:59:59").getTime() / 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
