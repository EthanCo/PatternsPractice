package zhk;

public class Test {
	public static void main(String[] args){
		//int[] a ={9,5,3,7,1};
		
//		Cat[] a = new Cat[]{
//				new Cat(1,10),
//				new Cat(3,3),
//				new Cat(5,5)
//		};
		
//		Cat[] a = new Cat[]{
//				new Cat(1,10,new CatWidthCamparator()),
//				new Cat(3,3,new CatWidthCamparator()),
//				new Cat(5,5,new CatWidthCamparator())
//		};
		
//		Dog[] a = new Dog[]{
//		new Dog(2),
//		new Dog(4),
//		new Dog(6)
//	};
		
		Dog[] a = new Dog[]{
		new Dog(2,new DogFoodComparator()),
		new Dog(4,new DogFoodComparator()),
		new Dog(6,new DogFoodComparator())
	};
		
		//DataSorter.sort(a); //自己写的封装方法
		java.util.Arrays.sort(a); //JDK已经封装好的排序方式
		DataSorter.p(a);
	}
}
