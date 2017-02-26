package zhk;

import java.util.Observable;
import java.util.Observer;

/*
 * java�����Ѿ�ʵ���˹۲���ģʽ,ͨ��java�е�Observable���Observer�ӿھͿ���ʵ�ֹ۲���ģʽ
 * ���б��۲��߼̳�Observable��,�۲���ʵ��Observer�ӿ�
 * */

//���пͻ���1,ʵ�������˻��۲��߽ӿ�
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
		//oΪ����������˻��࣬�˴�һ�㲻��Ҫ����
		double amt =Double.parseDouble(arg.toString());
		System.out.println("�˻������䶯���������䵽"+email+"�䶯����Ϊ"+amt);
	}
}

	//���пͻ���2,ʵ�������˻��۲��߽ӿ�
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
			//oΪ����������˻��࣬�˴�һ�㲻��Ҫ����
			double amt =Double.parseDouble(arg.toString());
			System.out.println("------�����˻������䶯�������ֻ���"+phone+"�䶯����Ϊ"+amt+"------");
		}
	}
	
	//�����˻���
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
//		//��ӹ۲���
//		public void add(BankObserver bankObserver){
//			list.add(bankObserver);
//		}
//		//ɾ���۲���
//		public void remove(BankObserver bankObserver){
//			list.remove(bankObserver);
//		}
		//֪ͨ���ı�
//		public void notifyAmt(){
//			for(int i=0;i<list.size();i++){
//				BankObserver bankObserver = (BankObserver)list.get(i);
//				bankObserver.update(amt);
//			}
//		}
		public void setAmt(double amt){
			this.amt=amt;
//			notifyAmt();
			setChanged();//��Observable���У�ֻ���ڹ۲������е���setCahnge�������ڿͻ��˵���ʱ���Ż���������֪ͨ����
			notifyObservers(amt);
		}
	}
	
public class Test {
	//�ͻ��˴��룬�����пͻ����뵽�����˻���
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