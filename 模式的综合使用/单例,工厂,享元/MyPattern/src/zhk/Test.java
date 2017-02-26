package zhk;

interface phone{
	void sayName();
}

class xiaomi4 implements phone{

	@Override
	public void sayName() {
		System.out.println(this);
	}
}

class hongmi1s implements phone{

	@Override
	public void sayName() {
		System.out.println(this);
	}
}

class phoneFactory{
	private phoneFactory(){};
	private static phone xiaomi4;
	private static phone hongmi1s;
	public static phone createFactory(String type){
		if(type=="xiaomi4"){
			if(xiaomi4==null){
				synchronized (phoneFactory.class) {
					if(xiaomi4==null){
						xiaomi4=new xiaomi4();
					}
				}
			}
			return xiaomi4;
		}else if(type=="hongmi1s"){
			if(hongmi1s==null){
				synchronized (phoneFactory.class) {
					if(hongmi1s==null){
						hongmi1s=new hongmi1s();
					}
				}
			}
			return hongmi1s;
		}
		return null;
	}
}

public class Test {
	public static void main(String[] args){
		phone myPhone = phoneFactory.createFactory("xiaomi4");
		myPhone.sayName();
		myPhone = phoneFactory.createFactory("hongmi1s");
		myPhone.sayName();
		myPhone = phoneFactory.createFactory("xiaomi4");
		myPhone.sayName();
	}
}