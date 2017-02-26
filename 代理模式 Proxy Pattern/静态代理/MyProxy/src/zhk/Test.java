package zhk;

import domain.*;

public class Test {
	public static void main(String[] args){
		Tank2 t2 = new Tank2();
		t2.move();
		Tank3 t3 = new Tank3(new Tank());
		t3.move();
	}
}
