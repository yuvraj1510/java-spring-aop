package com.ysingh.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ysingh.springaop.around.service.TrafficFortuneService;

public class TestAroundMainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		System.out.println("\n------- TrafficFortuneService STARTS -------");
		TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
		
		String fortune = trafficFortuneService.getFortune();
		System.out.println("Fortune Says : "+fortune);
		
		System.out.println("------- TrafficFortuneService ENDS -------\n");
		
		context.close();
	}

}
