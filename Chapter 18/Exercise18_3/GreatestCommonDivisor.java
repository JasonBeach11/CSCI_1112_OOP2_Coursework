/**
 * @Author Jason Beach
 * Date: 3/23/2023
 * CSCI 1112: Exercise 18-3
 * This program uses recursion to calculate the greatest common divisor for 2 integers provided by the user.
 * 
 * */
import java.util.Scanner;
public class GreatestCommonDivisor {

	public static void main(String[] args) {
		
		// Setup Scanner
		Scanner input = new Scanner(System.in);

		// Prompt user to input 2 integers
		System.out.print("Input first integer: ");
		int num1 = input.nextInt();
		System.out.print("Input second integer: ");
		int num2 = input.nextInt();
		
		// Close Scanner
		input.close();
		
		System.out.print("The greatest common divisor of " + num1 + " and " + num2 + " is: " + gcd(num1,num2));
	} // End Main
	
	
	/** gcd() calculates the greatest common divisor of two integers by using recursion*/
	public static int gcd(int m, int n) {
		
		if (m % n == 0) {
			return n;
		}
		else {
			return gcd(n, m % n);
		}
	}

}
