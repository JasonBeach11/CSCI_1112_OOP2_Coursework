/**
 * @author Jason Beach
 * Date: 3/28/23
 * CSCI 1112: Exercise 19-3
 * This program returns a new ArrayList without duplicates.
 * */
import java.util.ArrayList;

public class Exercise19_03 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }
  
  
  /** Remove duplicates from an ArrayList */
  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
	  
	  // Create a new list to store non-duplicate elements to
	  ArrayList<E> newList = new ArrayList<E>();
	  
	  // Iterate through first list
	  for (E element : list) {
		 
		  // If element is not in newList, add it
		  if (newList.contains(element) == false) {
			  newList.add(element);
		  }
	  }
	  
	  return newList;
  }
}
