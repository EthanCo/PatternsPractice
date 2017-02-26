package Test;

import Visitor.ComputerMemeber;
import Visitor.Memebers;
import domain.EightAbateMemeber;
import domain.NineAbateMemeber;
import domain.NoAbateMemeber;
import domain.SevenAbateMemeber;
/*
 * 访问者模式的优点
　　●　　好的扩展性
　　能够在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能。
　　●　　好的复用性
　　可以通过访问者来定义整个对象结构通用的功能，从而提高复用程度。
　　●　　分离无关行为
　　可以通过访问者来分离无关的行为，把相关的行为封装在一起，构成一个访问者，这样每一个访问者的功能都比较单一。
访问者模式的缺点
　　●　　对象结构变化很困难
　　不适用于对象结构中的类经常变化的情况，因为对象结构发生了改变，访问者的接口和访问者的实现都要发生相应的改变，代价太高。
　　●　　破坏封装
　　访问者模式通常需要对象结构开放内部数据给访问者和ObjectStructrue，这破坏了对象的封装性。
访问者模式的适用场景
       假如一个对象中存在着一些与本对象不相干（或者关系较弱）的操作，为了避免这些操作污染这个对象，则可以使用访问者模式来把这些操作封装到访问者中去。
       假如一组对象中，存在着相似的操作，为了避免出现大量重复的代码，也可以将这些重复的操作封装到访问者中去。
       但是，访问者模式并不是那么完美，它也有着致命的缺陷：增加新的元素类比较困难。通过访问者模式的代码可以看到，在访问者类中，每一个元素类都有它对应的处理方法，也就是说，每增加一个元素类都需要修改访问者类（也包括访问者类的子类或者实现类），修改起来相当麻烦。也就是说，在元素类数目不确定的情况下，应该慎用访问者模式。所以，访问者模式比较适用于对已有功能的重构，比如说，一个项目的基本功能已经确定下来，元素类的数据已经基本确定下来不会变了，会变的只是这些元素内的相关操作，这时候，我们可以使用访问者模式对原有的代码进行重构一遍，这样一来，就可以在不修改各个元素类的情况下，对原有功能进行修改。
 * */
public class Test {
	public static void main(String[] args){
		NoAbateMemeber noAbateMemeber = new NoAbateMemeber();
		NineAbateMemeber nineAbateMemeber = new NineAbateMemeber();
		EightAbateMemeber eightAbateMemeber = new EightAbateMemeber();
		SevenAbateMemeber sevenAbateMemeber = new SevenAbateMemeber();
		
		noAbateMemeber.setCount(10);
		noAbateMemeber.setPrivce(10);
		nineAbateMemeber.setCount(10);
		nineAbateMemeber.setPrivce(10);
		eightAbateMemeber.setCount(10);
		eightAbateMemeber.setPrivce(10);
		sevenAbateMemeber.setPrivce(10);
		sevenAbateMemeber.setCount(10);
		
		Memebers memebers = new Memebers();
		memebers.add(noAbateMemeber);
		memebers.add(nineAbateMemeber);
		memebers.add(eightAbateMemeber);
		memebers.add(sevenAbateMemeber);
		
		ComputerMemeber computerMemeber = new ComputerMemeber();
		computerMemeber.account(memebers.getList());
	}
}
