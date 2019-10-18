package alturabst;

import java.util.Scanner;

class MainBST {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] seq = toIntArray(sc.nextLine().split(" "));
		AlturaBST bst = new AlturaBST();
		montaBST(seq, bst);
		
		System.out.println(bst.altura());		
		
		sc.close();
	}
	
	private static int[] toIntArray(String[] array) {
		int[] aux = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			aux[i] = Integer.parseInt(array[i]);
		}
		return aux;	
	}
	
	private static void montaBST(int[] seq, AlturaBST bst) {
		for (int i = 0; i < seq.length; i++) {
			bst.add(seq[i]);
		}
	}
}

class AlturaBST {
	
	private NodeBST root;
	
	public AlturaBST() {		
	}
	
	public int altura() {
		return altura(this.root);
	}
	
	private int altura(NodeBST node) {
		int result = -1;
		if (node != null) {
			result = 1 + Math.max(altura(node.left), altura(node.right));
		}
		return result;		
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
