import java.util.Arrays;

public class QuickSort {
	
	public static int[] quickSort(int[] array) {
		
		if (array.length < 2) {
			return array;
		}
		
		int[] a1;
		int[] a2;
			
		int i = -1;
		int n = array.length;
		int pivot = array[n - 1];
		for (int j = 0; j < n; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, n - 1, ++i);
		int a = getIndex(array, pivot);

		a1 = Arrays.copyOfRange(array, 0, a);
		a2 = Arrays.copyOfRange(array, a, n);


		quickSort(a1);
		quickSort(a2);
		
		
		
		return merge(a1, a2, array);
		 
			
	}
	
	
	public static int[] merge(int[] a1, int[] a2, int[] array) {
		
		int i = 0, j= 0;
		while (i + j < array.length) {
			if (j == a2.length || i < a1.length && a1[i] < a2[j]) {
				array[i + j] = a1[i++];
			}
			else {
				array[i + j] = a2[j++];
			}
			
		}
		return array;
		
		
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static int getIndex(int[] array, int i) {
		int result = 0;
		for (int z = 1; z < array.length; z++) {
			if (array[z] == i) {
				result = z;
			}
		}
		return result;
	}
}
