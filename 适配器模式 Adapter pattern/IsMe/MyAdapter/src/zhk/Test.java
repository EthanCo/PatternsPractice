package zhk;

//客户端希望使用的接口，可以是具体的或抽象的类，也可以是接口
interface Target{
	public void Method1();
}

//需要适配的类
class Adaptee{
	public void MeThod2(){
		System.out.println("方法2");
	}
}

//适配器
class Adapter implements Target{
	// 建立一个私有的Adeptee对象
	private Adaptee adaptee = new Adaptee();
	@Override
	public void Method1() {
		adaptee.MeThod2();//通过重写，表面上调用Method1方法，变成了实际调用MeThod2()方法
	}
}

public class Test {
	public static void main(String[] args){
		// 对客户端来说，调用的就是Target的Method1()
		Target target = new Adapter();
		target.Method1();
	}
}
