package Adapter;
//�ͻ���ϣ��ʹ�õĽӿ�,�����Ǿ����������,Ҳ�����ǽӿ�
interface Target{
	public void Method1();
}
//��Ҫ�������
class Adaptee{
	public void Method2(){
		System.out.println("������");
	}
}
//������
class Adapter implements Target{
	private Adaptee adaptee = new Adaptee();

	@Override
	public void Method1() {
		adaptee.Method2();//�������Method1����,ʵ���ϵ���Method2()����
	}
}

public class MyAdapter {
	public static void main(String[] args){
		Target target = new Adapter();
		target.Method1();
	}
}
