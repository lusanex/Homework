package edu.miracosta.cs113.DSDoubleLinkedList2;
import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E>
{  

	// Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
  
	/**
	 * Add an item at position index.
	 * @param index The position at which the object is to be 
	 * 							inserted
	 * @param obj The object to be inserted
	 */
  	public void add(int index, E obj)
  	{ 
		listIterator(index).add(obj);
  	}
  	public void addFirst(E obj) { 
		add(0,obj);
	  
  	}
  	public void addLast(E obj) { 
		add(size(),obj);
  	}


  	public E getFirst() { 
		if ( head == null) {
			throw new NoSuchElementException();
		}
		return head.data;
	}
  	public E getLast() { 
  		if ( tail == null) {
  			throw new NoSuchElementException();
  		}
  		return tail.data;

  	}


	/**
	 * Get the element at position index
	 * @param index Position of the item to be retrieved
	 * @return The item at index
	 */
  	public E get(int index) 
  	{ 	
  		
  		try {

  			return listIterator(index).next();
  			
  		}
  		catch( NoSuchElementException e) {

  			throw new IndexOutOfBoundsException();
  			
  		}
  		
  	}  

  	@Override 
  	public void clear() {
  		for ( Node<E> x = head ; x != null;) {
  			Node<E> next = x.next;
  			x.data = null;
  			x.next = null;
  			x.prev = null;
  			x = next;
  		}
  		
  		head = tail = null;
  		size = 0;
  	}
 

  	public int size() {  return size;  } 

  	public E remove(int index)
  	{     
		E returnValue = null;
		ListIterator<E> iter = listIterator(index);
		if (iter.hasNext())
		{   returnValue = iter.next();
		    iter.remove();
		}
		else {   throw new IndexOutOfBoundsException();  }
		return returnValue;
  	}

  	public Iterator<E> iterator() { return new ListIter(0);  }

	public ListIterator<E> listIterator() { return new ListIter(0);  }

	public ListIterator<E> listIterator(int index){return new ListIter(index);}
	public ListIterator<E> listIterator(ListIterator<E> iter)
  	{     return new ListIter( (ListIter) iter);  }

  	// Inner Classes
  	private static class Node<E>
  	{     
		private E data;
		private Node<E> next = null;
		private Node<E> prev = null;

		private Node(E dataItem)  //constructor
        	{   data = dataItem;   }
  	}  // end class Node

  	public class ListIter implements ListIterator<E> 
  	{
		private Node<E> nextItem;      // the current node
		private Node<E> lastItemReturned;   // the previous node
		private int index = 0;   // 

	public ListIter(int i)  // constructor for ListIter class
    	{   
		
		

		if (  i < 0 || i > size)
		{     
			throw new IndexOutOfBoundsException("Invalid index " + i); 
		}
		lastItemReturned = null;
 
		if (i == size)     // Special case of last item
		{     
			
		      index = size;     
		      nextItem = null;      
		}
		else          // start at the beginning
        	{   
			nextItem = head;
			for (index = 0; index < i; index++)  nextItem = nextItem.next;   
		}  // end constructor
	}

    	public ListIter(ListIter other)
    	{   
		nextItem = other.nextItem;
		index = other.index;    
    	}

    	public boolean hasNext() {   
		return index < size;
    	} 

	public boolean hasPrevious()
    	{   
		return index > 0;
    	}
    	public int previousIndex() { 
	    return index-1;
    	} 
	public int nextIndex() {  
		return index;
	}
	public void set(E o)  { 
		if ( lastItemReturned == null ){
			throw new IllegalStateException();
		}
		lastItemReturned.data = o;
	}  

	public void remove() { 
		if ( lastItemReturned == null ){
			throw new IllegalStateException();
		}
		if ( lastItemReturned == head ){
			head = head.next;
			head.prev = null;
		}
		else if ( lastItemReturned == tail ){
			tail.prev.next = null;	
			tail = tail.prev;
		}
		else {
			Node<E> temp = lastItemReturned;
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			temp.next = null;
			temp.prev = null;

		}
		size--;
		lastItemReturned = null;


	}      

	public E next()
	{  
		if ( !hasNext() ){
			throw new NoSuchElementException();
		}

		lastItemReturned = nextItem;
		nextItem = nextItem.next;

		index++;
		return lastItemReturned.data;
    	}

    	public E previous() 
	{
		if ( !hasPrevious() ){
			throw new NoSuchElementException();
		}
		if (nextItem == null){
			nextItem = tail;
		}
		else{
			nextItem = nextItem.prev;
		}
		lastItemReturned = nextItem;
		index--;
		return lastItemReturned.data;
	
	}

    	public void add(E obj) {
		if ( head == null ){

			head = new Node<E>(obj);
			tail = head;
		}
		else if ( nextItem == null ) {
			Node<E> newNode= new Node<E>(obj);
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		else if ( nextItem == head) {
			Node<E> newNode = new Node<E>(obj);
			newNode.next = nextItem;
			nextItem.prev = newNode;
			head = newNode;
			
			
			
		}
	
		else {
			Node<E> newNode = new Node<E>(obj);
			newNode.prev = nextItem.prev;
			nextItem.prev.next = newNode;
			newNode.next = nextItem;
			nextItem.prev = newNode;

		}
		size++;
		index++;
		lastItemReturned = null;

	
    	}
  }// end of inner class ListIter
  	
}// end of class DoubleLinkedList
