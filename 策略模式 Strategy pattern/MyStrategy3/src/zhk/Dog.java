package zhk;

public class Dog implements Comparable {
	private int food;

	public Dog(int food) {
		super();
		this.food = food;
	}

	@Override
	public String toString() {
		return "Dog [food=" + food + "]";
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Cat){
			Dog d = (Dog)o;
			if(this.food>d.food){
				return 1;
			}else if(this.food<d.food){
				return -1;
			}
			return 0;
		}
		return -100; //理论上应该抛出异常
	}
}
