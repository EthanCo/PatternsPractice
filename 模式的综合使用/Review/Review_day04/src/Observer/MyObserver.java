package Observer;

import java.util.ArrayList;
import java.util.List;

//�����˻��۲���-�ӿ�
interface BankObserver{
	void update(double amt);
}
//���пͻ���1,ͨ��email֪ͨ�û�
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
		System.out.println("�˻������䶯���������䵽"+email+"�䶯����Ϊ"+amt);
	}
}
//���пͻ���2,ͨ���绰֪ͨ�û�
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
		System.out.println("�˻������䶯�����͵绰��"+phone+"�䶯����Ϊ"+amt);
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
	
	//��ӹ۲���
	public void add(BankObserver bankObserver){
		list.add(bankObserver);
	}
	//�Ƴ��۲���
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
