package Test;

/*
Mediator���н��߽ӿڡ������涨���˸���ͬ��֮���໥��������Ҫ�ķ����������ǹ����ķ�������Change������Ҳ������С��Χ�Ľ���������
ConcreteMediator��������н���ʵ�ֶ�������Ҫ�˽ⲢΪά��ÿ��ͬ�¶��󣬲���������Э������ͬ�¶���Ľ�����ϵ��
Colleague��ͬ����Ķ��壬ͨ��ʵ�ֳ�Ϊ�����࣬��Ҫ����Լ��ͬ�¶�������ͣ���ʵ��һЩ����ͬ����֮��Ĺ������ܣ�
		���磬ÿ������ͬ���඼Ӧ��֪���н��߶���Ҳ����ÿ��ͬ�¶��󶼻�����н��߶�������ã�������ܿɶ�����������С�
ConcreteColleague�������ͬ���࣬ʵ���Լ���ҵ����Ҫ������ͬ�¶��󽻻�ʱ����֪ͨ�н�����н����Ḻ������Ľ�����
 * */
//ͬ����ĳ�����
abstract class Colleague{
	private Mediator mediator;
	//���췽��,�����н��߶���
	protected Colleague(Mediator mediator){
		this.mediator = mediator;
	}
	//��ȡ��ǰͬʱ���Ӧ���н��߶���
	public Mediator getMediator(){
		return mediator;
	}
}

class ConcreteColleagueA extends Colleague{
	//���ø���Ĺ��캯��
	protected ConcreteColleagueA(Mediator mediator) {
		super(mediator);
	}
	//ִ��ĳЩҵ����
	public void SomeOperationA(){
		System.out.println("ColleagueA��ִ��Aҵ��");
		this.getMediator().Change(this);
	}
}
//����ͬ����B
class ConcreteColleagueB extends Colleague{

	protected ConcreteColleagueB(Mediator mediator) {
		super(mediator);
	}
	//ִ��ĳЩҵ����
	public void SomeOperationB(){
		System.out.println("ColleagueB��ִ��Bҵ��");
		this.getMediator().Change(this);
	}
}
//����ͬ����C
class ConcreteColleagueC extends Colleague{

	protected ConcreteColleagueC(Mediator mediator) {
		super(mediator);
	}
	//ִ��ĳЩҵ����
	public void SomeOperationC(){
		System.out.println("ColleagueC��ִ��Cҵ��");
		this.getMediator().Change(this);
	}
}
//�н��߽ӿ�
interface Mediator{
	void Change(Colleague colleague);
}
//����ʵ�ֵ��н���
class ConcreteMediator implements Mediator{
	//���в�ά��ͬ��A
	private ConcreteColleagueA colleagueA;
	//���в�ά��ͬ��B
	private ConcreteColleagueB colleagueB;
	//���в�ά��ͬ��C
	private ConcreteColleagueC colleagueC;
	//�����н���Ѫҩ�˽Ⲣά����ͬ��A����
	public void SetConcreteColleagueA(ConcreteColleagueA colleague){
		this.colleagueA=colleague;
	}
	//�����н���Ѫҩ�˽Ⲣά����ͬ��B����
	public void SetConcreteColleagueB(ConcreteColleagueB colleague){
		this.colleagueB=colleague;
	}
	//�����н���Ѫҩ�˽Ⲣά����ͬ��B����
	public void SetConcreteColleagueC(ConcreteColleagueC colleague){
		this.colleagueC=colleague;
	}
	public void Change(Colleague colleague){
		//ĳ��ͬ���෢���˱仯,ͨ����Ҫ������ͬ�½���
		//����Э����ͬ�¶�����ʵ��Э����Ϊ
		if(colleague==colleagueA){
			colleagueB.SomeOperationB(); 
		}else if(colleague==colleagueB){
			//colleagueA.SomeOperationA();��������,�������
			colleagueC.SomeOperationC();
		}
	}
}

public class Test {
	public static void main(String[] args){
		//1.�����н���
		ConcreteMediator mediator = new ConcreteMediator();
		//2.����ͬ����
		ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
		ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);
		ConcreteColleagueC colleagueC = new ConcreteColleagueC(mediator);
		//3.���н�֪�����е�ͬ��
		mediator.SetConcreteColleagueA(colleagueA);
		mediator.SetConcreteColleagueB(colleagueB);
		mediator.SetConcreteColleagueC(colleagueC);
		//ͬ��ͨ���н�Э��ͬ��
		colleagueA.SomeOperationA();
	}
}
