package com.jeffreyghj.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	
	// setup pointcut declarations
	@Pointcut("execution(* com.jeffreyghj.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.jeffreyghj.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.jeffreyghj.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// @Before
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		System.out.println("=====>>> @Before: calling method: " + theMethod);
		
		Object[] args = theJoinPoint.getArgs();
		
		for ( Object tempArg : args ) {
			System.out.println("=====>> argument: " + tempArg);
		}
	}
	
	// @AfterReturning
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		System.out.println("=====>>> @AfterReturning: from method: " + theMethod);
		
		System.out.println("=====>> result: " + theResult);
	}
}
