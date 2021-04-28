package edu.miracosta.cs113.DSMorseCodeTree;
import java.io.Serializable;
import java.util.Scanner;

public class BinaryTree<E> implements Serializable {

	//Data field
	protected Node<E> root;

	//COnstructors
	public BinaryTree(){
		root = null;
	}

	protected BinaryTree(Node<E> root){
		this.root = root;

	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree,
			BinaryTree<E> rightTree){

		root = new Node<E>(data);
		if (leftTree != null ){
			root.left = leftTree.root;
		}
		else {
			root.left = null;
		}
		if (rightTree != null){
			root.right = rightTree.root;
		}
		else{
			root.right = null;
		}

	}

	//Methods
	public BinaryTree<E> getLeftSubtree(){
		if (root != null && root.left != null){
			return new BinaryTree<E>(root.left);
		}
		else {
			return null;
		}
	}

	public BinaryTree<E> getRightSubtree(){
		if ( root != null && root.right != null ){
			return new BinaryTree<E>(root.right);
		}
		else {
			return null;
		}
	}
	public E getData(){
		return root.data;

	}
	public boolean isLeaf(){
		return (root.left == null && root.right == null);

	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root,1,sb);
		return sb.toString();
	}

	private void preOrderTraverse(Node<E> node, int depth,
			StringBuilder sb){
		for ( int i = 1 ; i < depth; i++ ){
			sb.append(" ");
		}
		if (node == null){
			sb.append("null\n");
		}else{
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraverse(node.left,depth+1,sb);
			preOrderTraverse(node.right,depth +1,sb);
		}

	}
	public static BinaryTree<String> readBinaryTree(Scanner scan){

		String data = scan.next();
		if ( data.equals("null") ){
			return null;
		}
		else{
			BinaryTree<String> leftTree = readBinaryTree(scan);
			BinaryTree<String> rigthTree = readBinaryTree(scan);
			return new BinaryTree<String>(data,leftTree,rigthTree);
		}
	}


    @Override
    public boolean equals(Object anObject) {
        if (!(anObject instanceof BinaryTree)) {
            return false ;
        }
        BinaryTree anotherTerm = (BinaryTree) anObject ;
        return ( (getRightSubtree() == (anotherTerm.getLeftSubtree()) )&&
                (getRightSubtree() == anotherTerm.getRightSubtree()) ) ;
    }
	protected static class Node<E> implements Serializable {
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
		
		public Node() {
			this.data = null;
			this.left = null;
			this.right = null;
		}

		public Node(E data){
			this.data = data;
			left = null;
			right = null;

		}

		public String toString(){
			return data.toString();
		} 
		public Node<E> getLeft(){
			return left;
		}
		public Node<E> getRiht(){
			return right;
		}
		public E getData() {
			return data;
		}
        public void setRight(Node<E> node) {
            this.right = node ;
        }

       
        public void setData(E data) {
            this.data = data ;
        }

    
        public void setLeft(Node<E> node) {
            this.left = node ;
        }
	}
	
	


}
