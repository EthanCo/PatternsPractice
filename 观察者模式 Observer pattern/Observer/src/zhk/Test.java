package zhk;

import java.util.ArrayList;
import java.util.List;

//银行账户观察者-接口
interface BankObserver{
	public void update(double amt);
}

//银行客户类1,实现银行账户观察者接口
class CustomerBank1 implements BankObserver{
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void update(double amt) {
		System.out.println("账户金额发生变动，发送邮箱到"+email+"变动后金额为"+amt);
	}
}

	//银行客户类2,实现银行账户观察者接口
	class CustomerBank2 implements BankObserver{
		private String phone;
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}

		@Override
		public void update(double amt) {
			System.out.println("------您的账户金额发生变动，发送手机到"+phone+"变动后金额为"+amt+"------");
		}
	}
	
	//银行账户类
	class BankAccount{
		private String name;
		private double amt;
		List<BankObserver> list = new ArrayList<BankObserver>();
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getAmt() {
			return amt;
		}
		//添加观察者
		public void add(BankObserver bankObserver){
			list.add(bankObserver);
		}
		//删除观察者
		public void remove(BankObserver bankObserver){
			list.remove(bankObserver);
		}
		//通知金额改变
		public void notifyAmt(){
			for(int i=0;i<list.size();i++){
				BankObserver bankObserver = (BankObserver)list.get(i);
				bankObserver.update(amt);
			}
		}
		public void setAmt(double amt){
			this.amt=amt;
			notifyAmt();
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
		bankAccount.add(customerBank1);
		bankAccount.add(customerBank2);
		bankAccount.setAmt(1000);
	}
}


