package domain;

/*
 * 代理(聚合)
 * 对坦克3的任何方法,都会调用Tank类中的方法
 * 	聚合：
	A1类和A2类实现B接口
	A2里有A1的对象,但A2的接口方法里调用的永远是A1的方法
 * */

public class TankTimeProxy implements Moveable{

	public TankTimeProxy(Moveable t) {//传入的是Moveable接口
		super();
		this.t = t;
	}
	
	Moveable t ;

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("开始时间："+start);
		t.move();
		long end = System.currentTimeMillis();
		System.out.println("运行时间："+(end-start));
	}
}
