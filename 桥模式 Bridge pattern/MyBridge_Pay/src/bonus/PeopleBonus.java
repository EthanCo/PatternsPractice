package bonus;

import departments.Department;

public class PeopleBonus extends Bonus {

	public PeopleBonus(Department department) {
		super(department);
	}

	@Override
	public void computerBonus() {
		super.computerBonus();//��仰����Ҫ�������ǹ�������
		System.out.println("���˽���");
	}
}
