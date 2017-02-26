package bonus;

import departments.Department;

public class PeopleBonus extends Bonus {

	public PeopleBonus(Department department) {
		super(department);
	}

	@Override
	public void computerBonus() {
		super.computerBonus();//这句话很重要，将他们关联起来
		System.out.println("个人奖金");
	}
}
