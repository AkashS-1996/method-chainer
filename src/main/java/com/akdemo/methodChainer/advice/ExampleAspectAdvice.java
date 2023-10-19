package com.akdemo.methodChainer.advice;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspectAdvice {

	Logger logger = LoggerFactory.getLogger(ExampleAspectAdvice.class);
	
	public static List<String> methodNamesChain = new ArrayList<>();

	@Around(value = "@annotation(com.akdemo.methodChainer.advice.LogPrimaryMethodName)")
	public Object logMethodName(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = null;
        try {
		proceed = joinPoint.proceed();
		methodNamesChain.add(0,joinPoint.getSignature().toString());
        } catch (Exception e) {
        	System.out.println("Failure point " + e.getStackTrace()[0].toString() + " with exception " + " " + e.getMessage());
        }
        finally {
        	System.out.println("The call hierarchy of involved methods in this flow is :- ");
			methodNamesChain.forEach(e -> System.out.println( " -> " + e));
			methodNamesChain.clear();
		}
		long executionTime = System.currentTimeMillis() - start;

		System.out.println();
		logger.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		return proceed;
	}
	
	@Before(value = "@annotation(com.akdemo.methodChainer.advice.LogThisMethodName)")
	public void beforeAdvice(JoinPoint jp) {
		//logger.info(jp.getSignature().toString());
		methodNamesChain.add(jp.getSignature().toString());
	}
}