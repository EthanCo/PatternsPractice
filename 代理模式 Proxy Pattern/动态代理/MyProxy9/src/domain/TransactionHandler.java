package domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class TransactionHandler implements InvocationHandler{

	private Object target;
	
	public TransactionHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		System.out.println("���׿�ʼ");
		try {
			m.invoke(target);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�������");
	}

}
