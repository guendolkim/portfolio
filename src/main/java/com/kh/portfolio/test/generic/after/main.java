package com.kh.portfolio.test.generic.after;

public class main {

	public static void main(String[] args) {
	
		Box<Fruit> box = new Box<Fruit>();
		box.setElement(new Fruit("바나나"));
		System.out.println(box.getElement().getFruit());
		
		//뒤에 제네릭은 생략이 가능하다.
		Box<Toy> box2 = new Box<>();
		box2.setElement(new Toy("로봇"));
		System.out.println(box2.getElement().getName());
	}//main

}
