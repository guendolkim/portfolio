package com.kh.portfolio.test.annotaion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

	public static void main(String[] args) {
//		Service service = new Service();
//		service.method1();
//		service.method2();
//		service.method3();

		Class t = Service.class; // Service 클래스의 메타정보를 읽어오기 위해 class 객체를 얻어낸다.
		Method[] methods = t.getDeclaredMethods(); // Service 클래스의 메소드를 추출

		for (Method method : methods) {
			// 해당 메소드에 @PrintAnnotation 존재유무를 판단한다.
			if (method.isAnnotationPresent(PrintAnnotation.class)) {

				// 어노테이션 @PrintAnnotation이 있으면 PrintAnnotation객체에 접근
				PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
				//시작 구분선 출력
				for (int i = 0; i < printAnnotation.number(); i++) {
					System.out.print(printAnnotation.value());
				}
				System.out.println();

				// 메소드 호출
				try {
					method.invoke(new Service());
				} catch (Exception e) {
					e.printStackTrace();
				}
				//종류 구분선 출력
				for (int i = 0; i < printAnnotation.number(); i++) {
					System.out.print(printAnnotation.value());
				}
				System.out.println();
			}
		}
	}
}
