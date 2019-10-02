
class DoubleLinkedList {
	
	private DoubleNode head;
	
	public DoubleLinkedList() {
		this.head = null;
	}
	
	public void addLast(int elemento) {
		if (isEmpty()) {
			this.head = new DoubleNode(elemento);
		} else {
			addLast(this.head, elemento);
		}
	}
	
	private void addLast(DoubleNode node, int elemento) {
		if (node.next == null) {
			DoubleNode newNode = new DoubleNode(elemento);
			node.next = newNode;
			newNode.prev = node;
		} else {
			addLast(node.next, elemento);
		}
	}
	
	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			return size(this.head);
		}
	}
		
	private int size(DoubleNode node) {
		if (node == null) return 0;
		else return 1 + size(node.next);
	}

	public int soma() {
		if (isEmpty()) {
			return 0;
		} else {
			return soma(this.head);
		}
	}
	
	private int soma(DoubleNode node) {
		if (node == null) return 0;
		else return node.value + soma(node.next); 
	}	
		
	public boolean isSorted() {
		return isSorted(this.head);
	}
	
	private boolean isSorted(DoubleNode node) {
		if (node == null) return true;
		if (node.value > node.next.value) return false;
		else return true;
	}
	
	public String print() {
		if (isEmpty()) {
			return "empty";
		} else {
			return this.print(this.head);				
		}
	}
	
	//Metodo auxiliar para o print.
	private String print(DoubleNode n) {
		String result = "";
		if (n == null) {
			result = "";
		} else {
			result += n.value + " " + this.print(n.next);
		}
		return result.trim();
	}

	/////////////////////////////////////////// iterativos;
	
	public void add(int index, int elemento) {
		
	}
	
	public void remove(int index) {
		
	}
	
	private boolean isEmpty() {
		return this.head == null;
	}
		
}

class DoubleNode {
	
	protected int value;
	protected DoubleNode next;
	protected DoubleNode prev;
	
	public DoubleNode(int value) {
		this.value = value;
		this.next = null;
		this.prev = null;		
	}	
	
}
