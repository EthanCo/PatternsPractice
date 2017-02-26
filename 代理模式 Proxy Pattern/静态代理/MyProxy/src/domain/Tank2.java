package domain;

/*
 *代理(继承)
 * 对坦克2的任何方法,都会调用他父类方法的对象
 * */
public class Tank2 extends Tank{
	@Override
	public void move() {
		long start = System.currentTimeMillis();
		super.move();
		long end = System.currentTimeMillis();
		System.out.println("运行时间："+(end-start));
	}
}
