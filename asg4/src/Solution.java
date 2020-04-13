import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		

		Scanner scanner = new Scanner( System.in );


	    System.out.print( "Enter: " );


	    int input = scanner.nextInt();
	    
	    scanner.close();
	    
	    System.out.println(reverse(input));
	    

	}
	

	    public static int reverse(int x) {
	        int n = 0;
	        int sign = 1;
	        int tmp;
	        
	        if (x < 0) {
	            sign = -1;
	            x = -x;
	        }

	        while (x != 0) {
	            tmp = x % 10;
	            n = (n * 10) + tmp;
	            if (n == Integer.MIN_VALUE + n || n == Integer.MAX_VALUE + n) {
		            return 0;
		        }
	            x = x / 10;
	        }
	        
	        

	        return (int) n * sign;
	    }


}
