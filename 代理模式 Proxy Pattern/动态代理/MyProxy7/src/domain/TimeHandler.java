package domain;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {
	
	@Override
	public void invoke(Object o,Method m) {
		long start = System.currentTimeMillis();
		System.out.println("starttime:" + start);
		System.out.println(o.getClass().getName());
		try {
			m.invoke(o, new Object[]{});
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end-start));
	}

}
