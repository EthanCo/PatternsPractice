package domain;

/*
 * ����(�ۺ�)
 * ��̹��3���κη���,�������Tank���еķ���
 * 	�ۺϣ�
	A1���A2��ʵ��B�ӿ�
	A2����A1�Ķ���,��A2�Ľӿڷ�������õ���Զ��A1�ķ���
 * */

public class Tank3 implements Moveable{

	public Tank3(Tank t) {
		super();
		this.t = t;
	}
	
	Tank t ;

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		t.move();
		long end = System.currentTimeMillis();
		System.out.println("����ʱ�䣺"+(end-start));
	}

}
