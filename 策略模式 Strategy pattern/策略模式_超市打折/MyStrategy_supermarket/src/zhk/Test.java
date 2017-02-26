package zhk;

import discount.NationalDayDiscount;
import discount.NewYearsDayDiscount;
import drink.kola;
import drink.sprite;

public class Test {
	public static void main(String[] args){
		System.out.println("超市元旦折扣开始!");
		kola k = new kola(3.5,new NewYearsDayDiscount());
		sprite s = new sprite(3, new NewYearsDayDiscount());
		System.out.println(k);
		System.out.println(s);
		
		System.out.println("超市国庆折扣开始!");
		kola k2 = new kola(3.5,new NationalDayDiscount());
		sprite s2 = new sprite(3, new NationalDayDiscount());
		System.out.println(k2);
		System.out.println(s2);
	}
}
