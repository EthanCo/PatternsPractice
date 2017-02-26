package zhk;

import java.lang.reflect.Method;

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
/*
 * 好处：可以对任意的对象,任意的接口方法,实现任意的代理
 * */
public class Test {
	public static void main(String[] args) throws Exception{
			Tank t = new Tank(); //被代理对象
			InvocationHandler h = new TimeHandler(t); //代理的处理逻辑
			Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class,h);//将h交给代理生成类,生成具体的代理对象
			m.move();
			/*
			 * 调move方法的时候
			 public void move() {
			    try {
				    Method md = domain.Moveable.class.getMethod("move"); //1.找到这个方法
				    h.invoke(this, md); //2.调用h.invoke,即TimeHandler.invoke
			    }catch(Exception e) {e.printStackTrace();}
			}
			 *---------------------------TimeHandler--------------------------
			@Override
			public void invoke(Object o,Method m) { o 代理对象TankTimeProxy(在此处没有,但不代表以后自己使用的时候用不到)
				long start = System.currentTimeMillis();  //3.自己加的逻辑被调用
				System.out.println("starttime:" + start);
				System.out.println(o.getClass().getName());
				try {
					m.invoke(target);  //4.调原来的target对象,即被调用对象,在此处是Tank t
				} catch (Exception e) {
					e.printStackTrace();
				}
				long end = System.currentTimeMillis();
				System.out.println("time:" + (end-start));
	}
			 * 
			 * */
	}
}
