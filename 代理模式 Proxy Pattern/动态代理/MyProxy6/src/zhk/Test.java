package zhk;

import domain.*;
/*
 * ֻҪ��ʵ����[����]�ӿڵĶ�������,������ʵ�ִ��� 
 * ��̬����,����ҪTankTimeProxy������
 * ����Time��ʱ���Զ�̬���������ӿ�
 * 
 *  ���⣺ʵ�ʲ����з���,�� �����ļ�Ŀ¼ �� Ҫrefresh һ����Ŀ �˳������ִ��
 * */
public class Test {
	public static void main(String[] args) throws Exception{
			Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class);
			m.move();
	}
}
