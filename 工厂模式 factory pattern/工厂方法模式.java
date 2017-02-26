/*
如果对象的创建和初始化工作没什么大的不同，就没有必要采用工厂方法模式，直接使用简单工厂模式即可。
另一种情况：一个类在创建某个对象时，还不知道这个对象的具体实现，只是定义了简单的接口，此时采用工厂方法模式比较好
*/
//抽象汽车
interface Car{
	void drive();
}

//具体汽车-宝马
class Bmw implements Car{
	public void drive(){
		System.out.println("开宝马汽车");
	} 
}
//具体汽车-奔驰
class Benz implements Car{
	public void drive(){
		System.out.println("开奔驰汽车");
	}
}
//抽象工厂
interface CarFactoryable{
	public Car CreateCar();
}
//具体工厂类-宝马工厂
class BmwFactory implements CarFactoryable{

	@Override
	public Car CreateCar() {
		return new Bmw();
	}
}
//具体工厂类-奔驰工厂
class BenzFactory implements CarFactoryable{

	@Override
	public Car CreateCar() {
		return new Benz();
	}
}
//程序入口
class Test{
	public static void main(String[] args){
		CarFactoryable bwnfactory = new BmwFactory();
		CarFactoryable benzfactory = new BenzFactory();
		Car bwn = bwnfactory.CreateCar();
		Car benz = benzfactory.CreateCar();
		bwn.drive();
		benz.drive();
	}
}