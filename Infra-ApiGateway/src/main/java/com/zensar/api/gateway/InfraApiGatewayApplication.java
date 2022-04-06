package com.zensar.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InfraApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfraApiGatewayApplication.class, args);
	}

}
