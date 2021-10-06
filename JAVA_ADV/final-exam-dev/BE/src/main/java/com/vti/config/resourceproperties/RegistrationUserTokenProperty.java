package com.vti.config.resourceproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "user.registration.token")
public class RegistrationUserTokenProperty {

	private long expirationTime;
}
