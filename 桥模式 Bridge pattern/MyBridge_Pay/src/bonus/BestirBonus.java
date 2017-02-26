package bonus;

import departments.Department;

public class BestirBonus extends Bonus {

	public BestirBonus(Department department) {
		super(department);
	}

	@Override
	public void computerBonus() {
		System.out.println("¼¤Àø½±½ğ");
	}
}
