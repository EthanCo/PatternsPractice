package zhk;

/*
 * ThirdParty假定是一个现有的或者第三方的功能，因某种原因我们不能直接修改，
 * 它提供了一个sayMsg()的方法，而我们现在要做的是想在它的sayMsg()方法中增加
 * 一些我们想额外输出的内容，于是我们重写了一个Decorator类。Test是客户端测试程序。
 * */

// IthirdParty.Java--抽象被装饰接口
interface IThirdParty {
	public String sayMsg();
}

// 具体的被装饰类
class ThirdParty implements IThirdParty {
	@Override
	public String sayMsg() {
		return "原来的代码";
	}
}

// Decorator1 具体装饰类1
class Decorator1 implements IThirdParty {
	private IThirdParty thirdParty;
	public Decorator1(IThirdParty thirdParty) {
		this.thirdParty = thirdParty;
	}

	@Override
	public String sayMsg() {
		return "--自己添加的代码--" + thirdParty.sayMsg() + "--自己添加的代码--";
	}
}

// Decorator2 具体装饰类2
class Decorator2 implements IThirdParty {
	private IThirdParty thirdParty;

	public Decorator2(IThirdParty thirdParty) {
		this.thirdParty = thirdParty;
	}

	public String sayMsg() {
		return "--后来又添加的代码--" + thirdParty.sayMsg() + "--后来又添加的代码--";
	}
}

public class Test {
	public static void main(String[] args) {
		IThirdParty thirdPartyOne = new ThirdParty();
		IThirdParty decorator1 = new Decorator1(thirdPartyOne);
		IThirdParty decorator2 = new Decorator2(decorator1);
		System.out.println(thirdPartyOne.sayMsg());
		System.out.println(decorator1.sayMsg());
		System.out.println(decorator2.sayMsg());
	}
}
