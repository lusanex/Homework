package edu.miracosta.cs113.DSStackQueue;

import java.util.Queue;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArrayQueue<E> implements Queue<E>
{
	private int front;
	private int rear;
	private int size;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10;
	private E[] theData;

	public CircularArrayQueue(){
		this(DEFAULT_CAPACITY);
	}

	@Override 
	public boolean add(E e){
		try {
			offer(e);
			return true;
		}
		catch(Exception ex){
			throw new IllegalStateException();
		}
	}

	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int initCapacity){
		capacity = initCapacity;
		theData = (E[]) new Object[capacity];
		front = 0;
		rear = capacity -1;
		size = 0;

	}

	@Override
	public boolean offer(E item){
		if ( size == capacity ){
			reallocate();
		}

		size++;
		rear = (rear + 1) % capacity;
		theData[rear] = item;
		return true;
	}

	@Override
	public E element(){
		E e = peek();
		if ( e == null ){
			throw new NoSuchElementException();
		}
		return e;
	}

	@Override
	public E peek() {
		if ( size == 0 ){
			return null;
		}
		else{
			return theData[front];
		}
	}

	@Override
	public E poll() {
		if ( size == 0 ){
			return null;
		}
		E result = theData[front];
		front = (front + 1) % capacity;
		size--;
		return result;
	}

	@Override 
	public E remove(){
		E e = poll();
		if ( e == null )
			throw new NoSuchElementException();
		return e;
	}

	@SuppressWarnings("unchecked")
	private void reallocate(){
		int newCapacity = 2 * capacity;
		E[] newData = (E[]) new Object[newCapacity];
		int j = front;
		for ( int i = 0 ; i< size; i++ ){
			newData[i] = theData[j];
			j = ( j+ 1 ) % capacity;
		}
		front = 0;
		rear = size -1;
		capacity = newCapacity;
		theData = newData;
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
