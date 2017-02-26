/*
	任何的方法，只要在它里面控制控制了产生对象的逻辑，都可以把他称之为工厂相关的方法
简单工厂模式
	原由：创建后还需初始化大量参数的对象
	作用：将对象的创建和使用相分离
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
/*
//方法一：普通方式
class CarFactory{
	public Car CreateCar(String CarType){
		if("Bmw".equals(CarType))
			return new Bmw();
		else if("Benz".equals(CarType))
			return new Benz();
		return null;
	}
}
*/

//方法二：采用Java反射来创建类实例
class CarFactory{
	public Car CreateCar(String type){
		Car car = null;
		try {
			car = (Car)Class.forName(type).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return car;
	}
}
//程序入口
class Test{
	public static void main(String[] args){
		CarFactory factory = new CarFactory();
		//方法一
		//Car bmw = factory.CreateCar("Bmw");
		//Car benz = factory.CreateCar("Benz");
		//方法二
		Car bmw = factory.CreateCar("zhk.Bmw");
		Car benz = factory.CreateCar("zhk.Benz");
		bmw.drive();
		benz.drive();
	}
}