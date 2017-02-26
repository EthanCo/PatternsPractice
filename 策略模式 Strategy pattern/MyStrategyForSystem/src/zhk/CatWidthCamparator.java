package zhk;

import java.util.Comparator;

public class CatWidthCamparator implements Comparator<Cat> {

	@Override
	public int compare(Cat c1, Cat c2) {
		if (c1.getWidth() > c2.getWidth() ) {
			return 1;
		} else if (c1.getWidth()  < c2.getWidth() ) {
			return -1;
		}
		return 0;
	}


}
