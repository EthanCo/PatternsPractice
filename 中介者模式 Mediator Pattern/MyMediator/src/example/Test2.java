package example;

/*
 * �������У�������ȱ����һ�����壬�ǻ���ô������������������ҵĻ����Ҿͻ�����������˵������Կ϶������ˡ�����Ȼ�ⲻ���ص㡣��������������Ի������õĻ������룬�����CPU���Կ���������������Ӳ�̵ȵȣ����Ǿ�Ҫ�����Լ����߰�����������������;���ͷ�ۣ���ô��������������ڵ����������ʲô��ɫ�أ�

 ������Ŀ��������У��Ʊػ���������һ�����������������ϵͳ�໥���������ҽ����ܷ���������ÿ���඼����֪������Ҫ�������࣬�������ǵ���ϻ��Ե��쳣������ǣһ������ȫ���ֲ�ľ�а���(����Υ�������)

 ���ˣ���Ȼ����������ˣ��������������ڵ����ǡ����н���ģʽ�����ɣ�



 ����������£�

 1.���ȹ�����ȡ�����ϵ����ݣ�Ȼ��������壬����״̬�Ѿ��ı��ˡ�

 2.����õ����������ݣ������ݽ���CPU���з�������

 3.CPU�����꣬�����ݷֳ�����Ƶ���ݺ���Ƶ���ݣ�֪ͨ���壬�ѽ�������ˡ�

 4.����õ����ݣ������ݽ����Կ����������������



 ���ü��仰˵����Щ���룬colleague��һ�������࣬�ǹ�����cpu�ȵĸ��࣬�ж��н���mediator�����ã�

 Ȼ��mediator��һ���ӿڣ�ConcreteMediatorʵ��������change�������жԹ�����cpu�ȵ����ã�ÿ��������cpu���Լ��������ʱ���ȥ�����н��ߵ�change������

 Ȼ���н��ߵ�change��ȥ��һЩ����ǲ���Ĺ����������Կ��������������û����ܿ��������ˣ���������̣�������cpu�ȵĲ������Ǹ��뿪�ģ�û�����ڲ��໥���ã�

 �����Ƿ����н����������õģ�ʵ����ģ���ĵ���ϣ�

 * */

//�����н���
interface Mediator {
	void change(Colleague colleague);
}
//����ͬ����
abstract class Colleague {
	private Mediator mediator;

	Colleague(Mediator mediator) {
		this.mediator = mediator;
	}

	Mediator getMediator() {
		return mediator;
	}
}

class CPU extends Colleague {

	CPU(Mediator mediator) {
		super(mediator);
	}
	
	private String video;
	private String sound;
	
	public String getVideoCard(){
		return video;
	}
	
	public String getSoundCard(){
		return sound;
	}

	public void excuteData(String data) {
		String[] ss = data.split(",");
		this.video=ss[0];
		this.sound=ss[1];
		
		//֪ͨ����,CPU���������
		this.getMediator().change(this);
	}
}


class CDDriver extends Colleague {

	CDDriver(Mediator mediator) {
		super(mediator);
	}
	private String data;
	public String getData(){
		return data;
	}

	public void readCD(String data) {
		this.data=data;
		
		//֪ͨ����,CDDriver���������
		this.getMediator().change(this);
	}
}

class VideoCard extends Colleague {

	VideoCard(Mediator mediator) {
		super(mediator);
	}
	
	public void ShowVideo(String video) {
		System.out.println("��ʾ��Ƶ"+video);
		
		//֪ͨ����,VideoCard���������
		this.getMediator().change(this);
	}
}

class SoundCard extends Colleague {

	SoundCard(Mediator mediator) {
		super(mediator);
	}
	
	public void ShowSound(String sound){
		System.out.println("������Ƶ����"+sound);
		
		//֪ͨ����,SoundCard���������
		this.getMediator().change(this);
	}
}
//����Mediatorʵ����
class MainboardMediator implements Mediator {

	private CDDriver cdDriver;
	private CPU cpu;
	private VideoCard videoCard;
	private SoundCard soundCard;
	
	public void setCdDriver(CDDriver cdDriver) {
		this.cdDriver = cdDriver;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public void setVideoCard(VideoCard videoCard) {
		this.videoCard = videoCard;
	}

	public void setSoundCard(SoundCard soundCard) {
		this.soundCard = soundCard;
	}
	
	@Override
	public void change(Colleague colleague) {
		if(colleague == cdDriver){
			openCDAndReadData((CDDriver)colleague);
		}else if(colleague == cpu){
			openCPU((CPU)colleague);
		}
	}
	
	private void openCDAndReadData(CDDriver cs){
		//��ȡ������ȡ������
		String data = cs.getData();
		//����Щ���ݴ����CPU���д���
		this.cpu.excuteData(data);
	}
	
	private void openCPU(CPU cpu){
		//��ȡ����
		String video = cpu.getVideoCard();
		String sound = cpu.getSoundCard();
		//cpu֪ͨ�����Կ�����,�û��Ϳ��Կ���Ӱ����
		this.videoCard.ShowVideo(video);
		this.soundCard.ShowSound(sound);
	}
}

public class Test2 {
	public static void main(String[] agrs) {
		//1.�����н���
		MainboardMediator mainboard = new MainboardMediator();
		//2.����ͬ����
		CDDriver cdDriver = new CDDriver(mainboard);
		SoundCard soundCard = new SoundCard(mainboard);
		VideoCard videoCard = new VideoCard(mainboard);
		CPU cpu = new CPU(mainboard);
		//3.���н�֪�����е�ͬ��
		mainboard.setCdDriver(cdDriver);
		mainboard.setCpu(cpu);
		mainboard.setSoundCard(soundCard);
		mainboard.setVideoCard(videoCard);
		//cdDriver��ʼ��ȡ����
		cdDriver.readCD(" #####��Ƶ#####, ++++����++++");
	}
}
