package com.vti.config.resourceproperties.searchparameter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This class is group pattern property.
 */
@Data
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

}
