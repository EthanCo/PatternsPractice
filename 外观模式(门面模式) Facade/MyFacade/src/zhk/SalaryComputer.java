package zhk;

import inside.Holiday;
import inside.Salary;
import inside.Tax;

public class SalaryComputer implements Computer {

	//门面模式，提供员工查询的统一门面
	@Override
	public double daSalary(String empno) {
		Salary salary = new Salary();
		Holiday holiday = new Holiday();
		Tax tax = new Tax();
		double money = salary.getSalary(empno)*(30-holiday.getHoliday(empno))/30-tax.getTax(empno);
		return money;
	}

}
