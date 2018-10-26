/**
 * INSTRUCTIONS.
 * 
 * The following exercises are, perhaps, more mathematically inclined than previous
 * problem sets. While they might be challenging, they are certainy doable.
 * 
 * You can (and should!) solve each of them using only the operators, conditional control
 * structures, and iterative control strucurs we've covered. You are not permitted to use
 * recursive code in your solutions.
 * 
 * Please be mindful of the expected outputs, as your code will be tested against that
 * directly. If you're unsure, please ask for clarification.
 * 
 * This problem set is worth 25 points and is due no later than 11:59pm on October 28, 2018.
 */
public class ProblemSet3_5 {
	
	public static void main(String[] args) {
		ProblemSet3_5 ps = new ProblemSet3_5();
		
		// test your solutions here
		
		ps.primes(1, 100000);
		ps.leapYears(5);
		ps.palindromicNumbers(434);
		ps.fibonacci(11);
		ps.multiples(2, 4, 1000);
	}
	/**
	 * How many prime numbers are there between @start and @end, where @start and @end
	 * are positive integers in the range [1, @Integer.MAX_VALUE]?
	 * 
	 * Print your solution in the following formats: "There is X prime number."
	 *                                               "There are X prime numbers."
	 * 
	 * @param start
	 * @param end
	 */
	public void primes(int start, int end) {
		long count = 0;
		for (int n = start; n <= end; n++) {
			int s = 0;
			if(n == 1 || n == 0) {
				count +=0;
			}
			else if(n == 2) {
				count += 1;
			}
			else {
				for(int i = 2; i < n; i++) {
					if(n % i == 0) {
						i = n;
						s = 3;
					}
				}
				if (s == 3) {
					count += 0;
				}
				else {
					count += 1;
				}
			}
		}
		if (count != 1) {
			System.out.println("There are " + count + " prime numbers.");
		}
		else {
			System.out.println("There is " + count + " prime number.");
		}
		
	}
	/**
	 * What are the next @count leap years?
	 * 
	 * Print your solution in the following formats: "The next leap year is X."
	 *                                               "The next 2 leap years are X and Y."
	 *                                               "THe next N leap years are A, ..., X, Y, and Z."
	 * 
	 * @param count
	 */
	
	public void leapYears(int count) {
		int f_leapy = 2020;
		if(count > 1) {
			System.out.print("The next " + count + " leap years are " + f_leapy + ", ");
		}
		for(int n = 1; n < count; n++) {
			if (n+1 == count) {
				if ((f_leapy + n*4) % 100 != 0) {
					System.out.print((f_leapy + n*4 ) + ". \n");
				}
				else if((f_leapy + n*4) % 400 == 0) {
					System.out.print((f_leapy + n*4 ) + ". \n");
				}
			}
			else {
				if ((f_leapy + n*4) % 100 != 0) {
					System.out.print((f_leapy + n*4 ) + ", ");
				}
				else if((f_leapy + n*4) % 400 == 0) {
					System.out.print((f_leapy + n*4 ) + ", ");
				}
			}
			
		}
		if (count == 1) {
			System.out.println("The next leap year is " + f_leapy + ".");
		}
	}
	
	/**
	 * Is @number a palindromic number?
	 * 
	 * Print your solution in the following formats: "X is a palindromic number."
	 *                                               "X is not a palindromic number."
	 *                                               
	 * @param number
	 */
	
	public void palindromicNumbers(int number) {
		int reverse_num = 0;
		if (number < 10) {
			System.out.println(number + " is a palindromic number.");
		}
		else {
			int nn = number;
			while(number != 0) {
				int n = number % 10;
	            reverse_num = reverse_num * 10 + n;
	            number /= 10;
		    }
			if(nn == reverse_num) {
				System.out.println(nn + " is a palindromic number.");
			}
			else {
				System.out.println(nn + " is not a palindromic number.");
			}
		}
	}
	
	/**
	 * What is the @nth Fibonacci number, where @n is a positive integer?
	 * 
	 * Print your solution in the following formats: "The 21st Fibonacci number is X."
	 *                                               "The 22nd Fibonacci number is X."
	 *                                               "The 23rd Fibonacci number is X."
	 *                                               "The 24th Fibonacci number is X."
	 *                                               
	 * @param n
	 */
	
	public void fibonacci(int n) {
		int i = 0;
		int number = n;
		int[] fibl = new int[n];
		if (number > 0) {
			while (n > 0){ 
			fibl[i] = n % 10; 
			n /= 10; 
			i++; 
			}
		}
		if (number == 0) {
			System.out.print("The " + number + "th Fibonacci number is 1.");
		}
		if (fibl[0] == 1 && number != 11) {
			System.out.print("The " + number + "st Fibonacci number is ");
		}
		else if (fibl[0] == 2 && number != 12) {
			System.out.print("The " + number + "nd Fibonacci number is ");
		}
		else if (fibl[0] == 3 && number != 13) {
			System.out.print("The " + number + "rd Fibonacci number is ");
		}
		else {
			System.out.print("The " + number + "th Fibonacci number is ");
		}
		long fn = 1;
		long sn = 1;
		long x = 0;
		for (int num = number; num > 1; num--) {
			if (x > 0) {
				x = fn + sn;
				fn = sn;
				sn = x;
			}
			else {
				x = 1;
			}
		}
		if (number > 0) {
			System.out.println(x + ".");
		}
	}
	
	/**
	 * What is the sum of all multiples of @x and @y less than @limit, where @x, @y, and
	 * @limit are positive integers?
	 * 
	 * Print your solution in the following format: "The sum of all multiples of X and Y less than LIMIT is Z."
	 * 
	 * @param limit
	 */
	
	public void multiples(int x, int y, int limit) {
		int ax = x;
		int ay = y;
		long sumx = 0;
		long sumy = 0;
		int countx = (limit-1) / x;
		int county = (limit-1) / y;
		int yhold = 0;
		int xhold = 0;
		while (countx > 0) {
			sumx =  sumx + x * countx;
			countx--;
		}
		while (county > 0) {
			sumy =  sumy + y * county;
			county--;
		}
		countx = (limit-1) / x;
		county = (limit-1) / y;
		yhold= county * y;
		while(county > 0) {
			while(countx > 0) {
				xhold = countx * x;
				if(yhold == xhold) {
					sumy = sumy - yhold;
				}
				countx--;
			}
			countx = (limit-1) / x;
			county--;
			yhold = county * y;
		}
		long sum;
		if (x == y) {
			sum = sumx;
		}
		else {
			sum = sumx + sumy;
		}
		System.out.println("The sum of all the multiples of " + ax + " and " + ay + " less than " + limit + " is " + sum + ".");
	}
}