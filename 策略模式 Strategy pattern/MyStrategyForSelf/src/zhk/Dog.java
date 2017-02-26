package zhk;

public class Dog implements Comparable {
	private int food;
	private Comparator comparator = new DogFoodComparator(); //默认比较方式
	
	public Dog(int food) {
		super();
		this.food = food;
	}
	
	public Dog(int food, Comparator comparator) {
		super();
		this.food = food;
		this.comparator = comparator;
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
		return comparator.compare(this, o);
	}
}
