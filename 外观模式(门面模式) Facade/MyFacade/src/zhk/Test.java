package zhk;
/*
 * 薪资计算
 * */
public class Test {
	public static void main(String[] args){
		SalaryComputer computer = new SalaryComputer();
		double money = computer.daSalary("员工编号");
		System.out.println("本月工资为： "+money);
	}
}
