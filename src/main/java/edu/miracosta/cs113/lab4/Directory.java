package edu.miracosta.cs113.lab4;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import edu.miracosta.cs113.lab4.model.*; 

public class Directory{

	

	//PROGRAMMING EXERCISES 1&2 SECTION 2.2
	//
	

	private List<DirectoryEntry> theDirectory = new ArrayList<>();

	public Directory(ArrayList<DirectoryEntry> list){
		if ( list == null ){
			throw new NullPointerException();
		}
		theDirectory = list;
	}

	/** Add an entry to the Directory or change an existing entry
	 * @param aName The name of the person being added or changed
	 * @param newNumber The new number to be assigned
	 * @return The old number, or if a new entry, null
	 *
	 **/


	public String addOrChangeEntry(String aName, String newNumber){
		if ( aName == null || newNumber == null){
			throw new NullPointerException();
		}
		if ( aName.equals("") | newNumber.equals("") ){
			throw new IllegalArgumentException("Empty string");
		}
	
		DirectoryEntry oldEntry =null;
		for ( int i = 0 ; i < theDirectory.size(); i++ ){
			if ( theDirectory.get(i)
					 .getName()
					 .equals(aName)) {
				oldEntry = theDirectory.get(i);
				oldEntry.setName(aName);
				oldEntry.setNumber(newNumber);
				theDirectory.set(i,oldEntry);
				break;
			
			}
		}
		if ( oldEntry == null ){
			theDirectory.add(new DirectoryEntry(aName,newNumber));
			return null;
		}
		else{
			return oldEntry.getNumber();
		}

	}


	/** Remove an Entry
	 * @param aName THe name of the person being removed
	 * @return The entry removed, or null if there is no entry for aName
	 */
	public DirectoryEntry removeEntry(String aName){
		DirectoryEntry oldEntry =null;
		for ( int i =0 ; i < theDirectory.size(); i++ ){
			if ( theDirectory.get(i)
			  		 .getName()
					 .equals(aName) ){

				oldEntry = theDirectory.get(i);
				theDirectory.remove(i);
				break;
				
			}
		}
		return oldEntry;
	}

	@Override
	public String toString(){
		return theDirectory.toString();
	}

	
	public String getContact(int index) {
		if ( index < 0 || index >= theDirectory.size()) {
			throw new NullPointerException("getContact null "+theDirectory.size()+ " actual " +index);
		}
		return theDirectory.get(index).toString();
	}

	public static void main(String[] args){
		ArrayList<DirectoryEntry> theDirectory = new ArrayList<>(
							            Arrays.asList(
									    new DirectoryEntry("Erich","12345"),
									    new DirectoryEntry("John 777","4325"),
									    new DirectoryEntry("Zelda","34567"),
									    new DirectoryEntry("Link","23456"),
									    new DirectoryEntry("Mario","23232"),
									    new DirectoryEntry("Luigui","345455")
									          )
								    );
		Directory direc = new Directory(theDirectory);

		System.out.println("ADD OR CHANGE AN ENTRY\n");
		System.out.println("Before add or change a new Entry : " + direc);
		System.out.println("addOrChangeEntry( zelda , \"77777\")");
		direc.addOrChangeEntry("Zelda","77777");
		System.out.println("After add or change a new Entry : " + direc);
		System.out.println("\nREMOVE AN ENTRY\n");
		System.out.println("Before remove an entry: "+ direc);
		System.out.println("removeEntry(mario)");
		direc.removeEntry("Mario");
		System.out.println("After remove an entry: "+ direc);

		

	

		


	}

}
