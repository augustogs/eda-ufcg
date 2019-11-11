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
			bst.add(seq[i]);
		}
	}
}

class BST {

	private Node root;

	public BST() {
		
	}

	public void valorMaisProximo(int n) {
		int result = 0;
		
		// representa a diferenca entre o valor dos nos, quando mais proxima de 0 mais o numero eh proximo.
		int distAtual = Integer.MAX_VALUE;	
				
		boolean achou = false;
		Node aux = this.root;
		
		//achou pode ser substituido por dist = 0;
		while (!achou && aux != null && aux.left != null && aux.right != null) {
			if (aux.value == n) {
				result = aux.value;
				achou = true;
			} else {
				int distNode = Math.abs(n - aux.value);
				int distLeft = Math.abs(n - aux.left.value);
				int distRight = Math.abs(n - aux.right.value);
				
				if (distAtual > distLeft || distAtual > distRight) {
					
					if (distNode < distLeft && distNode < distRight) {
						if (distNode < distAtual) {
							result = aux.value;
							distAtual = distNode;
							if (distLeft < distRight) {
							aux = aux.left;
							} else {
							aux = aux.right;
							}
						}
					}
					
					if (distLeft < distNode && distLeft < distRight) {
						if (distLeft < distAtual) {
							result = aux.left.value;
							distAtual = distLeft;
							aux = aux.left;
						}	
					}
					
					if (distRight < distNode && distRight < distLeft) {
						if (distRight < distAtual) {
							result = aux.right.value;
							distAtual = distRight;
							aux = aux.right;
						}
					}
				}
				else {
					achou = true;				
				}
				
				//impl com 2 erros.
//				if (distNode < distAtual) {
//					result = aux.value;
//					distAtual = distNode;
//					if (distLeft < distRight) {
//						aux = aux.left;
//					} else {
//						aux = aux.right;
//					}
//				}
				
//				if (distLeft < distAtual) {
//					result = aux.left.value;
//					distAtual = distLeft;
//					aux = aux.left;
//				}
//								
//				if (distRight < distAtual) {
//					result = aux.right.value;
//					distAtual = distRight;
//					aux = aux.right;
//				}
			} 
			
//			else if (n > aux.value) {
//				int novaDist = Math.abs(n - aux.value);
//				if (novaDist < dist) {
//					result = aux.value;
////					dist = novaDist;
//				}
//				aux = aux.right;
//			}
//			else if (n < aux.value) {
//				int novaDist = Math.abs(n - aux.value);
//				if (novaDist < dist) {
//					result = aux.value;
////					dist = novaDist;
//				}
//				aux = aux.left;
//			}
			
		}
		System.out.println(result);
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
