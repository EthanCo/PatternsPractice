package domain;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	//被代理对象
	private Object target;

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}
	
	@Override
	public void invoke(Object o,Method m) {//o 代理对象TankTimeProxy(在此处没有,但不代表以后自己使用的时候用不到)
		long start = System.currentTimeMillis();
		System.out.println("starttime:" + start);
		System.out.println(o.getClass().getName());
		try {
			m.invoke(target); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end-start));
	}

}
