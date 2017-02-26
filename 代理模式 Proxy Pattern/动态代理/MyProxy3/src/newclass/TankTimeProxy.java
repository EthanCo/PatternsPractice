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
		System.out.println("��ʼʱ�䣺"+start);
		t.move();
		long end = System.currentTimeMillis();
		System.out.println("����ʱ�䣺"+(end-start));
	}
}