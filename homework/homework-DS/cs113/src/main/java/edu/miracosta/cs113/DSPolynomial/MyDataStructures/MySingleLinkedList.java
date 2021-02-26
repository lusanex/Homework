package edu.miracosta.cs113.DSPolynomial.MyDataStructures;

public class MySingleLinkedList<E>{

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	


	//COnstructor creates an empty list
	public MySingleLinkedList(){
	}

	

	/**
	 * Add an item to the front of the list.
	 * @param item The item to be added
	 */
	public void addFirst(E item){
		head = new Node<E>(item,head);
		tail = getNode(size);


		size++;
	}

	public E getLast(){
		return tail.data;
	}


	/**
	 * Appends the specified element to the end of this list
	 * @param e The element to add
	 */
	public void addLast(E item){
		Node<E> temp = new Node<E>(item);
		tail.next = temp;
		tail = temp;
	}

	/**
	 * Find the node at a specific position
	 * @param index The position of the node sought
	 * @return The node at index or null if it does not exist
	 */
	private Node<E> getNode(int index){
		Node<E> node = head;
		for ( int i = 0; i < index && node != null; i++ ){
			node = node.next;
		}
		return node;
	}
	/**
	 * @return Get the data value at index
	 * @param index The position of the elemnt to return
	 * @return The data at index
	 *
	 */

	public E get (int index){
		if ( index < 0 || index >= size ){
			throw new IndexOutOfBoundsException(
					Integer.toString(index));

		}
		Node<E> node = getNode(index);
		return node.data;
	}


	/**
	 * Add a node after a given node
	 * @param node The node preceding the new item
	 * @param item THe item to insert
	 *
	 */
	private void addAfter(Node<E> node, E item){
		node.next = new Node<E>(item,node.next);
		size++;
	}

	/**
	 * Remove the node after a given node 
	 * @param node The node before the one to be removed
	 * @return The data from the remover node, or null 
	 * 	   if there is no node to remove
	 */
	private E removeAfter(Node<E> node){
		Node<E> temp = node.next;
		if ( temp != null ){
			node.next = temp.next;
			size--;
			return temp.data;
		}
		else {
			return null;
		}
	}

	/**
	 * Set the data value at index
	 * @param index The position of the item to change
	 * @param newValue The new Value
	 */
	public E set(int index, E newValue){
		if ( index< 0 || index >= size ){
			throw new IndexOutOfBoundsException(
					Integer.toString(index));
		}
		Node<E> node = getNode(index);
		E result = node.data;
		node.data = newValue;
		return result;

	}

	/**
	 * Insert the specified item at index
	 * @param index The position where item is to be inserted
	 * @param item The item to be inserted
	 */
	public void add(int index, E item){
		if ( index < 0 || index >= size ){
			throw new IndexOutOfBoundsException(
					Integer.toString(index));
		}
		if ( index == 0 ){
			addFirst(item);
		}
		else {
			Node<E> node = getNode(index-1);
			addAfter(node,item);
		}
	}

	/**
	 * Remove the first node from the list
	 * @return The removed node's data or null if the list is empty
	 */
	private E removeFirst(){
		Node<E> temp = head;
		if ( head != null ){
			head = head.next;
		}
		if ( temp != null ){
			size--;
			return temp.data;
		}
		else{
			return null;
		}
	}

	/**
	 */


	@Override
	public String toString() {
		Node<E> nodeRef = head;
		StringBuilder result = new StringBuilder();
		while (nodeRef != null){
			result.append(nodeRef.data);
			if ( nodeRef.next != null ){
				result.append(" ==> ");
			}
			nodeRef = nodeRef.next; // Advance down the list.
		}
		return result.toString();

	}

	


	private static class Node<E> {
		private E data;
		private Node<E> next;

		private Node ( E dataItem ) {
			data = dataItem;
			next = null;
		}

		private Node ( E dataItem, Node<E> nodeRef ) {
			data = dataItem;
			next = nodeRef;
		}
	}
	


}
