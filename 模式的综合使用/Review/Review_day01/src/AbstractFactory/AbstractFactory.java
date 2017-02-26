package AbstractFactory;

interface IProduct{
	void operation();
}

class Product1 implements IProduct{

	@Override
	public void operation() {
		System.out.println("产品1");
	}
}

class Product2 implements IProduct{

	@Override
	public void operation() {
		System.out.println("产品2");
	}
}

interface IBrand{
	public void paste();
}

class Brand1 implements IBrand{

	@Override
	public void paste() {
		System.out.println("贴商标1");
	}
}

class Brand2 implements IBrand{

	@Override
	public void paste() {
		System.out.println("贴商标2");
	}
}

interface IFactory{
	public IProduct createProduct();
	public IBrand createBrand();
}

class Factory1 implements IFactory{

	@Override
	public IProduct createProduct() {
		return new Product1();
	}

	@Override
	public IBrand createBrand() {
		return new Brand1();
	}
}

class Factory2 implements IFactory{

	@Override
	public IProduct createProduct() {
		return new Product2();
	}

	@Override
	public IBrand createBrand() {
		return new Brand2();
	}
}

public class AbstractFactory {
	public static void main(String[] args){
		Factory1 factory = new Factory1();
		 IBrand brand = factory.createBrand();
		 brand.paste();
		 IProduct product1 = factory.createProduct();
		 product1.operation();
	}
}
