package MementoPattern;
//ԭ����
public class Originator {
	private String state;
	//����һ������¼����
	public Memento createMemento(){
		return new Memento(this);
	}
	//���ݱ���¼����ָ�ԭ����״̬
	public void  restoreMemento(Memento m){
		this.state=m.getState();
	}
	
	public void setState(String state){
		this.state=state;
	}
	
	public String getState(){
		return state;
	}
}
