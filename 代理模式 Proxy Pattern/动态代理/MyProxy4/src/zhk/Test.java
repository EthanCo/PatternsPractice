package zhk;

import domain.*;
/*
 * ��װ��һ��
 * ֻҪ��ʵ����Moveable�ӿڵĶ�������,������ʵ�ִ���
 * ��̬����,����ҪTankTimeProxy������
 * ����Time��ʱ���Զ�̬���������ӿ�
 * 
 * ���⣺ʵ�ʲ����з���,�� �����ļ�Ŀ¼ �� Ҫrefresh һ����Ŀ �˳������ִ��
 * */
public class Test {
	public static void main(String[] args) throws Exception{
			Moveable m = (Moveable)Proxy.newProxyInstance();
			m.move();
	}
}
