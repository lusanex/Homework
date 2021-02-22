package edu.miracosta.cs113.lab4;

import java.util.ArrayList;
import java.util.Arrays;

public class Lab4{


	//EXERCISES 1&2 SECTION 2.1 
	

	/** Replaces each occurrence of oldItem in aList with newItem **/
	public static void replace(ArrayList<String> aList, String oldItem,
			           String newItem){

		if ( aList == null || oldItem == null | newItem == null ){
			
			throw new NullPointerException();
		}
		if ( oldItem.equals("") || newItem.equals("") ){
			throw  new IllegalArgumentException("Empty String");
		}

		for ( int i = 0 ; i < aList.size() ; i++ ){
			if ( aList.get(i).toLowerCase().
					  equals(oldItem.toLowerCase()) ){
				aList.set(i,newItem);
			}
		}
		

	}
	/**Deletes the first occurence of target in aList */

	public static void delete(ArrayList<String> aList, String target){

		if ( aList == null || target ==null ){
			throw new NullPointerException();
		}
		
		for ( int i = 0 ; i < aList.size(); i++ ){
			if ( aList.get(i)
					  .toLowerCase()
					  .equals(target.toLowerCase()) ){
				aList.remove(i);
				return;
			}
		}

	}
	public static void main(String[] args){

		ArrayList<String> aList = new ArrayList<>(Arrays.asList("apple","banana","orange",
									"kiwi","apple","banana",
									"lettuce"));
		System.out.println(" REPLACE METHOD\n");
		System.out.println("List before replace method : " + aList);
		System.out.println("replace(apple,Pine Apple)");
		replace(aList,"apple","Pine Apple");
		System.out.println("List after replace method: "+aList);
		System.out.println("");
		System.out.println(" DELETE METHOD\n");
		System.out.println("List before delete method: "+aList);
		System.out.println("delete : Lettuce ");
		delete(aList,"Lettuce");
		System.out.println("List after delete method: "+aList);
	}


	


}
