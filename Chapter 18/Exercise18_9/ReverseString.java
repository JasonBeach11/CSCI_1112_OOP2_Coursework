/**
 * @author Jason Beach
 * Date: 3/23/2023
 * CSCI 1112 Exercise 18-9
 * This program uses a recursive method to display a string reversely on the console.
 * 
 * */
import java.util.Scanner;
public class ReverseString {

	public static void main(String[] args) {
		
		// Setup Scanner
		Scanner input = new Scanner(System.in);
		
		// Prompt user to input a string
		System.out.print("Input a string to be displayed in reverse: ");
		String string = input.nextLine();

		reverseDisplay(string);
	} // End Main

	
	/** reverseDisplay() reverses a string using recursion and displays the reversed string to the console*/
	public static void reverseDisplay(String str) {
		
		if ((str == null) || (str.length() <= 1)){
			System.out.println(str);
		}
		else {
			System.out.print(str.charAt(str.length()-1));
			reverseDisplay(str.substring(0, str.length()-1));
		}
	}
}
