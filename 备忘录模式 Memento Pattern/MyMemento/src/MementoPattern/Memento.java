package MementoPattern;
//����¼��
class Memento {
	private String state;

	Memento(Originator o){
		this.state = o.getState();
	}
	
	String getState() {
		return state;
	}
	void setState(String state) {
		this.state = state;
	}
}
