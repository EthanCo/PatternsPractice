package domain;

/*
 *����(�̳�)
 * ��̹��2���κη���,������������෽���Ķ���
 * */
public class Tank2 extends Tank{
	@Override
	public void move() {
		long start = System.currentTimeMillis();
		super.move();
		long end = System.currentTimeMillis();
		System.out.println("����ʱ�䣺"+(end-start));
	}
}
