package domain;

/*
 * 代理(聚合)
 * 对坦克3的任何方法,都会调用Tank类中的方法
 * 	聚合：
	A1类和A2类实现B接口
	A2里有A1的对象,但A2的接口方法里调用的永远是A1的方法
 * */

public class Tank3 implements Moveable{

	public Tank3(Tank t) {
		super();
		this.t = t;
	}
	
	Tank t ;

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		t.move();
		long end = System.currentTimeMillis();
		System.out.println("运行时间："+(end-start));
	}

}
