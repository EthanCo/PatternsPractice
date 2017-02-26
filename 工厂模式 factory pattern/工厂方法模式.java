/*
�������Ĵ����ͳ�ʼ������ûʲô��Ĳ�ͬ����û�б�Ҫ���ù�������ģʽ��ֱ��ʹ�ü򵥹���ģʽ���ɡ�
��һ�������һ�����ڴ���ĳ������ʱ������֪���������ľ���ʵ�֣�ֻ�Ƕ����˼򵥵Ľӿڣ���ʱ���ù�������ģʽ�ȽϺ�
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
//���󹤳�
interface CarFactoryable{
	public Car CreateCar();
}
//���幤����-������
class BmwFactory implements CarFactoryable{

	@Override
	public Car CreateCar() {
		return new Bmw();
	}
}
//���幤����-���۹���
class BenzFactory implements CarFactoryable{

	@Override
	public Car CreateCar() {
		return new Benz();
	}
}
//�������
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