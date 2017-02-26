package zhk;

import domain.*;
/*
 * 聚合代理的好处
 * 对代理的执行顺序以后还可以放到配置文件中
 * */
public class Test {
	public static void main(String[] args){
		System.out.println("------ 先打印日志再统计时间 ------");
		TankTimeProxy ttp = new TankTimeProxy(new Tank());
		TankLogProxy tlp = new TankLogProxy(ttp);
		tlp.move();
		
		System.out.println("------ 先统计时间再打印日志 ------");
		TankLogProxy tlp2 = new TankLogProxy(new Tank());
		TankTimeProxy ttp2 = new TankTimeProxy(tlp2);
		ttp2.move();
	}
}
