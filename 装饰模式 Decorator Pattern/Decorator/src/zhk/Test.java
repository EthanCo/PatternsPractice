package zhk;

//��װ����
interface Component{
	void Operation();
}
//����ı�װ����
class ConcreteComonent implements Component{
	@Override
	public void Operation() {
		System.out.println("ԭ���Ĵ��룬�������޸�");
	}
}

//�����װ����
class Decorator implements Component{
	
	private Component component;
	public Decorator(Component component){ //���췽��
		this.component=component;
	}
	@Override
	public void Operation() {
		component.Operation();
	}
}
//�����װ����
//��Concrete Component����Ϊ֮ǰ��֮�󣬼����Լ�����Ϊ���ԡ����ϡ����ӵ�ְ�� 
class ConcreteDecorator extends Decorator
{
	public ConcreteDecorator(Component component) {
		super(component);
	}

	public void Operation()
	{
		//addBehaviorҲ������ǰ��
		super.Operation();
		addBehavior();
	}
	
	private void addBehavior()
	{
		//�Լ��Ĵ���
		System.out.println("�Լ��Ĵ���");
	}
}

public class Test {
	public static void main(String[] args){
		Component component = new ConcreteComonent(); 
		Decorator cDecorator = new ConcreteDecorator(component);
		cDecorator.Operation();
	}
}

/*
 * ���ֻ��һ��Concrete Component���û�г����Component�ӿ�ʱ��������Decorator�̳�Concrete Component�� 
 * */
