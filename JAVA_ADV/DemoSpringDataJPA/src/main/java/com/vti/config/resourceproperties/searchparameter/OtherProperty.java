package com.vti.config.resourceproperties.searchparameter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "parameter.search")
@Data
public class OtherProperty {

	private String wildcardLike;

	private String linkingAttribute;

	private String linkingAttributeEncode;

}
