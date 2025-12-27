package com.ajio.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class CachingSearchProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingSearchProductApplication.class, args);
	}

}
