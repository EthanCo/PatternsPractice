package domain;

import Visitor.Visitor;

public class SevenAbateMemeber implements Memeber{
	private double count;
	private double price;
	public double doComputer(){
		System.out.print("����������"+count+"��Ʒ���ۣ�"+price+"����ͨ��Ա������,");
		return count*price*0.7;
	}
	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrivce(double privce) {
		this.price = privce;
	}
	@Override
	public double accpt(Visitor visitor) {
		return visitor.visit(this);
	}

}
