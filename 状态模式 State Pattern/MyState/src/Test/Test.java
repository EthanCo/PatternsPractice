package Test;
/*
 * 状态模式 state
 * 一个类的动作,是根据这个类的内部状态的不同而有不同的动作
 * 
　　当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类。
2. 解决的问题
　　主要解决的是当控制一个对象状态转换的条件表达式过于复杂时的情况。把状态的判断逻辑转移到表示不同的一系列类当中，可以把复杂的逻辑判断简单化。
3. 模式中的角色
　　3.1 上下文环境（Context）：它定义了客户程序需要的接口并维护一个具体状态角色的实例，将与状态相关的操作委托给当前的Concrete State对象来处理。
　　3.2 抽象状态（State）：定义一个接口以封装使用上下文环境的的一个特定状态相关的行为。
　　3.3 具体状态（Concrete State）：实现抽象状态定义的接口。
 * */

//电灯类，对应模式中的Context类
class Light{
	private LightState state;

	public Light(LightState state) {
		this.state = state;
	}
	
	public LightState getState() {
		return state;
	}

	public void setState(LightState state) {
		this.state = state;
	}
	//按下电灯开关
	public void PressSwich(){
		state.PressSwich(this);
	}
}
//抽象的电灯状态类，相当于State类
interface LightState{
	void PressSwich(Light light);
}
// 具体状态类, 开
class On implements LightState{
	//在开状态下，按下开关则切换到关的状态。
	@Override
	public void PressSwich(Light light) {
		System.out.println("关灯");
		light.setState(new Off());
	}
}  
//关
class Off implements LightState{
	//在关状态下，按下开关则打开电灯。
	@Override
	public void PressSwich(Light light) {
		System.out.println("开灯");
		light.setState(new On());
	}
}

public class Test {
	public static void main(String[] args){
		// 初始化电灯，原始状态为关
		Light light = new Light(new Off());
		// 第一次按下开关，打开电灯
		light.PressSwich();
		// 第二次按下开关，关闭电灯
		light.PressSwich();
	}
}
