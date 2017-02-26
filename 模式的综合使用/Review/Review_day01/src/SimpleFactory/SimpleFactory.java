package SimpleFactory;
//抽象产品
interface IProduct{
	void operation();
}
//具体产品1
class Product1 implements IProduct{

	@Override
	public void operation() {
		System.out.println("Product1");
	}
}
//具体产品2
class Product2 implements IProduct{

	@Override
	public void operation() {
		System.out.println("Product2");
	}
}
//工厂类
class Factory1{
	public static IProduct createProduct (String productName){
		if("1".equals(productName)){
			return new Product1();
		}else if("2".equals(productName)){
			return new Product2();
		}else{
		return null;
		}
	}
}

public class SimpleFactory {
	public static void main(String[] args){
		IProduct product = Factory1.createProduct("1");
		product.operation();
	}
}
