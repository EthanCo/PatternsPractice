package bonus;

import departments.Department;

//���㽱��-������
public abstract class Bonus {
	protected Department department;
	public Bonus(Department department) {
		this.department=department;
	}
	public void computerBonus(){
		department.computerBonus();
	}
}
