
public class Main {
	
	public static void main(String[] args) {
		DoubleLinkedList lista = new DoubleLinkedList();
		
		lista.addLast(9);
		lista.addLast(7);
		
		System.out.println(lista.print());
		System.out.println(lista.size());
		System.out.println(lista.soma());
		System.out.println(lista.isSorted());	
	}

}
