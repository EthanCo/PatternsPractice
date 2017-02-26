package Adapter;
//客户端希望使用的接口,可以是具体或抽象的类,也可以是接口
interface Target{
	public void Method1();
}
//需要适配的类
class Adaptee{
	public void Method2(){
		System.out.println("方法二");
	}
}
//适配器
class Adapter implements Target{
	private Adaptee adaptee = new Adaptee();

	@Override
	public void Method1() {
		adaptee.Method2();//表面调用Method1方法,实际上调用Method2()方法
	}
}

public class MyAdapter {
	public static void main(String[] args){
		Target target = new Adapter();
		target.Method1();
	}
}
