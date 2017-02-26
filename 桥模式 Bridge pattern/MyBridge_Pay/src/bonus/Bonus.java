package bonus;

import departments.Department;

//计算奖金-抽象类
public abstract class Bonus {
	protected Department department;
	public Bonus(Department department) {
		this.department=department;
	}
	public void computerBonus(){
		department.computerBonus();
	}
}
