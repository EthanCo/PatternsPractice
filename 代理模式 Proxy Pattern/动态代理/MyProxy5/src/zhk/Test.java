package zhk;

import domain.*;
/*
 * 只要是实现了[任意]接口的都可以用,都可以实现代理 ,此时还只能使用Moveable,还需要使用泛型
 * 动态代理,不需要TankTimeProxy等类了
 * 比如Time计时可以动态代理给任意接口
 * 
 *  问题：实际测试中发现,在 设置文件目录 后 要refresh 一下项目 此程序才能执行
 * */
public class Test {
	public static void main(String[] args) throws Exception{
			Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class);
			m.move();
	}
}
