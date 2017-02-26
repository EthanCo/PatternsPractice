package zhk;

//PCI 接口
interface PCI{
	public void open();
	public void close();
}

//主板
class Mainboard{
	public void run(){
		System.out.println("主板运行了");
	}
	
	public void usePCI(PCI p){
		if(p!=null){ //如果p存在
			p.open();
			p.close();
		}
	}
}

//网卡
class NetCard implements PCI{

	@Override
	public void open() {
		System.out.println("网卡开启了");
	}

	@Override
	public void close() {
		System.out.println("网卡关闭了");
	}
}

class SoundCard implements PCI{

	@Override
	public void open() {
		System.out.println("声卡开启了");
	}

	@Override
	public void close() {
		System.out.println("声卡关闭了");
	}
} 

class Test{
	//程序入口
	public static void main(String[] args){
		Mainboard board = new Mainboard();
		board.run();
		board.usePCI(new NetCard());
		board.usePCI(new SoundCard());
	}
}

