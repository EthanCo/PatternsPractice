package test;

public class SubtractionOperation extends Operation{
	@Override
	public double getResult() {
		return this.getNum1()-this.getNum2();
	}
}
