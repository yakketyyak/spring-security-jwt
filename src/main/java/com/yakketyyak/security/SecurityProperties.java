package com.yakketyyak.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "security.jwt")
@Data
@Component
public class SecurityProperties {

	private String secret;

	private long expirationDate;

	private String tokenPrefix;

	private String headerString;

	private String signupUrl;

	public String getTokenPrefix() {

		return this.tokenPrefix.concat(" ");
	}

}
