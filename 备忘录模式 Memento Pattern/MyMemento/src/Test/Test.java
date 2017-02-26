package Test;

import MementoPattern.Caretaker;
import MementoPattern.Originator;

/*
 * ����¼ģʽ
    �� Originator��ԭ������������һ����ͨ�࣬���Դ���һ������¼�����洢���ĵ�ǰ�ڲ�״̬��
    Ҳ����ʹ�ñ���¼���ָ����ڲ�״̬��һ�㽫��Ҫ�����ڲ�״̬�������Ϊԭ������
    ��Memento������¼)���洢ԭ�������ڲ�״̬������ԭ����������������Щ�ڲ�״̬������¼�����һ����Բο�ԭ��������ƣ�
    ����ʵ����Ҫȷ������¼���е����ԡ���Ҫע����ǣ�����ԭ���������븺������֮�⣬����¼������ֱ�ӹ�������ʹ�ã�
    ԭ����������ڲ�ͬ�ı��������ʵ�ֻ��ƻ�������ͬ��
    ��Caretaker�������ˣ����������ֳ�Ϊ�����ߣ������𱣴汸��¼�����ǲ��ܶԱ���¼�����ݽ��в������顣
    �ڸ��������п��Դ洢һ����������¼������ֻ����洢���󣬶������޸Ķ���Ҳ����֪�������ʵ��ϸ�ڡ�
    ��ⱸ��¼ģʽ�����ѣ����ؼ����������Ʊ���¼��͸������ࡣ�����ڱ���¼�д洢����ԭ�������м�״̬��
    �����Ҫ��ֹԭ�������������������ʱ���¼���ر��ǲ����������������޸ı���¼��
    
    ��Java�����п��Խ�ԭ������ͱ���¼�����һ�����У�������֮������Ĭ�ϵİ��ڿɼ��ԣ�
    Ҳ���Խ�����¼����Ϊԭ��������ڲ��࣬ʹ��ֻ��ԭ�����ſ��Է��ʱ���¼�е����ݣ����������޷�ʹ�ñ���¼�е����ݡ�

 * */

public class Test {
	public static void main(String[] args){
		final String sleep = "��˯";
		final String revive = "����";
		final String paly = "��Ϸ";
		
		Caretaker caretaker = new Caretaker();
		
		Originator originator = new Originator();
		originator.setState(sleep);
		System.out.println(originator.getState());
		
		caretaker.setMemento(originator.createMemento()); //����״̬
		System.out.println(originator.getState());
		originator.setState(revive);
		System.out.println(originator.getState());
		
		caretaker.setMemento(originator.createMemento()); //����״̬
		System.out.println(originator.getState());
		originator.setState(paly);
		System.out.println(originator.getState());
		
		System.out.println("********************����*********************");
		originator.restoreMemento(caretaker.getMemento());
		System.out.println(originator.getState());
	}
}
