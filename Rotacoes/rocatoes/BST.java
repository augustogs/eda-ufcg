package rocatoes;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] seq = toIntArray(sc.nextLine().split(" "));
		BST bst = new BST();
		montaBST(seq, bst);

		bst.rotaciona();
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

	private BSTNode root;

	public BST() {
		this.root = new BSTNode();
		this.root.setParent(new BSTNode());
	}

	public void insert(int data) {
		insert(root, data);
	}

	private void insert(BSTNode node, int data) {
		if (node.isEmpty()) {
			node.setData(data);
			node.setLeft(new BSTNode());
			node.setRight(new BSTNode());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else if (data < node.getData()) {
			insert(node.getLeft(), data);
		} else {
			insert(node.getRight(), data);
		}
	}

	public int balance(BSTNode node) {
		return height(node.getLeft()) - height(node.getRight());
	}

	public int height(BSTNode node) {
		if (node.isEmpty()) {
			return -1;
		}
		return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	}

	public void preOrder() {
		System.out.print("[");
		preOrder(root);
		System.out.println("]");
	}

	private void preOrder(BSTNode node) {
		if (!node.isEmpty()) {
			if (node.getData() != root.getData())
				System.out.print(", ");

			System.out.print(node.getData());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	private void rotateLeft(BSTNode node) {
		BSTNode right = node.getRight();

		right.setLeft(node);
		node.getParent().setLeft(right);
		right.setParent(node.getParent());
		node.setParent(right);
		node.setRight(new BSTNode());

		if (node.getData() == this.root.getData()) {
			this.root = right;
		}
	}

	private void rotateRight(BSTNode node) {
		BSTNode left = node.getLeft();

		left.setRight(node);
		node.getParent().setRight(left);
		left.setParent(node.getParent());
		node.setParent(left);
		node.setLeft(new BSTNode());

		if (node.getData() == this.root.getData()) {
			this.root = left;
		}
	}

	public void rotaciona() {
		if (balance(root) == 0) {
			System.out.println("balanceada");
		} else if (balance(root) > 0) {
			if (balance(root.getLeft()) > 0) {
				System.out.println("rot_dir(" + root.getData() + ")");
				rotateRight(root);
				preOrder();
			} else {
				System.out.println("rot_esq(" + root.getLeft().getData() + ")");
				rotateLeft(root.getLeft());
				preOrder();

				System.out.println("rot_dir(" + root.getData() + ")");
				rotateRight(root);
				preOrder();
			}
		} else {
			if (balance(root.getRight()) < 0) {
				System.out.println("rot_esq(" + root.getData() + ")");
				rotateLeft(root);
				preOrder();
			} else {
				System.out.println("rot_dir(" + root.getRight().getData() + ")");
				rotateRight(root.getRight());
				preOrder();

				System.out.println("rot_esq(" + root.getData() + ")");
				rotateLeft(root);
				preOrder();
			}
		}
	}

}

class BSTNode {

	private Integer data;
	private BSTNode left;
	private BSTNode right;
	private BSTNode parent;

	public BSTNode() {
	}

	public BSTNode(Integer data) {
		this.data = data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setParent(BSTNode parent) {
		this.parent = parent;
	}

	public BSTNode getParent() {
		return parent;
	}

	public boolean isEmpty() {
		return data == null;
	}

}
