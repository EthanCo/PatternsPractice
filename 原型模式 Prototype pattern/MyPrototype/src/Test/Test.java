package Test;

/*
 * ԭ��ģʽ
 * ���ϣ���˺��¶�����κθĶ�������Ӱ��ԭ�������е�ֵ,Ҳ����˵,�¶����ԭ���Ķ��������������Ķ���
 * ���¶���ĳ�ʼֵ����ԭ���Ķ���ȷ����,��ʱ�Ͳ���ֱ�Ӹ�ֵ,����Ҫʹ��ԭ��ģʽ
	
    (1)ǳ��¡��shallow clone����ǳ������ָ��������ʱ��������������Ͷ����еĻ������������������������������ָ��Ķ��� 
    (2)���¡��deep clone������������������������ҿ����������������ָ������ж��� 
	��������һ�£�����A1�а�����B1�����ã�B1�а�����C1�����á�ǳ����A1�õ�A2��A2����Ȼ������B1�����ã�B1����Ȼ������C1�����á�
	������Ƕ�ǳ�����ĵݹ飬���A1�õ�A2��A2�а�����B2��B1��copy�������ã�B2�а�����C2��C1��copy�������á� 
	���忴http://ncs123.iteye.com/blog/1775631
 * */

class Product implements Cloneable {
	private int id;   
	private double price;
	private double rebate;//�ۿ�
	
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
		System.out.println("��ţ�"+p.getId()+"�۸�"+p.getPrice()+"�ۿۣ�"+p.getRebate());
	}
}
