package zhk;

public class DataSorter {
	public static void sort(int[] a){

		for(int i=a.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(a[j]>a[j+1]){
					swap(a,j,j+1);
				}
			}
		}
	}

	private static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x]=a[y];
		a[y]=temp;
	}

	public static void p(int[] a) {
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]+" ");
		}
	}
}
