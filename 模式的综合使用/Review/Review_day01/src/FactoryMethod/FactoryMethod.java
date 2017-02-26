package FactoryMethod;

interface IProduct{
	void operation();
}

class Product1 implements IProduct{

	@Override
	public void operation() {
		System.out.println("Product1");
	}
}

class Product2 implements IProduct{

	@Override
	public void operation() {
		System.out.println("Product2");
	}
}

interface IFactory{
	public IProduct createIProduct();
}

class Factory1 implements IFactory{

	@Override
	public IProduct createIProduct() {
		return new Product1();
	}
}

class Factory2 implements IFactory{
	@Override
	public IProduct createIProduct() {
		return new Product2();
	}
}

public class FactoryMethod {
	public static void main(String[] args){
		Factory1 factory1 = new Factory1();
		IProduct product1 = factory1.createIProduct();
		product1.operation();
		
		Factory2 factory2 = new Factory2();
		IProduct product2 = factory2.createIProduct();
		product2.operation();
	}
}
