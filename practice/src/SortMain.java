
public class SortMain {

	public static void main(String[] args) {
		int[] a = {345,87,1,567,9,43,568,33,55,0,-5};
		
		
		System.out.println("BEFORE");
		for (int i : a) {
			System.out.print(i + ", ");
		}
		
		// insert sort to be tested
		
		System.out.println("AFTER");
		
		for (int i : a) {
			System.out.print(i + ", ");
		}
	}

}
