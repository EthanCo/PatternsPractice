package Facade;

class Module1{
	public void operation(){
		System.out.println("调用"+this.getClass().getName()+"operation方法");
	}
}

class Module2{
	public void operation(){
		System.out.println("调用"+this.getClass().getName()+"operation方法");
	}
}

class Module3{
	public void operation(){
		System.out.println("调用"+this.getClass().getName()+"operation方法");
	}
}

public class Facade{
	public void AllOperation(){
		Module1 m1 = new Module1();
		Module2 m2 = new Module2();
		Module3 m3 = new Module3();
		m1.operation();
		m2.operation();
		m3.operation();
	}
}