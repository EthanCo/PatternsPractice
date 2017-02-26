package bonus;

import departments.Department;

public class TeamBonus extends Bonus {

	public TeamBonus(Department department) {
		super(department);
	}

	@Override
	public void computerBonus() {
		super.computerBonus();//这句话很重要，将他们关联起来
		System.out.println("团队奖金");
	}
}
