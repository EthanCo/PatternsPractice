package discount;

import mInterface.DiscountWay;

public class NewYearsDayDiscount implements DiscountWay{

	@Override
	public double discount(double price) {
		return price*0.8;
	}
	
}
