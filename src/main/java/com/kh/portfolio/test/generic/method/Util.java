package com.kh.portfolio.test.generic.method;

public class Util {
	//        제네릭선언  반환타입
	public static <T> Box<T> boxing(T t){
		Box<T> box = new Box<>();
		box.setElement(t);
		
		return box;
	}
}
