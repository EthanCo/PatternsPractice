package Observer;

import java.util.ArrayList;
import java.util.List;

//银行账户观察者-接口
interface BankObserver{
	void update(double amt);
}
//银行客户类1,通过email通知用户
class CustomerBank1 implements BankObserver{
	private String email;
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}
	@Override
	public void update(double amt) {
		System.out.println("账户金额发生变动，发送邮箱到"+email+"变动后金额为"+amt);
	}
}
//银行客户类2,通过电话通知用户
class CustomerBank2 implements BankObserver{
	private String phone;
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		return phone;
	}
	@Override
	public void update(double amt) {
		System.out.println("账户金额发生变动，发送电话到"+phone+"变动后金额为"+amt);
	}
}

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
	//移除观察者
	public void remove(BankObserver bankObserver){
		list.remove(bankObserver);
	}
	public void notifyAmt(){
		for (BankObserver bankObserver : list) {
			bankObserver.update(amt);
		}
	}
	public void setAmt(double amt){
		this.amt=amt;
		notifyAmt();
	}
}

public class MyObserver {
	public static void main(String[] args){
		BankAccount account = new BankAccount();
		account.add(new CustomerBank1());
		account.add(new CustomerBank2());
		account.setAmt(190);
	}
}
