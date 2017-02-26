package zhk;

//�ͻ���ϣ��ʹ�õĽӿڣ������Ǿ���Ļ������࣬Ҳ�����ǽӿ�
interface Target{
	public void Method1();
}

//��Ҫ�������
class Adaptee{
	public void MeThod2(){
		System.out.println("����2");
	}
}

//������
class Adapter implements Target{
	// ����һ��˽�е�Adeptee����
	private Adaptee adaptee = new Adaptee();
	@Override
	public void Method1() {
		adaptee.MeThod2();//ͨ����д�������ϵ���Method1�����������ʵ�ʵ���MeThod2()����
	}
}

public class Test {
	public static void main(String[] args){
		// �Կͻ�����˵�����õľ���Target��Method1()
		Target target = new Adapter();
		target.Method1();
	}
}
