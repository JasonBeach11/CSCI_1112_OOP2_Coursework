/*
 * Author: Jason Beach
 * Date: 03/15/2023
 * CSCI 1112 Exercise 17-3
 * This program creates a binary file named "Exercise17_3.dat". It writes 100 integers to the file separated by a space.
 * It then reads the integers back in and gets the sum of the numbers.
 * **/

import java.io.*;
import java.util.Random;

public class SumAllIntegers {

	public static void main(String[] args) throws IOException {

		// Call methods to create file and read file
		CreateFile();
		ReadFile();
		
	} // End Main
	
	/** CreateFile() creates a binary file named "Exercise17_3.dat" and writes 100 random integers to the file*/
	public static void CreateFile() throws IOException{
		Random rand = new Random();
		try (
				// Create an output stream to the file
				FileOutputStream output = new FileOutputStream("Exercise17_3.dat");
			){
				// Output values to the file
				for (int i = 0; i < 100; i++) {
					output.write(rand.nextInt(10));
				}
			}
	}
	
	/** ReadFile() reads an unspecified number if integers from a binary file named "Exercise17_3.dat", sums the numbers
	 * and outputs the sum to the console.*/
	public static void ReadFile() throws IOException{
		try (
				// Create an input stream for the file
				FileInputStream input = new FileInputStream("Exercise17_3.dat");
			){	
				// Read values from the file and get the sum
				int value=0;
				int sum=0;
				
				while((value = input.read()) != -1) {
					//System.out.print(value + " ");
					sum+=value;
				}
				// Output sum to console
				System.out.println("Sum of numbers: " + sum);
			}
	}
	
} // End SumAllIntegers Class
