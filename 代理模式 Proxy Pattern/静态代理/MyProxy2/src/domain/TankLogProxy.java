package domain;

/*
 * ����(�ۺ�)
 * ��̹��3���κη���,�������Tank���еķ���
 * 	�ۺϣ�
	A1���A2��ʵ��B�ӿ�
	A2����A1�Ķ���,��A2�Ľӿڷ�������õ���Զ��A1�ķ���
 * */

public class TankLogProxy implements Moveable{

	public TankLogProxy(Moveable t) { //�������Moveable�ӿ�
		super();
		this.t = t;
	}
	
	Moveable t ;

	@Override
	public void move() {
		System.out.println("��ӡ��־-start");
		t.move();
		System.out.println("��ӡ��־-end");
	}

}
