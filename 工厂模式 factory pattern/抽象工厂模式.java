/*
抽象工厂模式与工厂方法模式的区别 
可以这么说，工厂方法模式是一种极端情况的抽象工厂模式，而抽象工厂模式可以看成是工厂方法模式的一种推广。
(1)、其实工厂方法模式是用来创建一个产品的等级结构的，而抽象工厂模式是用来创建多个产品的等级结构的。工厂方法创建一般只有一个方法，创建一种产品。抽象工厂一般有多个方法，创建一系列产品。 
(2)、工厂方法模式只有一个抽象产品类，而抽象工厂模式有多个。工厂方法模式的具体工厂类只能创建一个具体产品类的实例，而抽象工厂模式可以创建多个。 
抽象工厂模式是工厂方法模式的升级版本，他用来创建一组相关或者相互依赖的对象。他与工厂方法模式的区别就在于，工厂方法模式针对的是一个产品等级结构；
而抽象工厂模式则是针对的多个产品等级结构。在编程中，通常一个产品结构，表现为一个接口或者抽象类，也就是说，
工厂方法模式提供的所有产品都是衍生自同一个接口或抽象类，而抽象工厂模式所提供的产品则是衍生自不同的接口或抽象类。

简而言之-> 
工厂方法模式：一个抽象产品类，可以派生出多个具体产品类。   
              一个抽象工厂类，可以派生出多个具体工厂类。   
              每个具体工厂类只能创建一个具体产品类的实例。   
抽象工厂模式：多个抽象产品类，每个抽象产品类可以派生出多个具体产品类。   
              一个抽象工厂类，可以派生出多个具体工厂类。   
              每个具体工厂类可以创建多个具体产品类的实例。 
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
//抽象工厂类
abstract class Factoryable{
	public abstract Car CreateCar();
	public abstract cushion CreateCushion();
}
//具体工厂类-宝马工厂
class BmwFactory extends Factoryable{

	@Override
	public Car CreateCar() {
		return new Bmw();
	}

	@Override
	public cushion CreateCushion() {
		return new BmwCushion();
	}
}
//具体工厂类-奔驰工厂
class BenzFactory  extends Factoryable{

	@Override
	public Car CreateCar() {
		return new Benz();
	}

	@Override
	public cushion CreateCushion() {
		return new BenzCushion();
	}
}
//抽象坐垫
interface cushion{
	public void addCushion();
}

//具体实现类-宝马坐垫
class BmwCushion implements cushion{

	@Override
	public void addCushion() {
		System.out.println("添加宝马坐垫");
	}
}

//具体实现类-奔驰坐垫
class BenzCushion implements cushion{

	@Override
	public void addCushion() {
		System.out.println("添加奔驰坐垫");
	}
}

//程序入口
class Test{
	public static void main(String[] args){
		Factoryable factory = new BmwFactory(); //以后换成其他系类产品时，只需实现cushion和Car的接口类，新建一个工厂，然后修改这一句话即可
//		Factoryable factory = new BenzFactory();
		cushion myCushion = factory.CreateCushion();
		myCushion.addCushion();
		Car bwn = factory.CreateCar();
		bwn.drive();
	}
}