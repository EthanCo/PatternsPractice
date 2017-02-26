package zhk;

/*
 * ThirdParty�ٶ���һ�����еĻ��ߵ������Ĺ��ܣ���ĳ��ԭ�����ǲ���ֱ���޸ģ�
 * ���ṩ��һ��sayMsg()�ķ���������������Ҫ��������������sayMsg()����������
 * һЩ�����������������ݣ�����������д��һ��Decorator�ࡣTest�ǿͻ��˲��Գ���
 * */

// IthirdParty.Java--����װ�νӿ�
interface IThirdParty {
	public String sayMsg();
}

// ����ı�װ����
class ThirdParty implements IThirdParty {
	@Override
	public String sayMsg() {
		return "ԭ���Ĵ���";
	}
}

// Decorator1 ����װ����1
class Decorator1 implements IThirdParty {
	private IThirdParty thirdParty;
	public Decorator1(IThirdParty thirdParty) {
		this.thirdParty = thirdParty;
	}

	@Override
	public String sayMsg() {
		return "--�Լ���ӵĴ���--" + thirdParty.sayMsg() + "--�Լ���ӵĴ���--";
	}
}

// Decorator2 ����װ����2
class Decorator2 implements IThirdParty {
	private IThirdParty thirdParty;

	public Decorator2(IThirdParty thirdParty) {
		this.thirdParty = thirdParty;
	}

	public String sayMsg() {
		return "--��������ӵĴ���--" + thirdParty.sayMsg() + "--��������ӵĴ���--";
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
