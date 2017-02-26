package Decorator;

//�ӿ�
interface IThirdParty {
	String sayMsg();
}

// ����ı�װ����
class ThirdParty implements IThirdParty {

	@Override
	public String sayMsg() {
		return "ԭ���Ĵ���";
	}
}

// ����װ����1
class Decorator1 implements IThirdParty {

	private IThirdParty thirdParty;

	public Decorator1(IThirdParty thirdParty) {
		this.thirdParty = thirdParty;
	}

	@Override
	public String sayMsg() {
		return "--Decorator1��ӵĴ���--" + thirdParty.sayMsg() + "--Decorator1��ӵĴ���--";
	}
}

// ����װ����2
class Decorator2 implements IThirdParty {
	private IThirdParty thirdParty;

	public Decorator2(IThirdParty thirdParty) {
		this.thirdParty = thirdParty;
	}

	@Override
	public String sayMsg() {
		return "--Decorator2��ӵĴ���--" + thirdParty.sayMsg() + "--Decorator2��ӵĴ���--";
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