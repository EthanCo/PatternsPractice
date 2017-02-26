package zhk;

import java.util.Comparator;

public class DogFoodComparator implements Comparator<Dog> {

	@Override
	public int compare(Dog d1, Dog d2) {
		if (d1.getFood() > d2.getFood() ) {
			return 1;
		} else if (d1.getFood()  < d2.getFood() ) {
			return -1;
		}
		return 0;
	}
}
