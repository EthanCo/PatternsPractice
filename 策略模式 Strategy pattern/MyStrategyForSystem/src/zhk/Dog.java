package zhk;

import java.util.Comparator;

public class Dog implements Comparable<Dog> {
	private int food;
	private Comparator<Dog> comparator = new DogFoodComparator(); //默认比较方式
	
	public Dog(int food) {
		super();
		this.food = food;
	}
	
	public Dog(int food, Comparator<Dog> comparator) {
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
	public int compareTo(Dog o) {
		return comparator.compare(this, o);
	}
}
