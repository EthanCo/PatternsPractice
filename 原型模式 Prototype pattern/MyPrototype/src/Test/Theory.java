package Test;
//ԭ�ͳ�����
interface Prototype extends Cloneable{
	public Object clone();
}
//ԭ����ConcretePrototype1
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
//ԭ����ConcretePrototype2
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
