package domain;

/*
 * 代理(聚合)
 * 对坦克3的任何方法,都会调用Tank类中的方法
 * 	聚合：
	A1类和A2类实现B接口
	A2里有A1的对象,但A2的接口方法里调用的永远是A1的方法
 * */

public class TankLogProxy implements Moveable{

	public TankLogProxy(Moveable t) { //传入的是Moveable接口
		super();
		this.t = t;
	}
	
	Moveable t ;

	@Override
	public void move() {
		System.out.println("打印日志-start");
		t.move();
		System.out.println("打印日志-end");
	}

}
