/*
	�κεķ�����ֻҪ����������ƿ����˲���������߼��������԰�����֮Ϊ������صķ���
�򵥹���ģʽ
	ԭ�ɣ����������ʼ�����������Ķ���
	���ã�������Ĵ�����ʹ�������
*/

//��������
interface Car{
	void drive();
}

//��������-����
class Bmw implements Car{
	public void drive(){
		System.out.println("����������");
	} 
}
//��������-����
class Benz implements Car{
	public void drive(){
		System.out.println("����������");
	}
}
/*
//����һ����ͨ��ʽ
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

//������������Java������������ʵ��
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
//�������
class Test{
	public static void main(String[] args){
		CarFactory factory = new CarFactory();
		//����һ
		//Car bmw = factory.CreateCar("Bmw");
		//Car benz = factory.CreateCar("Benz");
		//������
		Car bmw = factory.CreateCar("zhk.Bmw");
		Car benz = factory.CreateCar("zhk.Benz");
		bmw.drive();
		benz.drive();
	}
}