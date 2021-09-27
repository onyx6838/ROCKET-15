package com.vti.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

/**
 * This class is method utils.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 6, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 6, 2019
 */
public class MethodUtil {

	/**
	 * This method is check regular.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 6, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 6, 2019
	 * @param input   - input string.
	 * @param regular - Regular Expression.
	 * @return boolean
	 */
	public static boolean checkRegularExpression(String input, String regular) {
		// validate input
		if (StringUtils.isEmpty(input)) {
			return false;
		}

		// return validation result
		return Pattern.compile(regular).matcher(input).matches();
	}

	public static String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
	public static String DATE_PATTERN = "yyyy-MM-dd";

	/**
	 * This method is converted String to Date Object (Default).
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 14, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 14, 2020
	 * @param input
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDateTime(String input) throws ParseException {
		return convertStringToDateObject(input, DATE_TIME_PATTERN);
	}

	/**
	 * This method is converted String to Date Object (Default).
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 14, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 14, 2020
	 * @param input
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String input) throws ParseException {
		return convertStringToDateObject(input, DATE_PATTERN);
	}

	/**
	 * This method is converted String to Date Object.
	 * https://stackoverflow.com/questions/4216745/java-string-to-date-conversion
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 14, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 14, 2020
	 * @param input
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDateObject(String input, String pattern) throws ParseException {
		return new SimpleDateFormat(pattern).parse(input);
	}
}
