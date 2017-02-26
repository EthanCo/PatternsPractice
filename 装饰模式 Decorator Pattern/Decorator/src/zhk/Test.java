package zhk;

//被装饰类
interface Component{
	void Operation();
}
//具体的被装饰类
class ConcreteComonent implements Component{
	@Override
	public void Operation() {
		System.out.println("原来的代码，不方便修改");
	}
}

//抽象的装饰类
class Decorator implements Component{
	
	private Component component;
	public Decorator(Component component){ //构造方法
		this.component=component;
	}
	@Override
	public void Operation() {
		component.Operation();
	}
}
//具体的装饰类
//在Concrete Component的行为之前或之后，加上自己的行为，以“贴上”附加的职责。 
class ConcreteDecorator extends Decorator
{
	public ConcreteDecorator(Component component) {
		super(component);
	}

	public void Operation()
	{
		//addBehavior也可以在前面
		super.Operation();
		addBehavior();
	}
	
	private void addBehavior()
	{
		//自己的代码
		System.out.println("自己的代码");
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
 * 如果只有一个Concrete Component类而没有抽象的Component接口时，可以让Decorator继承Concrete Component。 
 * */
