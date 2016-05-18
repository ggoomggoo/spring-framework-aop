package com.example;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.advice.AfterLoggingAdvice;
import com.example.advice.AroundLoggingAdvice;
import com.example.advice.BeforeLoggingAdice;
import com.example.advice.TargetInterface;
import com.example.advice.ThrowsLoggingAdvice;
import com.example.basic.AroundAdvice;
import com.example.basic.TargetClass;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
		
//		executeAopBasic();
		
//		executeAdviceSample();
		
		// test branch
		
	}
	
	/**
	 * AOP basic code
	 * 
	 */
	public static void executeAopBasic() {
		
		TargetClass targetClass = new TargetClass(); // target
		AroundAdvice aroundAdvice = new AroundAdvice(); // advice
		ProxyFactory proxyFactory = new ProxyFactory(); // proxyFactory
		
		proxyFactory.addAdvice(aroundAdvice); // set advice
		proxyFactory.setTarget(targetClass); // set target
		
//		proxyFactory.getProxy();
		TargetClass proxy = (TargetClass) proxyFactory.getProxy(); // proxy
		
		proxy.pointMethod(); // execute
		
	}
	
	/**
	 * advice sample
	 * 
	 */
	public static void executeAdviceSample() {
		
		TargetInterface	target = new com.example.advice.TargetClass(); // 다른 패키지의 동일명 클래스; full path
		
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice(new BeforeLoggingAdice());
		proxyFactory.addAdvice(new AfterLoggingAdvice());
		proxyFactory.addAdvice(new AroundLoggingAdvice());
		proxyFactory.addAdvice(new ThrowsLoggingAdvice());
		
		try {
			TargetInterface proxy = (TargetInterface) proxyFactory.getProxy();
		} catch (Exception e) {
//			e.printStackTrace();
			e.printStackTrace(System.out);
		} finally {
			
		}
		
	}
	
}
