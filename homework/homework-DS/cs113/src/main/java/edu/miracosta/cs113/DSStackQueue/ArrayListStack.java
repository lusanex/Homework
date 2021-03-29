package edu.miracosta.cs113.DSStackQueue;

import java.util.ArrayList; 
import java.util.List;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E>{


	private List<E> theStack; 

	public ArrayListStack(int capacity){
		if ( capacity < 0){
			throw new IllegalArgumentException("Illegal Capacity: "+capacity);
		}
		theStack = new ArrayList<>(capacity);
	}

	public ArrayListStack(){
		theStack = new ArrayList<>();
	}

	@Override
	public boolean empty(){
		return theStack.isEmpty();
	} 

	@Override
	public E peek(){
		if ( empty() ){
			throw new EmptyStackException();
		}
		return theStack.get(theStack.size()-1);
	}

	@Override
	public E pop(){
		if ( empty() ){
			throw new EmptyStackException();
		}
		return theStack.remove(theStack.size()-1);
	}

	@Override
	public E push(E obj){
		theStack.add(obj);
		return obj;
	}


}
