package Facade;
public class Test {
	public static void main(String[] args){
//		Facade f= new Facade();
//		f.AllOperation();
		Facade facade = (Facade) PropertiesUtil.getInstance();
		facade.AllOperation();
	}
}
