package com.JPAExample.JPAExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Something to note, if scanBasePackages is used, it must declare all pacakges. Spring will no long behave as expected with out the ScanBasePackage.
@SpringBootApplication(scanBasePackages = {"dao","com.JPAExample.JPAExample.rest","com.JPAExample.JPAExample.crud","com.JPAExample.JPAExample.service"})
public class JpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}
//DID not finish: left off on video 539. Spring Boot - Creating JPA DAO Implementation for REST API 
}
