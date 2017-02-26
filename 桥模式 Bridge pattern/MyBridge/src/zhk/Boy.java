package zhk;

import gift.Flower;
import gift.Gift;
import gift.GiftImpl;
import gift.Ring;
import gift.WarmGift;
import gift.WildGift;

public class Boy {
	private String name;

	public Boy(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void pursue(MM mm){
		Gift gift = new WildGift(new Ring());//��Ұ�Ľ�ָ
		//Gift gift = new WarmGift(new Flower()); //��ů�Ļ�
		give(gift,mm);
	}
	
	public void give(Gift gift,MM mm){
		
	}
}
