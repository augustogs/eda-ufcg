package maioresbst;

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
		bst.qntdMaiores(n);
		
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

	public void qntdMaiores(int n) {
		int result = qntdMaiores(n, this.root);
		System.out.println(result);
	}
	
	private int qntdMaiores(int n, Node node) {
		int result = 0;
		if (node != null) {
			if (node.value > n) {
				result += 1;
			}
			result += qntdMaiores(n, node.left);
			result += qntdMaiores(n, node.right);
		}
		return result;
	}

	public void preOrder() {
		ArrayList<Integer> array = new ArrayList<>();
		preOrder(this.root, array);
		System.out.println(array);
	}

	private void preOrder(Node node, ArrayList<Integer> array) {
		if (node != null) {
			array.add(node.value);
			preOrder(node.left, array);
			preOrder(node.right, array);
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
