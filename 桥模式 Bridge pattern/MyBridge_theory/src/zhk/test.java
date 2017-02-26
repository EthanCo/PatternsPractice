package zhk;
//抽象类
abstract class Interface{
	implement impl;
	public Interface(implement impl){
		this.impl=impl;
	}
	public void operation1(){
		impl.operation1();
	}
}
//实现类
interface implement{
	void operation1();
}
//抽象类的继承类
class Interface1 extends Interface{

	public Interface1(implement impl) {
		super(impl);
	}
	@Override
	public void operation1() {
		impl.operation1();
	}
}
//抽象类的另一个继承类
class Interface2 extends Interface{

	public Interface2(implement impl) {
		super(impl);
	}
	@Override
	public void operation1() {
		impl.operation1();
	}
}
//实现类的继承类
class implement1 implements implement{
	public void operation1(){
		
	}
}
//实现类的另一个继承类
class implement2 implements implement{
	public void operation1(){
		
	}
}

public class test {
	public static void main(String[] args){
		
	}
}
