package com.example.virus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.example.virus.controller" )
public class SpringVirusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringVirusApplication.class, args);
	}
}
