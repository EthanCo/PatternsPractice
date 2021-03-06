package zhk;

import domain.*;
/*
 * 只要是实现了[任意]接口的都可以用,都可以实现代理 
 * 动态代理,不需要TankTimeProxy等类了
 * 比如Time计时可以动态代理给任意接口
 * 实现任意功能的代理,比如说Time计时或者是Log日志
 *  代理的具体内容,由别人来具体指定
 * 
 *  问题：实际测试中发现,在 设置文件目录 后 要refresh 一下项目 此程序才能执行
 * */
public class Test {
	public static void main(String[] args) throws Exception{
			//此时并不知道代理对象是谁
			InvocationHandler h = new TimeHandler();
			Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class,h);
			m.move();
	}
}
