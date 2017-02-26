package Test;

import MementoPattern.Caretaker;
import MementoPattern.Originator;

/*
 * 备忘录模式
    ● Originator（原发器）：它是一个普通类，可以创建一个备忘录，并存储它的当前内部状态，
    也可以使用备忘录来恢复其内部状态，一般将需要保存内部状态的类设计为原发器。
    ●Memento（备忘录)：存储原发器的内部状态，根据原发器来决定保存哪些内部状态。备忘录的设计一般可以参考原发器的设计，
    根据实际需要确定备忘录类中的属性。需要注意的是，除了原发器本身与负责人类之外，备忘录对象不能直接供其他类使用，
    原发器的设计在不同的编程语言中实现机制会有所不同。
    ●Caretaker（负责人）：负责人又称为管理者，它负责保存备忘录，但是不能对备忘录的内容进行操作或检查。
    在负责人类中可以存储一个或多个备忘录对象，它只负责存储对象，而不能修改对象，也无须知道对象的实现细节。
    理解备忘录模式并不难，但关键在于如何设计备忘录类和负责人类。由于在备忘录中存储的是原发器的中间状态，
    因此需要防止原发器以外的其他对象访问备忘录，特别是不允许其他对象来修改备忘录。
    
    在Java语言中可以将原发器类和备忘录类放在一个包中，让它们之间满足默认的包内可见性，
    也可以将备忘录类作为原发器类的内部类，使得只有原发器才可以访问备忘录中的数据，其他对象都无法使用备忘录中的数据。

 * */

public class Test {
	public static void main(String[] args){
		final String sleep = "沉睡";
		final String revive = "苏醒";
		final String paly = "游戏";
		
		Caretaker caretaker = new Caretaker();
		
		Originator originator = new Originator();
		originator.setState(sleep);
		System.out.println(originator.getState());
		
		caretaker.setMemento(originator.createMemento()); //保存状态
		System.out.println(originator.getState());
		originator.setState(revive);
		System.out.println(originator.getState());
		
		caretaker.setMemento(originator.createMemento()); //保存状态
		System.out.println(originator.getState());
		originator.setState(paly);
		System.out.println(originator.getState());
		
		System.out.println("********************回溯*********************");
		originator.restoreMemento(caretaker.getMemento());
		System.out.println(originator.getState());
	}
}
