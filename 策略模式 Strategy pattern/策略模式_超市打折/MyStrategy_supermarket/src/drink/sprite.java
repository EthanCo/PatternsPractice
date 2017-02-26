package drink;

import discount.NationalDayDiscount;
import mInterface.DiscountPriceable;
import mInterface.DiscountWay;

public class sprite implements DiscountPriceable {
	private double originalPrice;
	private DiscountWay discountWay = new NationalDayDiscount();

	public sprite(double originalPrice, DiscountWay discountWay) {
		super();
		this.originalPrice = originalPrice;
		this.discountWay = discountWay;
	}

	public sprite(double originalPrice) {
		super();
		this.originalPrice = originalPrice;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	@Override
	public double getDisCountPriceable() {
		return discountWay.discount(this.originalPrice);
	}

	@Override
	public String toString() {
		return "sprite discount price : "+getDisCountPriceable();
	}
}
