/**
 * Author: Jason Beach
 * Date: 3/15/2023
 * CSCI 1112 Exercise 17-1
 * This program creates a text file called "Exercise17_01.txt" and writes 100 random integers to the file using text I/O.
 * */
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class CreateTextFile {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Create output file
		PrintWriter output = new PrintWriter("Exercise17_01.txt");
		output.print("Jason Beach\n03/15/2023\nExercise 17-1\n");
		
		// Output random numbers to txt file
		Random rand = new Random();
		
		for (int i = 0; i < 100; i++) {
			output.print(rand.nextInt(100) + " ");
		}
		output.close();
	}

}
