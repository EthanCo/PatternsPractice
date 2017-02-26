package zhk;

public class DataSorter {
	public static void sort(Comparable[] a){
		for(int i=a.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(a[j].compareTo(a[j+1])==1){
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
