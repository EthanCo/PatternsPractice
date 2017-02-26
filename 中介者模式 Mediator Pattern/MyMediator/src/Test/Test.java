package Test;

/*
Mediator：中介者接口。在里面定义了各个同事之间相互交互所需要的方法，可以是公共的方法，如Change方法，也可以是小范围的交互方法。
ConcreteMediator：具体的中介者实现对象。它需要了解并为维护每个同事对象，并负责具体的协调各个同事对象的交互关系。
Colleague：同事类的定义，通常实现成为抽象类，主要负责约束同事对象的类型，并实现一些具体同事类之间的公共功能，
		比如，每个具体同事类都应该知道中介者对象，也就是每个同事对象都会持有中介者对象的引用，这个功能可定义在这个类中。
ConcreteColleague：具体的同事类，实现自己的业务，需要与其他同事对象交互时，就通知中介对象，中介对象会负责后续的交互。
 * */
//同事类的抽象类
abstract class Colleague{
	private Mediator mediator;
	//构造方法,传入中介者对象
	protected Colleague(Mediator mediator){
		this.mediator = mediator;
	}
	//获取当前同时类对应的中介者对象
	public Mediator getMediator(){
		return mediator;
	}
}

class ConcreteColleagueA extends Colleague{
	//调用父类的构造函数
	protected ConcreteColleagueA(Mediator mediator) {
		super(mediator);
	}
	//执行某些业务功能
	public void SomeOperationA(){
		System.out.println("ColleagueA在执行A业务");
		this.getMediator().Change(this);
	}
}
//具体同事类B
class ConcreteColleagueB extends Colleague{

	protected ConcreteColleagueB(Mediator mediator) {
		super(mediator);
	}
	//执行某些业务功能
	public void SomeOperationB(){
		System.out.println("ColleagueB在执行B业务");
		this.getMediator().Change(this);
	}
}
//具体同事类C
class ConcreteColleagueC extends Colleague{

	protected ConcreteColleagueC(Mediator mediator) {
		super(mediator);
	}
	//执行某些业务功能
	public void SomeOperationC(){
		System.out.println("ColleagueC在执行C业务");
		this.getMediator().Change(this);
	}
}
//中介者接口
interface Mediator{
	void Change(Colleague colleague);
}
//具体实现的中介者
class ConcreteMediator implements Mediator{
	//持有并维护同事A
	private ConcreteColleagueA colleagueA;
	//持有并维护同事B
	private ConcreteColleagueB colleagueB;
	//持有并维护同事C
	private ConcreteColleagueC colleagueC;
	//设置中介者血药了解并维护的同事A对象
	public void SetConcreteColleagueA(ConcreteColleagueA colleague){
		this.colleagueA=colleague;
	}
	//设置中介者血药了解并维护的同事B对象
	public void SetConcreteColleagueB(ConcreteColleagueB colleague){
		this.colleagueB=colleague;
	}
	//设置中介者血药了解并维护的同事B对象
	public void SetConcreteColleagueC(ConcreteColleagueC colleague){
		this.colleagueC=colleague;
	}
	public void Change(Colleague colleague){
		//某个同事类发生了变化,通常需要与其他同事交互
		//具体协调的同事对象来实现协助行为
		if(colleague==colleagueA){
			colleagueB.SomeOperationB(); 
		}else if(colleague==colleagueB){
			//colleagueA.SomeOperationA();不能这样,会成死锁
			colleagueC.SomeOperationC();
		}
	}
}

public class Test {
	public static void main(String[] args){
		//1.创建中介者
		ConcreteMediator mediator = new ConcreteMediator();
		//2.创建同事类
		ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
		ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);
		ConcreteColleagueC colleagueC = new ConcreteColleagueC(mediator);
		//3.让中介知道所有的同事
		mediator.SetConcreteColleagueA(colleagueA);
		mediator.SetConcreteColleagueB(colleagueB);
		mediator.SetConcreteColleagueC(colleagueC);
		//同事通过中介协助同事
		colleagueA.SomeOperationA();
	}
}
