package zhk;
//������
abstract class Interface{
	implement impl;
	public Interface(implement impl){
		this.impl=impl;
	}
	public void operation1(){
		impl.operation1();
	}
}
//ʵ����
interface implement{
	void operation1();
}
//������ļ̳���
class Interface1 extends Interface{

	public Interface1(implement impl) {
		super(impl);
	}
	@Override
	public void operation1() {
		impl.operation1();
	}
}
//���������һ���̳���
class Interface2 extends Interface{

	public Interface2(implement impl) {
		super(impl);
	}
	@Override
	public void operation1() {
		impl.operation1();
	}
}
//ʵ����ļ̳���
class implement1 implements implement{
	public void operation1(){
		
	}
}
//ʵ�������һ���̳���
class implement2 implements implement{
	public void operation1(){
		
	}
}

public class test {
	public static void main(String[] args){
		
	}
}
