package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.config.ApiKeyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApiKeyConfig.class)
public class CrazyAirApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrazyAirApplication.class, args);
	}
}
