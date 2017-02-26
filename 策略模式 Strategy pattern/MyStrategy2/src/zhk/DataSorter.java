package zhk;

public class DataSorter {
	public static void sort(Object[] a){

		for(int i=a.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				Cat cat1= (Cat)a[j];
				Cat cat2 =(Cat)a[j+1];
				if(cat1.getHeight()>cat2.getHeight()){
					swap(a,j,j+1);
				}
			}
		}
	}

	private static void swap(Object[] a, int x, int y) {
		Object temp = a[x];
		a[x]=a[y];
		a[y]=temp;
	}

	public static void p(Object[] a) {
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}
