package com.usoft.suntg.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.usoft.suntg"})
public class TestGrpcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestGrpcClientApplication.class, args);
	}
}
