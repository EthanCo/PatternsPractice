package zhk;

import java.util.Observable;
import java.util.Observer;

/*
 * java本身已经实现了观察者模式,通过java中的Observable类和Observer接口就可以实现观察者模式
 * 其中被观察者继承Observable类,观察者实现Observer接口
 * */

//银行客户类1,实现银行账户观察者接口
class CustomerBank1 implements Observer{
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void update(Observable obs, Object arg) {
		//o为传入的银行账户类，此处一般不需要更改
		double amt =Double.parseDouble(arg.toString());
		System.out.println("账户金额发生变动，发送邮箱到"+email+"变动后金额为"+amt);
	}
}

	//银行客户类2,实现银行账户观察者接口
	class CustomerBank2 implements Observer{
		private String phone;
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}

		@Override
		public void update(Observable o, Object arg) {
			//o为传入的银行账户类，此处一般不需要更改
			double amt =Double.parseDouble(arg.toString());
			System.out.println("------您的账户金额发生变动，发送手机到"+phone+"变动后金额为"+amt+"------");
		}
	}
	
	//银行账户类
	class BankAccount extends Observable{
		private String name;
		private double amt;
//		List<BankObserver> list = new ArrayList<BankObserver>();
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getAmt() {
			return amt;
		}
//		//添加观察者
//		public void add(BankObserver bankObserver){
//			list.add(bankObserver);
//		}
//		//删除观察者
//		public void remove(BankObserver bankObserver){
//			list.remove(bankObserver);
//		}
		//通知金额改变
//		public void notifyAmt(){
//			for(int i=0;i<list.size();i++){
//				BankObserver bankObserver = (BankObserver)list.get(i);
//				bankObserver.update(amt);
//			}
//		}
		public void setAmt(double amt){
			this.amt=amt;
//			notifyAmt();
			setChanged();//在Observable类中，只有在观察者类中调用setCahnge方法，在客户端调用时，才会真正发出通知更新
			notifyObservers(amt);
		}
	}
	
public class Test {
	//客户端代码，将银行客户加入到银行账户中
	public static void main(String[] args){
		BankAccount bankAccount = new BankAccount();
		CustomerBank1 customerBank1 = new CustomerBank1();
		customerBank1.setEmail("****@***.com");
		CustomerBank2 customerBank2 = new CustomerBank2();
		customerBank2.setPhone("138########");
		bankAccount.addObserver(customerBank1);
		bankAccount.addObserver(customerBank2);
		bankAccount.setAmt(1000);
	}
}