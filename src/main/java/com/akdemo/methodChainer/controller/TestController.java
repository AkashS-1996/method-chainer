package com.akdemo.methodChainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.akdemo.methodChainer.advice.LogPrimaryMethodName;
import com.akdemo.methodChainer.service.CheckPositiveOrNegative;

@RestController
public class TestController {
  
	@Autowired
	private CheckPositiveOrNegative checkPositiveOrNegative;
	
	@LogPrimaryMethodName
	@GetMapping("/test/{n}")
	public ResponseEntity<String> testMyCustomAnnotation(@PathVariable int n){
		boolean answer = Boolean.TRUE;

		if (n > 0) {
			answer = checkPositiveOrNegative.checkPositiveOdd(n);
			if (answer)
				System.out.println("The number is an positive odd number");
			else
				System.out.println("Even positive number");
		} else {
			answer = checkPositiveOrNegative.checkNegativeOdd(n);
			if (answer)
				System.out.println("The number is an negative odd number");
			else
				System.out.println("Even negative number");
		}
		return new ResponseEntity<>("Hello",HttpStatus.OK);
	}

}