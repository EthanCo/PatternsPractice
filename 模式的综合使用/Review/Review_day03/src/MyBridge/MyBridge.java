package MyBridge;

abstract class Bouns{
	private Department department;
	public Bouns(Department department) {
		this.department = department;
	}
	public void computerBonus(){
		department.computerBonus();
	}
}

interface Department{
	void computerBonus();
}

class PeopleBouns extends Bouns{

	public PeopleBouns(Department department) {
		super(department);
	}
	@Override
	public void computerBonus() {
		super.computerBonus();
		System.out.println("个人工资");
	}
}

class BestirBonus extends Bouns{

	public BestirBonus(Department department) {
		super(department);
	}
	@Override
	public void computerBonus() {
		super.computerBonus();
		System.out.println("激励工资");
	}
}

class Sale implements Department{

	@Override
	public void computerBonus() {
		System.out.print("计算销售部门");
	}
}

class Hr implements Department{

	@Override
	public void computerBonus() {
		System.out.print("计算人事部门");
	}
}

public class MyBridge {
	public static void main(String[] args){
		Bouns bouns = new PeopleBouns(new Hr());
		bouns.computerBonus();
		bouns = new PeopleBouns(new Sale());
		bouns.computerBonus();
		bouns = new BestirBonus(new Hr());
		bouns.computerBonus();
		bouns = new BestirBonus(new Sale());
		bouns.computerBonus();
	}
}
