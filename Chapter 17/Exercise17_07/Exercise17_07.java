/**
 * @author Jason Beach
 * @Date 3/20/2023
 * Exercise 17-07: This program creates a file named "Exercise17_07.dat" containing Loan objects. It then reads the Loan objects data
 * back in and displays the data to the console.
 */
import java.io.*;

public class Exercise17_07 {
	
	public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
      
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"))) {
        	
        	output.writeObject(loan1);
            output.writeObject(loan2); 
        } 
        
        catch (IOException ex) {
            System.out.println("File could not be opened ");
        }
        
        // Call outputData method
        outputData();
    }
    
    /** outputData method - Reads the Loan objects from file and displays the total loan amount to the console */
    public static void outputData() {
    	
    	try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"))){
    		
    			// Read Object data from file
    			Loan tempLoan1 = (Loan) input.readObject();
    			Loan tempLoan2 = (Loan) input.readObject();
    			System.out.println("Total Loan Amount for Loan #1: " + (tempLoan1.loanAmount));
    			System.out.println("Total Loan Amount for Loan #2: " + (tempLoan2.loanAmount));
    	}
    	
    	// Use EOFException to signal end of file
    	catch (Exception ex) {
			System.out.println("All data were read ");
		}
    	
    } // End outputData()
    
} // End Exercise17_07 Class
