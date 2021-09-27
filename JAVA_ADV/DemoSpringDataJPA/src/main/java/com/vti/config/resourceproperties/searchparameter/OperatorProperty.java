package com.vti.config.resourceproperties.searchparameter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This class is operator property of search parameter.
 */
@ConfigurationProperties(prefix = "parameter.search.operator")
@Data
public class OperatorProperty {

	private String or;

	private String and;

	private String leftParanthesis;

	private String rightParanthesis;
}
