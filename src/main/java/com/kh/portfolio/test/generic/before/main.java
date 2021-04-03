package com.kh.portfolio.test.generic.before;

public class main {

	public static void main(String[] args) {
		Box box = new Box();
		Toy toy = new Toy("인형");

		box.setElement(toy);
		// 박스에서 toy를 꺼냈는데 object로 형변환 되니깐
		Object object = box.getElement();
		// 다시 toy를 형변환을 시켜준다.
		Toy toy2 = (Toy) object;
		System.out.println(toy2.getName());

		Box box2 = new Box();
		Fruit fru = new Fruit("바나나");
		
		box2.setElement(fru);
		//System.out.println(((Fruit)box2.getElement()).getFruit());
		String result = ((Fruit) box2.getElement()).getFruit();
		System.out.println(result);

	}

}
