package com.vti.utils;

public class Config {
	private static final String REGEX_GROUP_KEY = "(\\w+.*\\w+)";
	private static final String REGEX_GROUP_OPERATOR = "(>=|<=|=|!=|>|<|~)";
	private static final String REGEX_ALPHANUMBERICAL_VALUE = "\\w+\\.*\\w*";

	public static final String REGEX_DATE_VALUE = "\\d{4}\\-\\d{1,2}\\-\\d{1,2}";

	public static final String REGEX_DATE_TIME_VALUE = "\\d{4}\\-\\d{1,2}\\-\\d{1,2}T\\d{1,2}\\:\\d{1,2}\\:\\d{1,2}";

	private static final String REGEX_GROUP_VALUE = "(" + REGEX_DATE_TIME_VALUE + "|" + REGEX_DATE_VALUE + "|"
			+ REGEX_ALPHANUMBERICAL_VALUE + ")";

	private static final String REGEX_GROUP_WILDCARD = "(\\*?)";	// single character * for % like

	public static final String REGEX_SEARCH = REGEX_GROUP_KEY + REGEX_GROUP_OPERATOR + REGEX_GROUP_WILDCARD
			+ REGEX_GROUP_VALUE + REGEX_GROUP_WILDCARD;

	public static String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
	public static String DATE_PATTERN = "yyyy-MM-dd";
}
