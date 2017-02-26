package Strategy;

interface SalaryComputer{
	void doSalary();
}

class OfficeSalary implements SalaryComputer{

	@Override
	public void doSalary() {
		System.out.println("����������Ա,ÿ����ֻ�л�������");
	}
}

class SaleSalary implements SalaryComputer{

	@Override
	public void doSalary() {
		System.out.println("����������Ա,ÿ���¸�����������ȷ������");
	}
}

class ProductSalary implements SalaryComputer{

	@Override
	public void doSalary() {
		System.out.println("����������Ա,ÿ���¸�����������ȷ������");
	}
}

class Salary{
	private SalaryComputer salaryComputer;
	public Salary(SalaryComputer salaryComputer) {
		this.salaryComputer = salaryComputer;
	}
	public void doSalary(){
		salaryComputer.doSalary();
	}
}

public class MyStrategy {
	public static void main(String[] args){
		Salary salary = new Salary(new OfficeSalary());
		salary.doSalary();
	}
}
