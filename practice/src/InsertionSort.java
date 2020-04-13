
public class InsertionSort {
	
	public static int[] insertionSort(int[] a) {
		for (int p = 0; p < a.length; p++) {
			int j;
			int tmp = a[p];
			for (j = p; j > 0 && tmp < a[j - 1]; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
		return a;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int[] insertSort(int[] array) {
		int  j;
		for (int p = 0; p < array.length; p++) {
			int tmp = array[p];
			for (j = p; j > 0 && tmp < array[j - 1]; j--) {
				array[j] = array[j - 1];
			}
			array[j] = tmp;
		}
		return array;
	}

}







































