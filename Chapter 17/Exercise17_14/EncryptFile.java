/**
 * @author Jason Beach
 * Date: 3/21/2023
 * 
 * CSCI 1112 Exercise 17_14 Encrypt Files: This program prompts the user to enter an input and output file name
 * and saves the encrypted version of the input file to the output file. The file is encrypted by adding 5 to 
 * every byte in the file.
 * */

import java.util.Scanner;
import java.io.*;

public class EncryptFile {

	public static void main(String[] args) throws Exception{
		
		// Prompt user to enter an input file name
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an input file name: ");
		String inputFileName = input.next();
		
		// Create FileInputStream for user's input file name
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(inputFileName)));
		
		// Prompt user to enter an output file name
		System.out.print("Enter an output file name: ");
		String outputFileName = input.next();
		
		// Create FileOutputStream for file output name
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(outputFileName)));
		
		// Encode the file by adding 5 to every byte in the file
		int encryptValue;
		while ((encryptValue = in.read()) != -1) {
			output.write(encryptValue + 5);
		}
		
		input.close();
		output.close();
	}

}
