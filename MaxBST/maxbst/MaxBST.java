package maxbst;

import java.util.Scanner;

class MainBST {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] seq = toIntArray(sc.nextLine().split(" "));
		MaxBST bst = new MaxBST();
		montaBST(seq, bst);
		
		bst.max();
		
		sc.close();
	}
	
	private static int[] toIntArray(String[] array) {
		int[] aux = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			aux[i] = Integer.parseInt(array[i]);
		}
		return aux;	
	}
	
	private static void montaBST(int[] seq, MaxBST bst) {
		for (int i = 0; i < seq.length; i++) {
			bst.add(seq[i]);
		}
	}
}

public class MaxBST {
	
	private NodeBST root;
	
	public MaxBST() {	
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void max() {
		max(this.root, "");
	}

	private void max(NodeBST node, String result) {
		if (node != null) {
			result += node.value + " ";
			max(node.right, result);
		} else {
			System.out.println(result.trim());
		}
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


