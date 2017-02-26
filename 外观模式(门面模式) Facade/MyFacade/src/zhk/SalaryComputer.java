package zhk;

import inside.Holiday;
import inside.Salary;
import inside.Tax;

public class SalaryComputer implements Computer {

	//����ģʽ���ṩԱ����ѯ��ͳһ����
	@Override
	public double daSalary(String empno) {
		Salary salary = new Salary();
		Holiday holiday = new Holiday();
		Tax tax = new Tax();
		double money = salary.getSalary(empno)*(30-holiday.getHoliday(empno))/30-tax.getTax(empno);
		return money;
	}

}
