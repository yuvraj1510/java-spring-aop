package com.ysingh.springaop.joinpoint.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ysingh.springaop.joinpoint.dao.EquipmentDAO;

@Aspect
@Order(3)
@Component
public class JoinPointBaseLoggingAspect {
	
	@Pointcut("execution(void com.ysingh.springaop.joinpoint.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(void com.ysingh.springaop.joinpoint.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(void com.ysingh.springaop.joinpoint.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")	
	public void beforeAddEquipmentAdvice(JoinPoint joinPoint) {
		System.out.println("\n=====>>> JoinPointBaseLoggingAspect - beforeAddEquipmentAdvice - Executing @Before Advice on method");
		
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		System.out.println("\n=====>>> JoinPointBaseLoggingAspect - beforeAddEquipmentAdvice - "+methodSig);
		
		Object[] args = joinPoint.getArgs();
		for(Object arg : args) {
			if(arg instanceof EquipmentDAO) {
				System.out.println("\n=====>>> JoinPointBaseLoggingAspect - beforeAddEquipmentAdvice - ID : "+((EquipmentDAO) arg).getId());
				System.out.println("\n=====>>> JoinPointBaseLoggingAspect - beforeAddEquipmentAdvice - Name : "+((EquipmentDAO) arg).getName());
			} else {
				System.out.println("\n=====>>> JoinPointBaseLoggingAspect - beforeAddEquipmentAdvice - Premium Indicator : "+arg);
			}
			
		}
	}
	
	@AfterReturning(
			pointcut="execution(* com.ysingh.springaop.joinpoint.dao.EquipmentDAO.findEquipments(..))",
			returning="result")
	public void afterReturningGetEquipmentAdvice(JoinPoint joinPoint, List<EquipmentDAO> result) {
		System.out.println("\n=====>>> JoinPointBaseLoggingAspect - afterReturningGetEquipmentAdvice:");
		
		result.stream().forEach(System.out::println);
		
		EquipmentDAO equipmentDAO = new EquipmentDAO();
		equipmentDAO.setId("ID-004");
		equipmentDAO.setName("Adapter");
		
		result.add(equipmentDAO);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.ysingh.springaop.joinpoint.dao.EquipmentDAO.deleteEquipment(..))",
			throwing="ex")
	public void afterThrowingDeleteEquipmentAdvice(JoinPoint joinPoint, Throwable ex) {
		System.out.println("\n=====>>> JoinPointBaseLoggingAspect - afterThrowingDeleteEquipmentAdvice:");
		System.out.println("The exception is : "+ex);
	}
	
	@After("execution(* com.ysingh.springaop.joinpoint.dao.EquipmentDAO.deleteEquipment(..))")
	public void afterDeleteEquipmentAdvice() {
		System.out.println("\n=====>>> JoinPointBaseLoggingAspect - afterDeleteEquipmentAdvice: RELEASING CONNECTIONS");
	}

	@Around("execution(* com.ysingh.springaop.around.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object proceed = proceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		System.out.println("\n=====>>> Duration: " + (end - start)/1000.0 + " seconds");
		return proceed;
	}
}
