package contanos;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] seq = toIntArray(sc.nextLine().split(" "));
		
		BST bst = new BST();
		montaBST(seq, bst);

		System.out.println(bst.qntdNosInternos());
		sc.close();
	}

	private static int[] toIntArray(String[] array) {
		int[] aux = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			aux[i] = Integer.parseInt(array[i]);
		}
		return aux;
	}

	private static void montaBST(int[] seq, BST bst) {
		for (int i = 0; i < seq.length; i++) {
			bst.insert(seq[i]);
		}
	}
}

class BST {

	private Node root;

	public BST() {
		this.root = new Node(null);
	}
	

	public int qntdNosInternos() {
		return qntdNosInternos(this.root);
				
	}

	private int qntdNosInternos(Node node) {
		int result = 0;
		if (!node.isEmpty()) {
			if (node.hasChild()) {
				result = 1 + qntdNosInternos(node.getLeft()) + qntdNosInternos(node.getRight());
			}
		}	
		return result;
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public void insert(int value) {
		this.insert(value, this.root);
	}

	private void insert(int value, Node node) {
		if (node.isEmpty()) {
			node.setValue(value);
			node.setLeft(new Node(null));
			node.getLeft().setParent(node);
			node.setRight(new Node(null));
			node.getRight().setParent(node);
		} 
		else if (value > node.getValue()) {
			this.insert(value, node.getRight());
		}
		else if (value < node.getValue()) {
			this.insert(value, node.getLeft());
		}
	}

}

class Node {

	private Integer value;
	private Node parent;
	private Node left;
	private Node right;

	public Node(Integer value) {
		this.value = value;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
	
	public Integer getValue() {
		return value;
	}

	public boolean isEmpty() {
		return this.value == null;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public void setLeft(Node node) {
		this.left = node;
	}
	
	public void setRight(Node node) {
		this.right = node;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public void setParent(Node node) {
		this.parent = node;
	}
	
	public boolean hasChild() {
		return (!this.left.isEmpty() || !this.right.isEmpty());
	}
}
