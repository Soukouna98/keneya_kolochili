package com.keneya.kolochili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KolochiliApplication {

	public static void main(String[] args) {
		SpringApplication.run(KolochiliApplication.class, args);
	}

}
