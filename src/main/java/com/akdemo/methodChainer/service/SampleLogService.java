package com.akdemo.methodChainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akdemo.methodChainer.advice.LogThisMethodName;

@Service
public class SampleLogService {

	@Autowired
	private NewLogWriterTwo newLogWriterTwo;
	
	@LogThisMethodName
	public void newLogWriter() {
		newLogWriterTwo.writeSecondNewLog();
		//int x = 1/0;
	}
}
