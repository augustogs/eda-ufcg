package bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class MainBST {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] seq = toIntArray(sc.nextLine().split(" "));
		BFS bst = new BFS();
		montaBST(seq, bst);
		
		bst.bfs();
		
		sc.close();
	}
	
	private static int[] toIntArray(String[] array) {
		int[] aux = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			aux[i] = Integer.parseInt(array[i]);
		}
		return aux;	
	}
	
	private static void montaBST(int[] seq, BFS bst) {
		for (int i = 0; i < seq.length; i++) {
			bst.add(seq[i]);
		}
	}
}

class BFS {
	
	private NodeBST root;
	
	public BFS() {	
	}
	
	public void bfs() {
		if (!this.isEmpty()) {
			Deque<NodeBST> fila = new LinkedList<NodeBST>();
			fila.addLast(this.root);
			
			String result = "";
			while (!fila.isEmpty()) {
				NodeBST aux = fila.remove();
				result += aux.value + " ";
				if (aux.left != null) {
					fila.addLast(aux.left);
				}
				if (aux.right != null) {
					fila.addLast(aux.right);
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
			this.root = new NodeBST(value);
		} else {
			this.add(value, this.root);
		}
	}
	
	private void add(int value, NodeBST node) {
		if (value < node.value) {
			if (node.left == null) {
				node.left = new NodeBST(value);
			} else {
				add(value, node.left);
			}
		} else {
			if (node.right == null) {
				node.right = new NodeBST(value);
			} else {
				add(value, node.right);
			}
		}
	}
	
}

class NodeBST {
	
	protected int value;
	protected NodeBST left;
	protected NodeBST right;
	
	public NodeBST(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
}
