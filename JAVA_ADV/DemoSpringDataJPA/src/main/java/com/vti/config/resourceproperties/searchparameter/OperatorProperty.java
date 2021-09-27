package com.vti.testing.config.resourceproperties.searchparameter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This class is operator property of search parameter.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 27, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 27, 2020
 */
@ConfigurationProperties(prefix = "parameter.search.operator")
public class OperatorProperty {

	private String or;

	private String and;

	private String leftParanthesis;

	private String rightParanthesis;

	/**
	 * @return the or
	 */
	public String getOr() {
		return or;
	}

	/**
	 * @param or the or to set
	 */
	public void setOr(String or) {
		this.or = or;
	}

	/**
	 * @return the and
	 */
	public String getAnd() {
		return and;
	}

	/**
	 * @param and the and to set
	 */
	public void setAnd(String and) {
		this.and = and;
	}

	/**
	 * @return the leftParanthesis
	 */
	public String getLeftParanthesis() {
		return leftParanthesis;
	}

	/**
	 * @param leftParanthesis the leftParanthesis to set
	 */
	public void setLeftParanthesis(String leftParanthesis) {
		this.leftParanthesis = leftParanthesis;
	}

	/**
	 * @return the rightParanthesis
	 */
	public String getRightParanthesis() {
		return rightParanthesis;
	}

	/**
	 * @param rightParanthesis the rightParanthesis to set
	 */
	public void setRightParanthesis(String rightParanthesis) {
		this.rightParanthesis = rightParanthesis;
	}

}
