package domain;

import java.lang.reflect.Method;

//�������õĴ����� handler,���崦��ʽ���������
public interface InvocationHandler {
	public void invoke(Object o,Method m); //o ���ĸ��������m���� m ����ķ���
}


