package valormaisproximo;

import java.util.ArrayList;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] seq = toIntArray(sc.nextLine().split(" "));
		int n = sc.nextInt();
		BST bst = new BST();
		montaBST(seq, bst);

		bst.preOrder();
		bst.valorMaisProximo(n);
		
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

	public void valorMaisProximo(int n) {
		int result = -1;
		
		// representa a diferenca entre o valor do no e o n procurado, quanto mais proxima de 0 mais proximo estamos do no. 
		int distAtual = Integer.MAX_VALUE;	
				
		boolean achou = false;
		Node aux = this.root;
		while (!aux.isEmpty() && !achou) {
			if (n == aux.getValue()) {
				result = n;
				achou = true;
			} else {
				int distNode  = Math.abs(aux.getValue() - n);
				if (distNode < distAtual) {
					distAtual = distNode;
					result = aux.getValue();
				}
				else if (n > aux.getValue()) {
					aux = aux.getRight();
				}
				else {
					aux = aux.getLeft();
				}				
			}
		}
		System.out.println(result);
	}

	public void preOrder() {
		ArrayList<Integer> array = new ArrayList<>();
		preOrder(this.root, array);
		System.out.println(array);
	}

	private void preOrder(Node node, ArrayList<Integer> array) {
		if (!node.isEmpty()) {
			array.add(node.getValue());
			preOrder(node.getLeft(), array);
			preOrder(node.getRight(), array);
		}
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
			insert(value, node.getLeft());
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
}
