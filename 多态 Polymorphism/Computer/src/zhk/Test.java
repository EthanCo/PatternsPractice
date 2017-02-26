package zhk;

//PCI �ӿ�
interface PCI{
	public void open();
	public void close();
}

//����
class Mainboard{
	public void run(){
		System.out.println("����������");
	}
	
	public void usePCI(PCI p){
		if(p!=null){ //���p����
			p.open();
			p.close();
		}
	}
}

//����
class NetCard implements PCI{

	@Override
	public void open() {
		System.out.println("����������");
	}

	@Override
	public void close() {
		System.out.println("�����ر���");
	}
}

class SoundCard implements PCI{

	@Override
	public void open() {
		System.out.println("����������");
	}

	@Override
	public void close() {
		System.out.println("�����ر���");
	}
} 

class Test{
	//�������
	public static void main(String[] args){
		Mainboard board = new Mainboard();
		board.run();
		board.usePCI(new NetCard());
		board.usePCI(new SoundCard());
	}
}

