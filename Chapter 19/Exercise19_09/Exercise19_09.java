/*
Author: Jason Beach
Date:  03/29/2023
CSCI 1112: Exercise 19_09
This program sorts an ArrayList in ascending order
*/
import java.util.ArrayList;

public class Exercise19_09 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    // Additional numbers added to list to make list more substantial
    list.add(90);
    list.add(27);
    list.add(32);
    list.add(5);
    list.add(8);
    list.add(0);
    list.add(101);
    
    Exercise19_09.<Integer>sort(list);
    
    System.out.print(list);
  }
  
  /** Sort an ArrayList in ascending order */
  public static <E extends Comparable<E>> void sort (ArrayList<E> list) {
	  
	  for (int i = 0; i < list.size(); i++) {
		  
		  for (int j = list.size() -1; j > i; j--) {
			
			  if (list.get(i).compareTo(list.get(j)) > 0) {
				  
				  E tmp = list.get(i);
		          list.set(i, list.get(j));
		          list.set(j, tmp);
			  }
		  }
	  }

  } // End sort
  
}
