package domain;

import java.lang.reflect.Method;

//方法调用的处理器 handler,具体处理方式由子类决定
public interface InvocationHandler {
	public void invoke(Object o,Method m); //o 指定的对象 m 传入的方法
}


