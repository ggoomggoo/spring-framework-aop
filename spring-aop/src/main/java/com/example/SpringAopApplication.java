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
		
		TargetClass targetClass = new TargetClass();
		
		AroundAdvice aroundAdvice = new AroundAdvice();
		
		ProxyFactory proxyFactory = new ProxyFactory();
		
		proxyFactory.addAdvice(aroundAdvice);
		
		proxyFactory.setTarget(targetClass);
		
//		proxyFactory.getProxy();
		TargetClass proxy = (TargetClass) proxyFactory.getProxy();
		
		proxy.pointMethod();
		
	}
}
