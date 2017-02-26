package zhk;

public class Test {
	public static void main(String[] args){
		//int[] a ={9,5,3,7,1};
		Cat[] cats = new Cat[]{
				new Cat(1,1),
				new Cat(3,3),
				new Cat(5,5)
		};
		DataSorter.sort(cats);
		DataSorter.p(cats);
	}
}
