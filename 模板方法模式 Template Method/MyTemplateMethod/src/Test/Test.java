package Test;
/*
 * 模板方法模式
 * 具有一定顺序的
 * 比如人力资源系统的薪酬模块中薪资的计算：先计算基本工资,再计算奖金,然后计算所得税
 * 不管是哪种类型的人员计算薪资都是按照同样的顺序,就是说有相同的地方,可以模板化
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
	
	public abstract void doBase(); //计算基本工资
	public abstract void doBonus(); //计算奖金
	public abstract void doTax(); //计算所得税
}
//销售人员
class SaleSalary extends SalaryComputer{

	@Override
	public void doBase() {
		System.out.println("对销售人员,计算基本工资");
	}

	@Override
	public void doBonus() {
		System.out.println("对销售人员,计算奖金");
	}

	@Override
	public void doTax() {
		System.out.println("对销售人员,计算所得税");
	}
}

//生产人员
class ProductSalary extends SalaryComputer{

	@Override
	public void doBase() {
		System.out.println("对生产人员,计算基本工资");
	}

	@Override
	public void doBonus() {
		System.out.println("对生产人员,计算奖金");
	}

	@Override
	public void doTax() {
		System.out.println("对生产人员,计算所得税");
	}
}

//行政人员
class OfficeSalary extends SalaryComputer{

	@Override
	public void doBase() {
		System.out.println("对行政人员,计算基本工资");
	}

	@Override
	public void doBonus() {
		System.out.println("对行政人员,计算奖金");
	}

	@Override
	public void doTax() {
		System.out.println("对行政人员,计算所得税");
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
