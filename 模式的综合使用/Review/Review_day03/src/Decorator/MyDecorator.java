package Decorator;

//接口
interface IThirdParty {
	String sayMsg();
}

// 具体的被装饰类
class ThirdParty implements IThirdParty {

	@Override
	public String sayMsg() {
		return "原来的代码";
	}
}

// 具体装饰类1
class Decorator1 implements IThirdParty {

	private IThirdParty thirdParty;

	public Decorator1(IThirdParty thirdParty) {
		this.thirdParty = thirdParty;
	}

	@Override
	public String sayMsg() {
		return "--Decorator1添加的代码--" + thirdParty.sayMsg() + "--Decorator1添加的代码--";
	}
}

// 具体装饰类2
class Decorator2 implements IThirdParty {
	private IThirdParty thirdParty;

	public Decorator2(IThirdParty thirdParty) {
		this.thirdParty = thirdParty;
	}

	@Override
	public String sayMsg() {
		return "--Decorator2添加的代码--" + thirdParty.sayMsg() + "--Decorator2添加的代码--";
	}
}

public class MyDecorator {
	public static void main(String[] args) {
		IThirdParty thirdParty = new ThirdParty();
		IThirdParty decorator1 = new Decorator1(thirdParty);
		IThirdParty decorator2 = new Decorator2(decorator1);
		System.out.println(thirdParty.sayMsg());
		System.out.println(decorator1.sayMsg());
		System.out.println(decorator2.sayMsg());
	}
}