package edu.miracosta.cs113.lab15;

import java.util.*;

public class Graph<E> {
	
	private Map<E, List<E>> adjacencyList= new HashMap<>();
	
	public Graph(){

	}
	public void addVertex(E s){
		adjacencyList.put(s,new LinkedList<E>());
	}

	public void addEdge(E source, E dest){
		if (!adjacencyList.containsKey(source))
			addVertex(source);

		if (!adjacencyList.containsKey(dest))
			addVertex(dest);

		adjacencyList.get(source).add(dest);
		adjacencyList.get(dest).add(source);
	}		


	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();

		for (E v: adjacencyList.keySet()){
			builder.append(v.toString() + ": ");
			for ( E w : adjacencyList.get(v) ){
				builder.append(w.toString() + " ");
			}
			builder.append("\n");
		}
		return builder.toString();

	}

	public static void main(String[] args) {
		Graph<Integer> myGraph = new Graph<>();
		myGraph.addEdge(0,1);
		myGraph.addEdge(0,4);
		myGraph.addEdge(1,2);
		myGraph.addEdge(1,3);
		myGraph.addEdge(1,4);
		myGraph.addEdge(2,3);
		myGraph.addEdge(3,4);
		
		System.out.println("GRAPH:\n" +
				myGraph.toString());

	}


}
