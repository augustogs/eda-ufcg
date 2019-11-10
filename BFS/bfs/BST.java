package bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] seq = toIntArray(sc.nextLine().split(" "));
		BST bst = new BST();
		montaBST(seq, bst);
		
		bst.bfsDireita();
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
			bst.add(seq[i]);
		}
	}
}

class BST {
	
	private Node root;
	
	public BST() {	
	}
	
	public void bfsDireita() {
		if (!this.isEmpty()) {
			Deque<Node> fila = new LinkedList<Node>();
			fila.addLast(this.root);
			
			String result = "";
			while (!fila.isEmpty()) {
				Node aux = fila.remove();
				result += aux.value + " ";
				if (aux.right != null) {
					fila.addLast(aux.right);
				}
				if (aux.left != null) {
					fila.addLast(aux.left);
				}
			}
			System.out.println(result.trim());
		}
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void add(int value) {
		if (isEmpty()) {
			this.root = new Node(value);
		} else {
			this.add(value, this.root);
		}
	}
	
	private void add(int value, Node node) {
		if (value < node.value) {
			if (node.left == null) {
				node.left = new Node(value);
			} else {
				add(value, node.left);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(value);
			} else {
				add(value, node.right);
			}
		}
	}
	
}

class Node {
	
	protected int value;
	protected Node left;
	protected Node right;
	
	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
}
