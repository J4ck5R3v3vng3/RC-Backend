package com.rc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"com.rc.core", "com.rc.service"})
//@EntityScan({"com.rc.entity"})
//@EnableJpaRepositories(basePackages = "com.rc.repository")
public class SpringRefridgeCreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRefridgeCreatorApplication.class, args);
	}
	
	

}