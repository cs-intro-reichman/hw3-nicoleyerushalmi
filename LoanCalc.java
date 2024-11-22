// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {

	static double epsilon = 0.001; // Approximation accuracy
	static int iterationCounter; // Number of iterations

	// Gets the loan data and computes the periodical payment.
	// Expects to get three command-line arguments: loan amount (double),
	// interest rate (double, as a percentage), and number of payments (int).
	public static void main(String[] args) {
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the
	// periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {
		// Replace the following statement with your code
		double left_to_pay = loan;
		double interest_rate = 1 + (rate / 100);
		for (int j = 0; j < n; j++) {
			left_to_pay = (left_to_pay - payment) * interest_rate;
		}
		return left_to_pay;
	}

	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		// Replace the following statement with your code
		double try_payment = 10;
		epsilon = 10;
		int increment = 5;
		iterationCounter = 0;
		double endB = loan;
		while (endB >= epsilon) {
			endB = endBalance(loan, rate, increment, try_payment);
			try_payment = try_payment + increment;
			iterationCounter++;
		}
		return try_payment;
    }

	// Uses bisection search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
		// Replace the following statement with your code
		double try_payment = (loan + epsilon) / 2;
		double endB = loan;
		epsilon = 10;
		double last_try = loan;
		iterationCounter = 0;
		while (endB <= epsilon) {
			iterationCounter++;
			endB = endBalance(loan, rate, n, try_payment);
			if (endB < 0) {
				last_try = try_payment;
				try_payment = (epsilon + try_payment) / 2;
			} else {
				try_payment = (try_payment + last_try) / 2;
			}
		}
		return try_payment;
	}
}