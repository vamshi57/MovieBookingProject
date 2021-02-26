package com.vamshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookingServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRT() {
		return new RestTemplate();
	}
	

}
