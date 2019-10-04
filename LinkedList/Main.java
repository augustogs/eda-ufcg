public class Main {
	
	public static void main(String[] args) {
		
		DoubleLinkedList lista = new DoubleLinkedList();
		
		lista.addLast(2);
		lista.add(0, 1);
		System.out.println("Elementos da lista: " + lista.print());
		System.out.println("O size é: " + lista.size());
		System.out.println("A lista está ordenada? " + lista.isSorted());
		System.out.println();
		
		lista.addLast(4);
		System.out.println("Elementos da lista: " + lista.print());
		System.out.println("O size é: " + lista.size());
		System.out.println("A lista está ordenada? " + lista.isSorted());
		System.out.println();
		
		lista.add(0, 0);	
		System.out.println("Elementos da lista: " + lista.print());
		System.out.println("O size é: " + lista.size());
		System.out.println("A lista está ordenada? " + lista.isSorted());
		System.out.println();
		
		lista.add(3, 3);
		System.out.println("Elementos da lista: " + lista.print());
		System.out.println("O size é: " + lista.size());
		System.out.println("A lista está ordenada? " + lista.isSorted());
		System.out.println();
		
		lista.add(0, -1);
		System.out.println("Elementos da lista: " + lista.print());
		System.out.println("O size é: " + lista.size());
		System.out.println("A lista está ordenada? " + lista.isSorted());
		System.out.println();
		
		System.out.println("Aqui começaremos a remoção!!");
		System.out.println();
		
		lista.remove(10);
		System.out.println("Elementos da lista: " + lista.print());
		System.out.println("O size é: " + lista.size());
		System.out.println("A lista está ordenada? " + lista.isSorted());
		System.out.println();
		
		lista.remove(lista.size() - 1);
		System.out.println("Elementos da lista: " + lista.print());
		System.out.println("O size é: " + lista.size());
		System.out.println("A lista está ordenada? " + lista.isSorted());
		System.out.println();
		
		lista.remove(0);
		System.out.println("Elementos da lista: " + lista.print());
		System.out.println("O size é: " + lista.size());
		System.out.println("A lista está ordenada? " + lista.isSorted());
		System.out.println();
		
		lista.remove(3);
		System.out.println("Elementos da lista: " + lista.print());
		System.out.println("O size é: " + lista.size());
		System.out.println("A lista está ordenada? " + lista.isSorted());
		System.out.println();
		
		lista.add(2, 4);
		System.out.println("Elementos da lista: " + lista.print());
		System.out.println("O size é: " + lista.size());
		System.out.println("A lista está ordenada? " + lista.isSorted());
		System.out.println();
		
	}

}
