package com.akdemo.methodChainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MethodChainerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MethodChainerApplication.class, args);
	}
}
