package zhk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

interface Menu {
	// �涨��ʵ�������ʵ�����������ϵ�ķ���
	public void setPersonMenu(String person, List list);
	// �涨��ʵ�������ʵ�ֲ�������״̬��Ӧ������״̬�ķ���
	public List findPersonMenu(String person, List list);
}

// ����Ǿ�����Ԫ��ɫ�ˣ�
class PersonMenu implements Menu {
	private String dish;

	// �ڹ��췽���и�����״̬��ֵ
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

// ��Ԫ������ɫ������ǹؼ����ڣ����ע�⿴��
class FlyweightFactory {
	private Map menuList = new HashMap();
	private static FlyweightFactory factory = new FlyweightFactory();

	// ���ﻹʹ���˵���ģʽ����ʹ��������ֻ����һ������ʵ��
	private FlyweightFactory() {
	}

	public static FlyweightFactory getInstance() {
		return factory;
	}

	// �������Ԫģʽͬ����ģʽ�Ĳ�ͬ���ڣ���
	public synchronized Menu factory(String dish) {
		// �ж��������״̬�Ѿ����ھͲ����������ɣ�����ʹ��ԭ���ģ��������������
		if (menuList.containsKey(dish)) {
			return (Menu) menuList.get(dish);
		} else {
			Menu menu = new PersonMenu(dish);
			menuList.put(dish, menu);
			return menu;
		}
	}

	// ����֤���ǲ�������ٲ����˶���
	public int getNumber() {
		return menuList.size();
	}
}

// ����ʹ�ÿͻ������������°ɡ�
class Test {
	private static FlyweightFactory factory;

	public static void main(String[] args) {
		List list1 = new ArrayList();
		factory = FlyweightFactory.getInstance();
		Menu list = factory.factory("�⽷����˿");
		list.setPersonMenu("ai92", list1);
		list = factory.factory("������");
		list.setPersonMenu("ai92", list1);
		list = factory.factory("������");
		list.setPersonMenu("ai92", list1);
		list = factory.factory("������");
		list.setPersonMenu("ai92", list1);
		list = factory.factory("��������");
		list.setPersonMenu("ai92", list1);
		list = factory.factory("������");
		list.setPersonMenu("ai921", list1);
		list = factory.factory("��������");
		list.setPersonMenu("ai921", list1);
		list = factory.factory("������");
		list.setPersonMenu("ai921", list1);
		System.out.println(factory.getNumber());

		List list2 = list.findPersonMenu("ai921", list1);
		Iterator it = list2.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
