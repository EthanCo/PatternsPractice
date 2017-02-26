package Test;
/*
 * ģ�巽��ģʽ
 * ����һ��˳���
 * ����������Դϵͳ��н��ģ����н�ʵļ��㣺�ȼ����������,�ټ��㽱��,Ȼ���������˰
 * �������������͵���Ա����н�ʶ��ǰ���ͬ����˳��,����˵����ͬ�ĵط�,����ģ�廯
 * */
class Salary{
	private SalaryComputer salaryComputer;
	public Salary(SalaryComputer salaryComputer){
		this.salaryComputer=salaryComputer;
	}
	public void doSalary(){
		salaryComputer.doSalary();
	}
}

abstract class SalaryComputer{
	public void doSalary(){
		doBase();
		doBonus();
		doTax();
	}
	
	public abstract void doBase(); //�����������
	public abstract void doBonus(); //���㽱��
	public abstract void doTax(); //��������˰
}
//������Ա
class SaleSalary extends SalaryComputer{

	@Override
	public void doBase() {
		System.out.println("��������Ա,�����������");
	}

	@Override
	public void doBonus() {
		System.out.println("��������Ա,���㽱��");
	}

	@Override
	public void doTax() {
		System.out.println("��������Ա,��������˰");
	}
}

//������Ա
class ProductSalary extends SalaryComputer{

	@Override
	public void doBase() {
		System.out.println("��������Ա,�����������");
	}

	@Override
	public void doBonus() {
		System.out.println("��������Ա,���㽱��");
	}

	@Override
	public void doTax() {
		System.out.println("��������Ա,��������˰");
	}
}

//������Ա
class OfficeSalary extends SalaryComputer{

	@Override
	public void doBase() {
		System.out.println("��������Ա,�����������");
	}

	@Override
	public void doBonus() {
		System.out.println("��������Ա,���㽱��");
	}

	@Override
	public void doTax() {
		System.out.println("��������Ա,��������˰");
	}
}

public class Test {
	public static void main(String[] args){
//		Salary salary = new Salary(new ProductSalary());
//		salary.doSalary();
//		Salary salary = new Salary(new SaleSalary());
//		salary.doSalary();
		Salary salary = new Salary(new OfficeSalary());
		salary.doSalary();
	}
}
