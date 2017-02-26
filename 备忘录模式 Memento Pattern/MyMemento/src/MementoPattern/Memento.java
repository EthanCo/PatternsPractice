package MementoPattern;
//±¸ÍüÂ¼Àà
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
