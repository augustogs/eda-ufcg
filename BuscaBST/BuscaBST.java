import java.util.ArrayList;
import java.util.Scanner;

class MainBST {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] seq = toIntArray(sc.nextLine().split(" "));
		BuscaBST bst = new BuscaBST();
		montaBST(seq, bst);
		
		int valor = sc.nextInt();		
		bst.search(valor);
		
		sc.close();
	}
	
	private static int[] toIntArray(String[] array) {
		int[] aux = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			aux[i] = Integer.parseInt(array[i]);
		}
		return aux;	
	}
	
	private static void montaBST(int[] seq, BuscaBST bst) {
		for (int i = 0; i < seq.length; i++) {
			bst.add(seq[i]);
		}
	}
}

class BuscaBST {
	
	private NodeBST root;
	
	public BuscaBST() {		
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
	
	public void search(int value) {
		if (!isEmpty()) {
			if (value == this.root.value) {
				System.out.println("[" + value + "]");
			} else {
				ArrayList<Integer> array = new ArrayList<>();
				search(value, this.root, array);			
			}			
		}
	}

	private void search(int value, NodeBST node, ArrayList<Integer> array) {
		if (node != null) {
			if (value < node.value) {
				array.add(node.value);	
				search(value, node.left, array);
			}
			else if (value > node.value) {
				array.add(node.value);
				search(value, node.right, array);
			} else {
				array.add(value);
				System.out.println(array);
			}			
		} else {
			System.out.println(array);			
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


