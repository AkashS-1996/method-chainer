package com.akdemo.methodChainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akdemo.methodChainer.advice.LogThisMethodName;

@Service
public class CheckPositiveOrNegative {

	@Autowired
	private SampleLogService sampleLogService;
	
	@LogThisMethodName
	public boolean checkPositiveOdd(int n) {
		sampleLogService.newLogWriter();
		return n/0 == 1;
	}
	
	@LogThisMethodName
	public boolean checkNegativeOdd(int n) {
		sampleLogService.newLogWriter();
		return n%2 == 1;
	}
}
