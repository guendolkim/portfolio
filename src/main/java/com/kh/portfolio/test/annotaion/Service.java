package com.kh.portfolio.test.annotaion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service {

	@PrintAnnotation  					//값이 없으면 디폴트 값으로 정의됨.
	public void method1() {
		System.out.println("method1() 실행");
	}
	@PrintAnnotation("*")				//
	public void method2() {
		System.out.println("method2() 실행");
	}
	@PrintAnnotation(value = "#", number = 20)
	public void method3() {
		System.out.println("method3() 실행");
	}
}
