package com.ysingh.springaop.declarative.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class DeclarativeLoggingAspect {

	@Pointcut("execution(* com.ysingh.springaop.declarative.dao.*.*(..))")
	private void forDaoPackage() {}

	@Pointcut("execution(* com.ysingh.springaop.declarative.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.ysingh.springaop.declarative.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterAndSetter() {}
	
	@Before("forDaoPackageNoGetterAndSetter()")
	public void beforePackageNameMatchAdvice() {
		System.out.println("\n====>>> DeclarativeLoggingAspect - beforePackageNameMatchAdvice - Executing @Before package name match parameter");
	}
	
	@Before("forDaoPackageNoGetterAndSetter()")
	public void performAPIAnalytics() {
		System.out.println("\n====>>> DeclarativeLoggingAspect - performAPIAnalytics - Performing API Analytics");
	}
}
