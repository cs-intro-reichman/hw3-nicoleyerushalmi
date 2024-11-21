// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

import javax.naming.NameNotFoundException;

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
		// number > 0
		if ((x1 > 0) & (x2 > 0)) {
			int add = x2;
			for(int i = 0; i < x1; i++)
				{add ++;}
			return add;}
		
		// one > 0 and the other < 0
		if ((x1 > 0) & (x2 < 0)) {
			int add = x1;
			for(int i = 0; i < x2; i++)
				{add --;}
			return add;
		}

		// one > 0 and the other < 0
		if ((x1 < 0) & (x2 > 0)) {
			int add = x2;
			for(int i = 0; i < x1; i++)
				{add --;}
			return add;
		}

		// both < 0
		if ((x1 < 0) & (x2 < 0)) {
			int add = x2;
			for(int i = 0; i < x1; i++)
				{add --;}
			return add;}
		}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// loop to minus
		// number > 0
		if ((x1 > 0) & (x2 > 0)) {
			int minus1 = x1; 
			for(int i = 0; i < x2 ;i++){
				minus1--;}
			return minus1;
		}

		// one > 0 and the other < 0
		if ((x1 > 0) & (x2 < 0)) {
			int minus1 = x1;
			for(int i = x2; i < 0 ;i++){
				minus1 ++;}
			return minus1;
		}

		// one > 0 and the other < 0
		if ((x1 < 0) & (x2 > 0)) {
			int minus1 = x1;
			for(int i = 0; i < x2 ;i++){
				minus1 --;}
			return minus1;
		}

		// both < 0
		if ((x1 < 0) & (x2 < 0)) {
			int minus1 = x1;
			for(int i = x2; i < 0 ;i++){
				minus1 = minus1 ++;}
			return minus1;}	
			}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// loop to times
		if ((x1 == 0 || x2 == 0)) {
			return 0;
		}

		if ((x1 > 0 & x2 > 0)) {
			int times1 = x2;
			for(int i = 0; i < x1 - 1; i++){
			times1 = plus(x2, times1);}
		return times1;
		}

		else{int times1 = x2;
			for(int i = 0; i < x1 - 1; i++){
				times1 = plus(x2, times1);}
			int minus_time = minus(0, times1);
			return minus_time;
		}
		
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// loop for pow
		if ((n == 0)) {
			return 1;
		}
		int pow1 = x;
		// number < 0
		if (pow1 < 0) {
			pow1 = times(-1, pow1);
		}
		// number > 0
		for(int i = 0; i < n -1 ;i++){
			pow1 = times(pow1, x);
		}
		return pow1;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// loop for divers
		// numbers > 0
		if (x1 > 0 & x2 > 0) {
			if (x2 > x1){return 0;}
			int divers1 = x2;
			int much = 0;
			for(int i =0; divers1 < x1 + 1; i++){
				much ++;
				divers1 = divers1 + x2;}
			return much;
		}

		// numbers < 0
		if ((x1 < 0 & x2 < 0)) {
			x1 = times(x1, -1);
			x2 = times(-1, x2);
			if (x2 > x1){return 0;}
			int divers1 = x2;
			int much = 0;
			for(int i =0; divers1 < x1 + 1; i++){
				much ++;
				divers1 = divers1 + x2;}
			return much;}

		// if only 1 is > 0
		if (x1 < 0 || x2 < 0) {
			x1 = times(x1, -1);
			x2 = times(-1, x2);
			if (x2 > x1){return 0;}
			int divers1 = x2;
			int much = 0;
			for(int i =0; divers1 < x1 + 1; i++){
				much ++;
				divers1 = divers1 + x2;}
				int minus_times = times(much, -1);
			return minus_times ;}
		

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// loop for modolo
		int new_mod = x1 - (x2*(div(x1, x2)));
		return new_mod;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// loop for sqrt
		if ( x < 0) {
			System.out.println("minus cant be sqrt");
		}
		else{
		int new_squrt = 1;
		for(int i = 0; i < x; i++){
			if (i *i == x) {
				new_squrt = i;}
			}
			return new_squrt;
		}
		
	}	  	  
}