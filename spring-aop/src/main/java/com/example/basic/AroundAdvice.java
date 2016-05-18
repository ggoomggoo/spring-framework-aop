package com.example.basic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String sb = "실행전";
		System.out.println(sb);
		
		Object ret = invocation.proceed();
		if (ret != null) {
			System.out.println(ret.toString());
		}
		
		String sa = "실행후";
		System.out.println(sa);
				
		return ret;
	}

}
