package newclass;
import domain.*;
public class TankTimeProxy implements Moveable{
	public TankTimeProxy(Moveable t) {
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