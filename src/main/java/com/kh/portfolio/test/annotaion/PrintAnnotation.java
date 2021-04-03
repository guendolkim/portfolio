package com.kh.portfolio.test.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//메서드에서만 적용가능.
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) //운영하는 동안만 작동됨-수명
public @interface PrintAnnotation {
	String value() default "-";  //디폴트 엘리먼트
	int number() default 15;
}
