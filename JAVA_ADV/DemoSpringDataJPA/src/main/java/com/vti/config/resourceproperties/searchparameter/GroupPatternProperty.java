package com.vti.testing.config.resourceproperties.searchparameter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This class is group pattern property.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 27, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 27, 2020
 */
@ConfigurationProperties(prefix = "parameter.search.group.pattern")
public class GroupPatternProperty {

	private String key;

	private String operator;

	private String alphanumbericalValue;

	private String dateValue;

	private String dateTimeValue;

	private String value;

	private String wildcardLike;

	private String criteraRegex;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the alphanumbericalValue
	 */
	public String getAlphanumbericalValue() {
		return alphanumbericalValue;
	}

	/**
	 * @param alphanumbericalValue the alphanumbericalValue to set
	 */
	public void setAlphanumbericalValue(String alphanumbericalValue) {
		this.alphanumbericalValue = alphanumbericalValue;
	}

	/**
	 * @return the dateValue
	 */
	public String getDateValue() {
		return dateValue;
	}

	/**
	 * @param dateValue the dateValue to set
	 */
	public void setDateValue(String dateValue) {
		this.dateValue = dateValue;
	}

	/**
	 * @return the datetimeValue
	 */
	public String getDateTimeValue() {
		return dateTimeValue;
	}

	/**
	 * @param dateTimeValue the datetimeValue to set
	 */
	public void setDateTimeValue(String dateTimeValue) {
		this.dateTimeValue = dateTimeValue;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the wildcardLike
	 */
	public String getWildcardLike() {
		return wildcardLike;
	}

	/**
	 * @param wildcardLike the wildcardLike to set
	 */
	public void setWildcardLike(String wildcardLike) {
		this.wildcardLike = wildcardLike;
	}

	/**
	 * @return the criteraRegex
	 */
	public String getCriteraRegex() {
		return criteraRegex;
	}

	/**
	 * @param criteraRegex the criteraRegex to set
	 */
	public void setCriteraRegex(String criteraRegex) {
		this.criteraRegex = criteraRegex;
	}

}
