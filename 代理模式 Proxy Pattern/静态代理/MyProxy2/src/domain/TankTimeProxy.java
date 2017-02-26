package domain;

/*
 * ����(�ۺ�)
 * ��̹��3���κη���,�������Tank���еķ���
 * 	�ۺϣ�
	A1���A2��ʵ��B�ӿ�
	A2����A1�Ķ���,��A2�Ľӿڷ�������õ���Զ��A1�ķ���
 * */

public class TankTimeProxy implements Moveable{

	public TankTimeProxy(Moveable t) {//�������Moveable�ӿ�
		super();
		this.t = t;
	}
	
	Moveable t ;

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		System.out.println("��ʼʱ�䣺"+start);
		t.move();
		long end = System.currentTimeMillis();
		System.out.println("����ʱ�䣺"+(end-start));
	}
}
