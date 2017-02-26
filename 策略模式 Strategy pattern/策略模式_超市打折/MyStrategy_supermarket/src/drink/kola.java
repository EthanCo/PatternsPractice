package drink;

import mInterface.DiscountPriceable;
import mInterface.DiscountWay;
import discount.NationalDayDiscount;

public class kola implements DiscountPriceable{
	private double originalPrice;
	private DiscountWay discountWay = new NationalDayDiscount();

	public kola(double originalPrice, DiscountWay discountWay) {
		super();
		this.originalPrice = originalPrice;
		this.discountWay = discountWay;
	}

	public kola(double originalPrice) {
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
		return "kola discount price : "+getDisCountPriceable();
	}
}
