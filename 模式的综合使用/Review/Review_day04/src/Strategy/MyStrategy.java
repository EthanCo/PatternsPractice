package Strategy;

interface SalaryComputer{
	void doSalary();
}

class OfficeSalary implements SalaryComputer{

	@Override
	public void doSalary() {
		System.out.println("对于行政人员,每个月只有基本工资");
	}
}

class SaleSalary implements SalaryComputer{

	@Override
	public void doSalary() {
		System.out.println("对于销售人员,每个月根据销售量来确定工资");
	}
}

class ProductSalary implements SalaryComputer{

	@Override
	public void doSalary() {
		System.out.println("对于生产人员,每个月根据生产量来确定工资");
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
