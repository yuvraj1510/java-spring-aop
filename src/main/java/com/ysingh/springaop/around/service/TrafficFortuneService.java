package com.ysingh.springaop.around.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneService {

	public String getFortune() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Expect heavy traffic this morning";
	}
}
