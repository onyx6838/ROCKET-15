package com.vti.utils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import org.springframework.util.ObjectUtils;

public class Utils {
	public static boolean isMatchRegex(String input, String regex) {
		// validate input
		if (ObjectUtils.isEmpty(input)) {
			return false;
		}
		// return validation result
		return Pattern.compile(regex).matcher(input).matches();
	}

	public static Date convertStringToDateObject(String input, String pattern) throws ParseException {
		return new SimpleDateFormat(pattern).parse(input);
	}

}
