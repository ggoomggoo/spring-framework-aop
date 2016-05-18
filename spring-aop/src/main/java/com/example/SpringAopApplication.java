package com.example;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.AroundAdvice;
import com.example.demo.TargetClass;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
		
//		AOP basic code
		aopBasic();
	}
	
	public static void aopBasic() {
		
		TargetClass targetClass = new TargetClass(); // target
		AroundAdvice aroundAdvice = new AroundAdvice(); // advice
		ProxyFactory proxyFactory = new ProxyFactory(); // proxyFactory
		
		proxyFactory.addAdvice(aroundAdvice); // set advice
		proxyFactory.setTarget(targetClass); // set target
		
//		proxyFactory.getProxy();
		TargetClass proxy = (TargetClass) proxyFactory.getProxy(); // proxy
		
		proxy.pointMethod(); // execute
		
	}
}
