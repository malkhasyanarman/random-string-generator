package com.malkhasyan.stringgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StringGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringGeneratorApplication.class, args);
	}

}
