
package edu.miracosta.cs113.DSPolynomial.MyDataStructures;


/**
 * This class implements some of the methods od the Java ArrayList class.
 */
public class MyArrayList<E> {

	//Data fields
	/** The default initial capacity */
	private static final int INITIAL_CAPACITY = 10;
	
	//The array access type defaul for inner classes;
	E[] theData;

	// The current size

	private int size = 0 ;

	// The current capacity
	private int capacity = 0;

	@SuppressWarnings("unchecked")
	public MyArrayList() {
		capacity = INITIAL_CAPACITY;
		theData = (E[]) new Object[capacity];
	}



	/** 
	 * add method appends an item to the end of MyArrayList
	 * @param E anEntry the item to add to the array
	 * @return true on successful insertion
	 *
	 */
	public boolean add(E anEntry) {
		if ( size == capacity ) {
			reallocate();
		}
		theData[size] = anEntry;
		size++;
		return true;
	}

	public void reallocate(){

	}
	
	/**
	 * add inserts an item into the middle of the array ( anywhere )
	 * the values at the insertion point and beyond must be shifted over to 
	 * make room.
	 * @param  int index is the position where the new item will be inserted
	 * @param E entry is the data to store at that index
	 * @return none
	 */
	
	public void add(int index, E anEntry){
		if ( index < 0 || index > size )
			throw new ArrayIndexOutOfBoundsException(index);
		if ( size == capacity ){
			reallocate();
		}

		for ( int i =  size ; i > index ; i++  ){
			theData[i] = theData[i -1];
		}
		theData[index] = anEntry;
		size++;
	}


	/**
	 * Method get returns the item at the specified index
	 * @param int index the location of the item
	 * @return E the object at the location index
	 */

	public E get( int index ){
		if ( index < 0 || index >= size )
			throw new ArrayIndexOutOfBoundsException(index);

		return theData[index];
	}

	/**
	 * Sets an object at location given by index
	 * @param int index is the location to add the new object into the array
	 * @param E anEntry is the object to set.
	 * @return E returns the old object stored at location index.
	 */
	public E set( int index, E anEntry ){
		if (index < 0 || index >= size){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E oldValue =theData[index];
		theData[index] = anEntry;
		return oldValue;

	
	}

	/** returns the current size of the MyArrayList */

	public int size(){
		return size;
	}



	public int indexOf(E target){

		if ( target == null ){
			throw new NullPointerException();
		}

		for ( int i = 0 ; i < size; i++ ){
			if ( theData[i].equals(target) )
				return i;
		}
		return -1;
		
	}

	/**
	 * Removes an item , The items that follow it mus be moved foward
	 * to close up the gaps.
	 * @param int index location of the object to remove
	 * @return the old item stored at location index
	 */

	public E remove(int index){
		if ( index < 0 || index >= size ){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E returnValue = theData[index];
		for ( int i = index + 1; i < size; i++ ){
			theData[i -1] = theData[i];
		}
		size--;
		return returnValue;
	}

}
