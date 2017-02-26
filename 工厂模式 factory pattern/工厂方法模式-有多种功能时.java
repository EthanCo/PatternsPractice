/*
每一个模式都是针对一定问题的解决方案，工厂方法模式针对的是一个产品等级结构；而抽象工厂模式针对的是多个产品等级结构。
这种情况下就应该使用抽象工厂模式
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
interface CarFactoryable{
	public Car CreateCar();
}
//具体工厂类-宝马工厂
class BmwFactory implements CarFactoryable,cushionFaction{

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
class BenzFactory implements CarFactoryable,cushionFaction{

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

//抽象坐垫工厂接口
interface cushionFaction{
	public cushion CreateCushion();
}

//程序入口 相当复杂
class Test{
	public static void main(String[] args){
		CarFactoryable bwnfactory = new BmwFactory();
		CarFactoryable benzfactory = new BenzFactory();
		cushionFaction cushionfactory1 = new BmwFactory();
		cushionFaction cushionfactory2 = new BenzFactory();
		Car bwn = bwnfactory.CreateCar();
		Car benz = benzfactory.CreateCar();
		cushion bwnCushion = cushionfactory1.CreateCushion();
		cushion benzCushion = cushionfactory2.CreateCushion();
		bwn.drive();
		benz.drive();
		bwnCushion.addCushion();
		benzCushion.addCushion();
	}
}
	