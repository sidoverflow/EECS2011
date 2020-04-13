import java.util.Arrays;

public class MergeSort  {
	
	public static int[] mergeSort(int[] array) {
		int size = array.length;
		
		if (size < 2) {
			return array;
		}
		
		int mid = size/2;
		
		int[] a1 = Arrays.copyOfRange(array, 0, mid);
		int[] a2 = Arrays.copyOfRange(array, mid, size);
		
		mergeSort(a1);
		mergeSort(a2);
		
		return merge(a1, a2, array);

		
	}
	
	public static int[] merge(int[] a1, int[] a2, int[] array) {
		int i = 0, j =0;
		while (i + j < array.length) {
			if (j == a2.length || i < a1.length && (a1[i] < a2[j])) {
				array[i + j] = a1[i++];
			}
			else {
				array[i + j] = a2[j++];
			}
		}
		return array;
	}
	

}
