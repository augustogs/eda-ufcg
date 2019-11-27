package predecessor;

import java.util.Scanner;
import java.util.ArrayList;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] seq = toIntArray(sc.nextLine().split(" "));
		int value = sc.nextInt();
		
		BST bst = new BST();
		montaBST(seq, bst);

		bst.predecessor(value);
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
	
	public void predecessor(int value) {
		ArrayList<Integer> array = new ArrayList<>();
		
		Node node = this.search(value);
		if (!node.isEmpty()) {
			array.add(node.getValue());
			// Se o node tiver uma esquerda, entao pegamos o maior valor da esquerda.
			if (!node.getLeft().isEmpty()) {
				this.maximo(node.getLeft(), array);	
				// Se nao tiver esquerda, entao subiremos do node ate no maximo a raiz. Se encontrarmos um valor no pai que seja menor que ele, encontramos o predecessor.
			} else {
				Node aux = node.getParent();
				
				boolean achou = false;
				while (aux != null && !achou) {
					array.add(aux.getValue());
					if (aux.getValue() < node.getValue()) {
						achou = true;
					}
					aux = aux.getParent();	
				}
			}					
		}
		System.out.println(array);
	}
	
	private void maximo(Node node, ArrayList<Integer> array) {
		if (!node.isEmpty()) {
			if (node.getRight().isEmpty()) {
				array.add(node.getValue());
			} else {
				array.add(node.getValue());
				this.maximo(node.getRight(), array);
			}
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
			this.insert(value, node.getLeft());
		}
	}
	
	private Node search(int value) {
		return this.search(value, this.root);
	}

	private Node search(int value, Node node) {
		Node result = new Node(null);
		if (!node.isEmpty()) {
			if (value == node.getValue()) {
				result = node;
			}
			else if (value > node.getValue()) {
				result = this.search(value, node.getRight());
			}
			else if (value < node.getValue()) {
				result = this.search(value, node.getLeft());
			}
		}
		return result;
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