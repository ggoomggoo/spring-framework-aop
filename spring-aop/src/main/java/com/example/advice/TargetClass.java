package com.example.advice;

public class TargetClass implements TargetInterface {

	@Override
	public void getProducts(String productName) throws Exception {
		System.out.println("start; TargetClass.getProducts()");
		System.out.println(productName);
		
		// 예외 발생
		throw new Exception("error; 강제 발생");
	}


}
