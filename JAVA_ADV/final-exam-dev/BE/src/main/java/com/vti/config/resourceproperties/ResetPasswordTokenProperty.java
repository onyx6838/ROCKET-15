package com.vti.config.resourceproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "user.resetpassword.token")
public class ResetPasswordTokenProperty {
	private long expirationTime;

}
