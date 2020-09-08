package com.yum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="com.yum.Repository")
@SpringBootApplication
public class MyYum1Application {

	public static void main(String[] args) {
		SpringApplication.run(MyYum1Application.class, args);
	}

}
