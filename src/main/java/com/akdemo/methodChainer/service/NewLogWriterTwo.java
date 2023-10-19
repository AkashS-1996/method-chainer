package com.akdemo.methodChainer.service;

import org.springframework.stereotype.Service;

import com.akdemo.methodChainer.advice.LogThisMethodName;

@Service
public class NewLogWriterTwo {
	@LogThisMethodName
	public void writeSecondNewLog() {

	}
}
