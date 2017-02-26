package Builder;

interface IProduct {
	String operation();
}

class Product1 implements IProduct {

	@Override
	public String operation() {
		return "产品1";
	}
}

class Product2 implements IProduct {

	@Override
	public String operation() {
		return "产品2";
	}
}

interface IBrand {
	public String paste();
}

class Brand1 implements IBrand {

	@Override
	public String paste() {
		return "贴商标1";
	}
}

class Brand2 implements IBrand {

	@Override
	public String paste() {
		return "贴商标2";
	}
}

interface IFactory {
	public IProduct createProduct();

	public IBrand createBrand();
}

class Factory1 implements IFactory {

	@Override
	public IProduct createProduct() {
		return new Product1();
	}

	@Override
	public IBrand createBrand() {
		return new Brand1();
	}
}

class Factory2 implements IFactory {

	@Override
	public IProduct createProduct() {
		return new Product2();
	}

	@Override
	public IBrand createBrand() {
		return new Brand2();
	}
}

class Director {
	private IFactory factory;

	public void setFactory(IFactory factory){
		this.factory = factory;
	}
	public IFactory getFactory(){
		return factory;
	}
	//组装
	public String assemble(){
		IBrand brand = factory.createBrand();
		IProduct product = factory.createProduct();
		return brand.paste()+"-------"+product.operation();
	}
}

public class Builder {
	public static void main(String[] args) {
		Director director = new Director();
//		director.setFactory(new Factory1());
		director.setFactory(new Factory2());
		System.out.println(director.assemble());
	}
}
