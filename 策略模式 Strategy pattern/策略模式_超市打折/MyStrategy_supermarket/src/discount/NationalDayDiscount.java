package discount;

import mInterface.DiscountWay;

public class NationalDayDiscount implements DiscountWay {

	@Override
	public double discount(double price) {
		return price*0.5;
	}

}
