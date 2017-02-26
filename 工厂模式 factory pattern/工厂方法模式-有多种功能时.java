/*
ÿһ��ģʽ�������һ������Ľ����������������ģʽ��Ե���һ����Ʒ�ȼ��ṹ�������󹤳�ģʽ��Ե��Ƕ����Ʒ�ȼ��ṹ��
��������¾�Ӧ��ʹ�ó��󹤳�ģʽ
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
//���󹤳���
interface CarFactoryable{
	public Car CreateCar();
}
//���幤����-������
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
//���幤����-���۹���
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
//��������
interface cushion{
	public void addCushion();
}

//����ʵ����-��������
class BmwCushion implements cushion{

	@Override
	public void addCushion() {
		System.out.println("��ӱ�������");
	}
}

//����ʵ����-��������
class BenzCushion implements cushion{

	@Override
	public void addCushion() {
		System.out.println("��ӱ�������");
	}
}

//�������湤���ӿ�
interface cushionFaction{
	public cushion CreateCushion();
}

//������� �൱����
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
	