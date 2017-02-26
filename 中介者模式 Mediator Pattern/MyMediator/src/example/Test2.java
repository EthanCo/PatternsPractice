package example;

/*
 * 在生活中，当电脑缺少了一块主板，那会怎么样？如果有人这样问我的话，我就会马上跳出来说“这电脑肯定报废了”，当然这不是重点。假如少了主板电脑还可以用的话，想想，里面的CPU、显卡、声卡、光驱、硬盘等等，不是就要我们自己用线把它们连起来。想想就觉得头疼，那么现在你觉得主板在电脑里扮演着什么角色呢？

 在软件的开发过程中，势必会碰到这样一种情况，多个类或多个子系统相互交互，而且交互很繁琐，导致每个类都必须知道他需要交互的类，这样它们的耦合会显得异常厉害。牵一发而动全身又不木有啊！(严重违反低耦合)

 好了，既然问题提出来了，那有请我们这期的主角——中介者模式出场吧！



 具体过程如下：

 1.首先光驱读取光盘上的数据，然后告诉主板，它的状态已经改变了。

 2.主板得到光驱的数据，将数据交给CPU进行分析处理。

 3.CPU处理完，将数据分成了视频数据和音频数据，通知主板，已将处理好了。

 4.主板得到数据，将数据交给显卡和声卡进行输出。



 先用几句话说下这些代码，colleague是一个抽象类，是光驱、cpu等的父类，有对中介者mediator的引用，

 然后mediator是一个接口，ConcreteMediator实现了它的change方法，有对光驱、cpu等的引用，每当光驱、cpu等自己工作完的时候就去调用中介者的change方法，

 然后中介者的change就去做一些调兵遣将的工作比如派显卡和声卡工作，用户就能看到东西了，而这个过程，光驱、cpu等的操作都是隔离开的，没有在内部相互引用，

 而都是放在中介者里面引用的！实现了模块间的低耦合！

 * */

//抽象中介者
interface Mediator {
	void change(Colleague colleague);
}
//抽象同事类
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
		
		//通知主板,CPU工作已完成
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
		
		//通知主板,CDDriver工作已完成
		this.getMediator().change(this);
	}
}

class VideoCard extends Colleague {

	VideoCard(Mediator mediator) {
		super(mediator);
	}
	
	public void ShowVideo(String video) {
		System.out.println("显示视频"+video);
		
		//通知主板,VideoCard工作已完成
		this.getMediator().change(this);
	}
}

class SoundCard extends Colleague {

	SoundCard(Mediator mediator) {
		super(mediator);
	}
	
	public void ShowSound(String sound){
		System.out.println("发出视频声音"+sound);
		
		//通知主板,SoundCard工作已完成
		this.getMediator().change(this);
	}
}
//具体Mediator实现类
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
		//获取光驱读取的数据
		String data = cs.getData();
		//把这些数据传输给CPU进行处理
		this.cpu.excuteData(data);
	}
	
	private void openCPU(CPU cpu){
		//获取数据
		String video = cpu.getVideoCard();
		String sound = cpu.getSoundCard();
		//cpu通知声卡显卡工作,用户就可以看到影像了
		this.videoCard.ShowVideo(video);
		this.soundCard.ShowSound(sound);
	}
}

public class Test2 {
	public static void main(String[] agrs) {
		//1.创建中介者
		MainboardMediator mainboard = new MainboardMediator();
		//2.创建同事类
		CDDriver cdDriver = new CDDriver(mainboard);
		SoundCard soundCard = new SoundCard(mainboard);
		VideoCard videoCard = new VideoCard(mainboard);
		CPU cpu = new CPU(mainboard);
		//3.让中介知道所有的同事
		mainboard.setCdDriver(cdDriver);
		mainboard.setCpu(cpu);
		mainboard.setSoundCard(soundCard);
		mainboard.setVideoCard(videoCard);
		//cdDriver开始读取数据
		cdDriver.readCD(" #####视频#####, ++++声音++++");
	}
}
