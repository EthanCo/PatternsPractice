package bonus;

import departments.Department;

public class TeamBonus extends Bonus {

	public TeamBonus(Department department) {
		super(department);
	}

	@Override
	public void computerBonus() {
		super.computerBonus();//��仰����Ҫ�������ǹ�������
		System.out.println("�Ŷӽ���");
	}
}
