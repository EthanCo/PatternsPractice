package zhk;

import domain.*;
/*
 * ֻҪ��ʵ����[����]�ӿڵĶ�������,������ʵ�ִ��� 
 * ��̬����,����ҪTankTimeProxy������
 * ����Time��ʱ���Զ�̬���������ӿ�
 * ʵ�����⹦�ܵĴ���,����˵Time��ʱ������Log��־
 *  ����ľ�������,�ɱ���������ָ��
 * 
 *  ���⣺ʵ�ʲ����з���,�� �����ļ�Ŀ¼ �� Ҫrefresh һ����Ŀ �˳������ִ��
 * */
public class Test {
	public static void main(String[] args) throws Exception{
			//��ʱ����֪�����������˭
			InvocationHandler h = new TimeHandler();
			Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class,h);
			m.move();
	}
}
