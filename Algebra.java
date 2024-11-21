// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// loop too add
		int add = x2;
		for(int i = 0; i < x1; i++)
		{add ++;}
		return add;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// loop to minus
		int minus1 = x1; 
		for(int i = 0; i < x2 ;i++){
			minus1 = minus1 - 1;}
		return minus1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// loop to times
		int times1 = x2;
		for(int i = 0; i < x1 - 1; i++){
			times1 = plus(x2, times1);
		}
		return times1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// loop for pow
		int pow1 = x;
		for(int i = 0; i < n -1 ;i++){
			pow1 = times(pow1, x);
		}
		return pow1;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// loop for divers
		if (x2 > x1) {
			return 0;}
		int divers1 = x2;
		int much = 0;
		for(int i =0; divers1 < x1 + 1; i++){
			much ++;
			divers1 = divers1 + x2;
		}
		return much;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// loop for modolo
		int new_mod = x1 - (x2*(div(x1, x2)));
		return new_mod;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// loop for sqrt
		int new_squrt = 1;
		for(int i = 0; i < x; i++){
			if (i *i == x) {
				new_squrt = i;
			}
		}
		
		return new_squrt;
	}	  	  
}