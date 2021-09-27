package com.vti.testing.config.resourceproperties.searchparameter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This class is other property.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 27, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 27, 2020
 */
@ConfigurationProperties(prefix = "parameter.search")
public class OtherProperty {

	private String wildcardLike;

	private String linkingAttribute;

	private String linkingAttributeEncode;

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
	 * @return the linkingAttribute
	 */
	public String getLinkingAttribute() {
		return linkingAttribute;
	}

	/**
	 * @param linkingAttribute the linkingAttribute to set
	 */
	public void setLinkingAttribute(String linkingAttribute) {
		this.linkingAttribute = linkingAttribute;
	}

	/**
	 * @return the linkingAttributeEncode
	 */
	public String getLinkingAttributeEncode() {
		return linkingAttributeEncode;
	}

	/**
	 * @param linkingAttributeEncode the linkingAttributeEncode to set
	 */
	public void setLinkingAttributeEncode(String linkingAttributeEncode) {
		this.linkingAttributeEncode = linkingAttributeEncode;
	}

}
