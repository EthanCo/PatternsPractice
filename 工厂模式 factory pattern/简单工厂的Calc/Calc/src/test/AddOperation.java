package test;

public class AddOperation extends Operation {
	@Override
	public double getResult() {
		return this.getNum1()+this.getNum2();
	}
}
