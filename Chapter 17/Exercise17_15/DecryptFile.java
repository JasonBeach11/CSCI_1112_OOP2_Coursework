/**
 * @author Jason Beach
 * Date: 3/21/2023
 * 
 * CSCI 1112 Exercise 17_15 Decrypt Files: This program prompts the user to enter an input and output file name
 * and saves the decrypted version of the input file to the output file. The program uses the encryption scheme
 * from Exercise 17_14 and decrypts the file by subtracting 5 from every byte in the file.
 * */

import java.util.Scanner;
import java.io.*;

public class DecryptFile {

	public static void main(String[] args) throws Exception{
		
		// Prompt user to enter an input file name
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an input file name you want decrypted: ");
		String inputFileName = input.next();
		
		// Create FileInputStream for user's input file name
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(inputFileName)));
		
		// Prompt user to enter an output file name
		System.out.print("Enter an output file name you want to save the decrypted file to: ");
		String outputFileName = input.next();
		
		// Create FileOutputStream for file output name
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(outputFileName)));
		
		// Decode the file by subtracting 5 from every byte in the file
		int decryptValue;
		while ((decryptValue = in.read()) != -1) {
			output.write(decryptValue - 5);
		}
		
		input.close();
		output.close();
	}

}
