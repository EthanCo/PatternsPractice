package Singleton;
//¶öººÊ½
class Peple{
	private Peple(){}
	private final static Peple peple = new Peple();
	public Peple getInstance(){
		return peple;
	}
}
//ÀÁººÊ½
class Peple2{
	private Peple2(){}
	private static Peple2 peple = null;
	public Peple2 getInstance(){
		if(peple==null){
			synchronized (Peple2.class) {
				if(peple==null){
					peple = new Peple2();
				}
			}
		}
		return peple;
	}
}

public class Singleton {
	public static void main(String[] args){
		
	}
}
