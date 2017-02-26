package Test;
//原型抽象类
interface Prototype extends Cloneable{
	public Object clone();
}
//原型类ConcretePrototype1
class ConcretePrototype1 implements Prototype{
	@Override
	public Object clone() {
		Object obj =null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
//原型类ConcretePrototype2
class ConcretePrototype2 implements Prototype{
	@Override
	public Object clone() {
		Object obj =null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
}

public class Theory {
	public static void main(String[] args){
		
	}
}
