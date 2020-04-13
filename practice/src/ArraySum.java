import java.util.Arrays;

public class ArraySum {
	
	public static int arraySum(int[] a) {
		if (a.length == 1) {
			return a[0];
		}
		else {
			return a[0] + arraySum(Arrays.copyOfRange(a, 1, a.length)); 
		}
	}
	
	public static int binaryArraySum(int[] a, int i, int j) {
		
		if (j == 1) {
			return a[i];
		}
		
		return binaryArraySum(a, i, j/2) + binaryArraySum(a, (i + j/2), (j - j/2));
		
	}

}
