package com.ysingh.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> beforeAddAccountAdvice - Executing @Before advice on addAccount()");
	}
	
	@Before("execution(public void com.ysingh.springaop.dao.AccountDAO.addAccount())")
	public void beforeAccountDAOAddAccountAdvice() {
		System.out.println("\n====>>> beforeAccountDAOAddAccountAdvice - Executing @Before advice only on AccountDAO addAccount()");
	}
	
	@Before("execution(public void add*())")
	public void beforeAnyMethodStartWithAddAdvice() {
		System.out.println("\n====>>> beforeAnyMethodStartWithAddAdvice - Executing @Before advice on any method start with add");
	}
	
	@Before("execution(boolean add*())")
	public void beforeReturnTypeMatchAdvice() {
		System.out.println("\n====>>> beforeReturnTypeMatchAdvice - Executing @Before advice on boolean return type method start with add");
	}
	
	@Before("execution(* add*())")
	public void beforeAnyReturnTypeMatchAdvice() {
		System.out.println("\n====>>> beforeAnyReturnTypeMatchAdvice - Executing @Before advice on any return type method start with add");
	}
	
	@Before("execution(* add*(com.ysingh.springaop.model.Account))")
	public void beforeSpeficParameterMatchAdvice() {
		System.out.println("\n====>>> beforeSpeficParameterMatchAdvice - Executing @Before advice on specific parameter matching");
	}
	
	@Before("execution(* add*(com.ysingh.springaop.model.Account, ..))")
	public void beforeParameterMatchFollowedByAnyNumberOfArgumentAdvice() {
		System.out.println("\n====>>> beforeParameterMatchFollowedByAnyNumberOfArgumentAdvice - Executing @Before advice on parameter matching followed by any number of arguments");
	}
	
	@Before("execution(* add*(..))")
	public void beforeAnyParameterMatchAdvice() {
		System.out.println("\n====>>> beforeAnyParameterMatchAdvice - Executing @Before advice on match any parameter");
	}
	
	@Before("execution(* com.ysingh.springaop.dao.*.*(..))")
	public void beforePackageNameMatchAdvice() {
		System.out.println("\n====>>> beforePackageNameMatchAdvice - Executing @Before package name match parameter");
	}
}
