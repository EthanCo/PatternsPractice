package zhk;

import domain.*;
/*
 * �ۺϴ���ĺô�
 * �Դ����ִ��˳���Ժ󻹿��Էŵ������ļ���
 * */
public class Test {
	public static void main(String[] args){
		System.out.println("------ �ȴ�ӡ��־��ͳ��ʱ�� ------");
		TankTimeProxy ttp = new TankTimeProxy(new Tank());
		TankLogProxy tlp = new TankLogProxy(ttp);
		tlp.move();
		
		System.out.println("------ ��ͳ��ʱ���ٴ�ӡ��־ ------");
		TankLogProxy tlp2 = new TankLogProxy(new Tank());
		TankTimeProxy ttp2 = new TankTimeProxy(tlp2);
		ttp2.move();
	}
}
