package Test;

import java.util.ArrayList;
import java.util.List;
/*
 * 命令模式
 * 到银行办理业务时,通常要先到取号机进行取号,然后到相应的窗口办理业务,这里的取号机就是具体某个窗口执行指令的命令类
 * 示例：银行有VIP窗口和普通窗口,根据客户端添加命令的先后,执行相应的操作
 * 原理：命令模式就是把一个请求或者操作封装到一个对象中。命令模式允许系统使用不同的请求把客户端参数化,
 * 对请求排队或者记录请求日志,可以提供命令的撤销和恢复功能
 * */
 /*
	命令模式将用户实现设定好的命令储存起来,然后在指定的时间里按照一定的顺序将命令取出执行
	在实际应用中,命令模式可与责任链模式可以很好地结合起来,对于用户的命令,
	可以通过命令模式进行存储,然后通过责任链模式,再将命令按照一定的顺序执行
 */
//命令接口
interface Command{
	public void execute();//执行
}

//银行普通窗口
class CommonWindow implements Command{

	@Override
	public void execute() {
		System.out.println("普通窗口,办理普通业务");
	}
}

//银行VIP窗口
class VIPWindow implements Command{

	@Override
	public void execute() {
		System.out.println("VIP窗口,办理VIP业务");
	}
}

//取号机
class Lotto{
	List< Command> list = new ArrayList<Command>();
	public void doCommand(){
		for (Command command : list) {
			command.execute();
		}
	}
	//添加命令
	void addCommand(Command command){
		list.add(command);
	}
}

public class Test {
	public static void main(String[] args){
		Lotto lotto = new Lotto();
		lotto.addCommand(new CommonWindow());
		lotto.addCommand(new VIPWindow());
		lotto.doCommand();
	}
}
