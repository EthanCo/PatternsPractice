package zhk;

public class DogFoodComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Dog d1 = (Dog) o1;
		Dog d2 = (Dog) o2;

		if (d1.getFood() > d2.getFood() ) {
			return 1;
		} else if (d1.getFood()  < d2.getFood() ) {
			return -1;
		}
		return 0;
	}
}
