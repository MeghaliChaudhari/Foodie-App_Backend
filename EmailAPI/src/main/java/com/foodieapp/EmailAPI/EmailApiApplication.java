package com.foodieapp.EmailAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmailApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailApiApplication.class, args);
	}

}
