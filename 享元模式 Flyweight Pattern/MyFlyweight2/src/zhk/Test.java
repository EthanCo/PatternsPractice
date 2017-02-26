package zhk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

interface Menu {
	// 规定了实现类必须实现设置内外关系的方法
	public void setPersonMenu(String person, List list);
	// 规定了实现类必须实现查找外蕴状态对应的内蕴状态的方法
	public List findPersonMenu(String person, List list);
}

// 这便是具体享元角色了：
class PersonMenu implements Menu {
	private String dish;

	// 在构造方法中给内蕴状态附值
	public PersonMenu(String dish) {
		this.dish = dish;
	}

	public synchronized void setPersonMenu(String person, List list) {
		list.add(person);
		list.add(dish);
	}

	public List findPersonMenu(String person, List list) {
		List dishList = new ArrayList();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			if (person.equals((String) it.next()))
				dishList.add(it.next());
		}
		return dishList;
	}
}

// 享元工厂角色，这可是关键所在，大家注意看！
class FlyweightFactory {
	private Map menuList = new HashMap();
	private static FlyweightFactory factory = new FlyweightFactory();

	// 这里还使用了单例模式，来使工厂对象只产生一个工厂实例
	private FlyweightFactory() {
	}

	public static FlyweightFactory getInstance() {
		return factory;
	}

	// 这就是享元模式同工厂模式的不同所在！！
	public synchronized Menu factory(String dish) {
		// 判断如果内蕴状态已经存在就不再重新生成，而是使用原来的，否则就重新生成
		if (menuList.containsKey(dish)) {
			return (Menu) menuList.get(dish);
		} else {
			Menu menu = new PersonMenu(dish);
			menuList.put(dish, menu);
			return menu;
		}
	}

	// 来验证下是不是真的少产生了对象
	public int getNumber() {
		return menuList.size();
	}
}

// 我们使用客户程序来试验下吧。
class Test {
	private static FlyweightFactory factory;

	public static void main(String[] args) {
		List list1 = new ArrayList();
		factory = FlyweightFactory.getInstance();
		Menu list = factory.factory("尖椒土豆丝");
		list.setPersonMenu("ai92", list1);
		list = factory.factory("红烧肉");
		list.setPersonMenu("ai92", list1);
		list = factory.factory("地三鲜");
		list.setPersonMenu("ai92", list1);
		list = factory.factory("地三鲜");
		list.setPersonMenu("ai92", list1);
		list = factory.factory("红焖鲤鱼");
		list.setPersonMenu("ai92", list1);
		list = factory.factory("红烧肉");
		list.setPersonMenu("ai921", list1);
		list = factory.factory("红焖鲤鱼");
		list.setPersonMenu("ai921", list1);
		list = factory.factory("地三鲜");
		list.setPersonMenu("ai921", list1);
		System.out.println(factory.getNumber());

		List list2 = list.findPersonMenu("ai921", list1);
		Iterator it = list2.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
