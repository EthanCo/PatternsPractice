/*
���󹤳�ģʽ�빤������ģʽ������ 
������ô˵����������ģʽ��һ�ּ�������ĳ��󹤳�ģʽ�������󹤳�ģʽ���Կ����ǹ�������ģʽ��һ���ƹ㡣
(1)����ʵ��������ģʽ����������һ����Ʒ�ĵȼ��ṹ�ģ������󹤳�ģʽ���������������Ʒ�ĵȼ��ṹ�ġ�������������һ��ֻ��һ������������һ�ֲ�Ʒ�����󹤳�һ���ж������������һϵ�в�Ʒ�� 
(2)����������ģʽֻ��һ�������Ʒ�࣬�����󹤳�ģʽ�ж������������ģʽ�ľ��幤����ֻ�ܴ���һ�������Ʒ���ʵ���������󹤳�ģʽ���Դ�������� 
���󹤳�ģʽ�ǹ�������ģʽ�������汾������������һ����ػ����໥�����Ķ������빤������ģʽ����������ڣ���������ģʽ��Ե���һ����Ʒ�ȼ��ṹ��
�����󹤳�ģʽ������ԵĶ����Ʒ�ȼ��ṹ���ڱ���У�ͨ��һ����Ʒ�ṹ������Ϊһ���ӿڻ��߳����࣬Ҳ����˵��
��������ģʽ�ṩ�����в�Ʒ����������ͬһ���ӿڻ�����࣬�����󹤳�ģʽ���ṩ�Ĳ�Ʒ���������Բ�ͬ�Ľӿڻ�����ࡣ

�����֮-> 
��������ģʽ��һ�������Ʒ�࣬������������������Ʒ�ࡣ   
              һ�����󹤳��࣬����������������幤���ࡣ   
              ÿ�����幤����ֻ�ܴ���һ�������Ʒ���ʵ����   
���󹤳�ģʽ����������Ʒ�࣬ÿ�������Ʒ�������������������Ʒ�ࡣ   
              һ�����󹤳��࣬����������������幤���ࡣ   
              ÿ�����幤������Դ�����������Ʒ���ʵ���� 
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
abstract class Factoryable{
	public abstract Car CreateCar();
	public abstract cushion CreateCushion();
}
//���幤����-������
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
//���幤����-���۹���
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

//�������
class Test{
	public static void main(String[] args){
		Factoryable factory = new BmwFactory(); //�Ժ󻻳�����ϵ���Ʒʱ��ֻ��ʵ��cushion��Car�Ľӿ��࣬�½�һ��������Ȼ���޸���һ�仰����
//		Factoryable factory = new BenzFactory();
		cushion myCushion = factory.CreateCushion();
		myCushion.addCushion();
		Car bwn = factory.CreateCar();
		bwn.drive();
	}
}