package zhk;

public class Test {
	public static void main(String[] args){
		//int[] a ={9,5,3,7,1};
		Cat[] a = new Cat[]{
				new Cat(1,1),
				new Cat(3,3),
				new Cat(5,5)
		};
//		Dog[] a = new Dog[]{
//			new Dog(2),
//			new Dog(4),
//			new Dog(6)
//		};
		DataSorter.sort(a);
		DataSorter.p(a);
	}
}
