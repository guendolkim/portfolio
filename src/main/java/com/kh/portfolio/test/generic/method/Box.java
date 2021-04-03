package com.kh.portfolio.test.generic.method;

//코드를 사용할 때 타입을 정해라. <T> 정의한 타입으로 바뀜.
public class Box<T> { // 아무 값이나 저장할 수 있는 박스
	private T element;

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

}
