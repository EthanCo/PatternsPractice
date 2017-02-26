package zhk;

/*
我们公司是个相对很宽松的公司。
在公司里，如果你的请假时间小于0.5天，那么只需要向项目经理打声招呼就OK了。
如果超过了0.5天，但是还小于2天，那么就要去找人事部处理，当然，这就要扣工资了。
如果超过了2天，你就需要去找总经理了，工资当然也玩完了。
那么，对于我们来说，这个流程就是这样的。
也就是这样一个过程，你需要和你的直接上级——项目经理去打交道，最终可能是项目经理给你回邮件，
可能是人事部给你回邮件，也可能是总经理给你回邮件。内部的过程其实应该是个黑盒子，
你并不知道内部的消息是如何处理的。你需要找到的，只是你想要第一个交付的对象而已。
 * */

/*
 * 由法律想到——职责链的兜底条款
仔细想想法律条文，尤其是刑法，经常可以看到这样的条文：
1. 如果*********，则处以拘役处分。
2. 如果*********，则处以有期徒刑一年到十年。
3. 如果*********，则处以有期徒刑十年以上。
4. 如果*********，则**********。
5. 如果以上条件皆不满足，则*****************。

其实最后一条就叫做法律的兜底条款。这给了法官很大的自由裁量权，在一定程度上也降低了犯罪分子钻法律空子的可能性。
在我们的职责链中，如果不存在这样的兜底条款，那么用户如果不从首节点开始访问，那么就很可能出现异常的情况。
于是我们应该为职责链设置一个默认的条款：
这样的话，任何一个处理无论如何访问，都能得到一个正常的处理。
 * */

/*
 * 深析职责链的使用
职责链模式不能乱用，否则非常容易变成因为模式而模式的反例。
下面是我归纳出来的一些关于职责链方面的使用规则，只是个人的意见，还希望大家指教。
1， 如果存在N对N，或者是一般的常规线性关系，那么我们完全可以用表驱动来取代职责链。
2， 对象本身要经过什么处理是通过每个链上元素通过运行态来决定的，决定的因素是取决于对象的属性或者一些其他方面的策略。
3， 用户无论是从哪一个节点作为他的请求头节点，最终用户都可以得到一个请求的反馈。
4， 应怪怪建议，补充同级的处理！职责链并非是严格的上下级的传递，其中也包括同级的传递，职责链一样可以在同级之间做传递。
 * */

//请求类
class Request {
	private int day;
	private String reson;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getReson() {
		return reson;
	}

	public void setReson(String reson) {
		this.reson = reson;
	}

	public Request(int day, String reson) {
		super();
		this.day = day;
		this.reson = reson;
	}
}

/*
 * 接下来看下请求相应者，他们有两个核心方法， 一个是相应操作，一个是选择继任者。
 */

abstract class Boss {
	protected String name;// 姓名
	protected Boss successor;// 继任者

	public Boss(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boss getSuccessor() {
		return successor;
	}

	public void setSuccessor(Boss successor) {
		this.successor = successor;
	}

	public abstract boolean PassRequest(Request request);
}

// 前台
class PM extends Boss {
	
	public PM(String name) {
		super(name);
	}

	@Override
	public boolean PassRequest(Request request) {
		if (request.getDay() <= 0.5) {
			return true;
		}
		return successor.PassRequest(request);
	}
}

// HR
class HR extends Boss {
	
	public HR(String name) {
		super(name);
	}

	@Override
	public boolean PassRequest(Request request) {
		if (request.getDay() > 0.5 && request.getDay() <= 2) {
			return true;
		}
		return successor.PassRequest(request);
	}
}

// Manager
class Manager extends Boss {
	
	public Manager(String name) {
		super(name);
	}

	@Override
	public boolean PassRequest(Request request) {
		int day = request.getDay();
		String reason = request.getReson();
		if(reason.equals("正当理由")){
			return true;
		}
		return false;
	}
}

public class Test {
	public static void main(String[] args) {
		//那么我们调用的时候就很简单了！
		Request request = new Request(3, "不正当理由");
		Boss pm = new PM("pm");
		Boss hr = new HR("hr");
		Boss manager = new Manager("manager");
		pm.successor=hr;
		hr.successor=manager;
		boolean pass = pm.PassRequest(request);
		System.out.println(pass);
	}
}
