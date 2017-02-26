package zhk;

import java.lang.reflect.Method;

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
/*
 * �ô������Զ�����Ķ���,����Ľӿڷ���,ʵ������Ĵ���
 * */
public class Test {
	public static void main(String[] args) throws Exception{
			Tank t = new Tank(); //���������
			InvocationHandler h = new TimeHandler(t); //����Ĵ����߼�
			Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class,h);//��h��������������,���ɾ���Ĵ������
			m.move();
			/*
			 * ��move������ʱ��
			 public void move() {
			    try {
				    Method md = domain.Moveable.class.getMethod("move"); //1.�ҵ��������
				    h.invoke(this, md); //2.����h.invoke,��TimeHandler.invoke
			    }catch(Exception e) {e.printStackTrace();}
			}
			 *---------------------------TimeHandler--------------------------
			@Override
			public void invoke(Object o,Method m) { o �������TankTimeProxy(�ڴ˴�û��,���������Ժ��Լ�ʹ�õ�ʱ���ò���)
				long start = System.currentTimeMillis();  //3.�Լ��ӵ��߼�������
				System.out.println("starttime:" + start);
				System.out.println(o.getClass().getName());
				try {
					m.invoke(target);  //4.��ԭ����target����,�������ö���,�ڴ˴���Tank t
				} catch (Exception e) {
					e.printStackTrace();
				}
				long end = System.currentTimeMillis();
				System.out.println("time:" + (end-start));
	}
			 * 
			 * */
	}
}
