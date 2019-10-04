
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
		return size(this.head);
	}
		
	private int size(DoubleNode node) {
		if (node == null) return 0;
		else return 1 + size(node.next);
	}

	public int soma() {
		return soma(this.head);
	}
	
	private int soma(DoubleNode node) {
		if (node == null) return 0;
		else return node.value + soma(node.next); 
	}	
		
	public boolean isSorted() {
		if (this.head == null) return true;
		else return isSorted(this.head);
	}
	
	private boolean isSorted(DoubleNode node) {
		if (node.next == null) return true;
		else if (node.value > node.next.value) return false;
		return isSorted(node.next);
	}
	
	public void add(int index, int elemento) {
		if (index >= 0 && index <= this.size()) {
			DoubleNode newNode = new DoubleNode(elemento);
			if (isEmpty()) {
				this.head = newNode;
			}
			else if (index == 0) {
				this.head.prev = newNode;
				newNode.next = this.head;
				this.head = newNode;
			}
			else {				
				DoubleNode aux = this.head;
				DoubleNode last = this.head;
				int i = 0;
				while (i < index) {
					last = aux;
					aux = aux.next;
					i++;
				}		
				if (aux == null) {
					newNode.prev = last;
					last.next = newNode;
				} else {
					newNode.next = aux;
					last.next = newNode;
					aux.prev = newNode;
					newNode.prev = last;									
				}
			}
		}		
	}
	
	public void remove(int index) {
		if (!this.isEmpty() && index >= 0 && index < this.size()) {
			if (index == 0 && this.head.next == null) {
				this.head = null;
			} 
			else if (index == 0) {
				this.head = this.head.next;
				this.head.prev = null;				
			}
			else {
				DoubleNode aux = this.head;
				int i = 0;
				while (i < index) {
					aux = aux.next;
					i++;
				}
				if (index == this.size() - 1) {
					aux.prev.next = null;
					aux.prev = null;					
				} else {
					aux.next.prev = aux.prev;
					aux.prev.next = aux.next;
					aux.next = null;
				}			
			}
		}
	}
	
	public boolean isEmpty() {
		return this.head == null;
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
