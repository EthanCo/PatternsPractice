package Test;

/*
 * 原型模式
 * 如果希望此后新对象的任何改动都不会影响原来对象中的值,也就是说,新对象和原来的对象是两个独立的对象
 * 但新对象的初始值是由原来的对象确定的,此时就不是直接赋值,而需要使用原型模式
	
    (1)浅克隆（shallow clone），浅拷贝是指拷贝对象时仅仅拷贝对象本身和对象中的基本变量，而不拷贝对象包含的引用指向的对象。 
    (2)深克隆（deep clone），深拷贝不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象。 
	举例区别一下：对象A1中包含对B1的引用，B1中包含对C1的引用。浅拷贝A1得到A2，A2中依然包含对B1的引用，B1中依然包含对C1的引用。
	深拷贝则是对浅拷贝的递归，深拷贝A1得到A2，A2中包含对B2（B1的copy）的引用，B2中包含对C2（C1的copy）的引用。 
	具体看http://ncs123.iteye.com/blog/1775631
 * */

class Product implements Cloneable {
	private int id;   
	private double price;
	private double rebate;//折扣
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRebate() {
		return rebate;
	}

	public void setRebate(double rebate) {
		this.rebate = rebate;
	}

	public Product(int id, double price, double rebate) {
		super();
		this.id = id;
		this.price = price;
		this.rebate = rebate;
	}
	
	@Override
	protected Object clone(){
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e);
		}
		return obj;
	}
}

public class Test {
	public static void main(String[] args) {
		Product product = new Product(1, 123, 0.8);
		say(product);
		Product product1 = (Product) product.clone();
		say(product1);
		product1.setPrice(777);
		say(product);
		say(product1);
	}
	static void say(Product p){
		System.out.println("编号："+p.getId()+"价格："+p.getPrice()+"折扣："+p.getRebate());
	}
}
