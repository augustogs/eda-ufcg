import java.util.Scanner;

class FilaLinkedList {
	
	private Node head;
	
	public FilaLinkedList() {
		this.head = null;
	}
	
	public boolean isEmpty() {
		return (this.head == null); 
	}
	
	public void add(int element) {
		Node node = new Node(element);
		if (isEmpty()) {
			this.head = node;
		} else {
			this.add(this.head, node);
		}
	}
	
	//Metodo auxiliar para o add.
	private void add(Node node, Node newNode) {
		if (node.next == null) {
			node.next = newNode;
			newNode.prev = node;
		} else {
			this.add(node.next, newNode);
		}
	}
	
	public String element() {
		if (!isEmpty()) {
			return this.head.value + "";			
		} else {
			return "empty";
		}
	}
		
	public String print() {
		if (isEmpty()) {
			return "empty";
		} else {
			return this.print(this.head);				
		}
	}
	
	//Metodo auxiliar para o print.
	private String print(Node n) {
		String result = "";
		if (n == null) {
			result = "";
		} else {
			result += n.value + " " + this.print(n.next);
		}
		return result.trim();
	}
	
	public void remove() {
		if (isEmpty()) {
			System.out.println("empty");
		}
		else if (this.head.next == null) {
			this.head = null;
		} else {			
			this.head = this.head.next;
			this.head.prev = null;
		}
	}
	
	public int search(int element) {
		if (this.head == null) {
			return -1;
		} else {
			return this.search(this.head, element);			
		}
	}
	
	//Metodo auxiliar do search.
	private int search(Node n, int element) {
		if (n.value == element) return 0;
		if (n.next == null) return -1;
		else return 1 + search(n.next, element);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FilaLinkedList filaLinked = new FilaLinkedList();
		String[] entrada;
		String option;
		do {
			entrada = sc.nextLine().split(" ");
			option = entrada[0];
			if ("add".equals(option)) {
				int elemento = Integer.parseInt(entrada[1]);
				filaLinked.add(elemento);
			}
			if ("remove".equals(option)) {
				filaLinked.remove();
			}
			if ("print".equals(option)) {
				System.out.println(filaLinked.print());
			}
			if ("element".equals(option)) {
				System.out.println(filaLinked.element());
			}			
			if ("search".equals(option)) {
				int element = Integer.parseInt(entrada[1]);
				System.out.println(filaLinked.search(element));
			}	
		} while (!option.equals("end"));		
		sc.close();
	}

}

class Node {
	
	protected int value;
	protected Node next;
	protected Node prev;
	
	public Node(int value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	
}
