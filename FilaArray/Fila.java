import java.util.Scanner;

public class Fila {
	
	private int[] fila;
	private int head;
	private int tail;
	private int size;
	
	public Fila(int size) {
		this.fila = new int[size];
		this.head = -1;
		this.tail = -1;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	public boolean isFull() {
		return (this.size == fila.length);
	}
	
	public int element() {
		return this.fila[head];
	}
	
	public void add(int elemento) {
		if (!isFull()) {
			if (isEmpty()) {
				this.head++;
				this.tail++;
				this.fila[head] = elemento;
			} else {
				this.tail = (tail + 1) % fila.length;
				this.fila[tail] = elemento;
			}
			this.size++;
		} else {
			System.out.println("full");
		}			
	}
	
	public void remove() {	
		if (!isEmpty()) {
			if (this.head == this.tail) {
				this.head = -1;
				this.tail = -1;
			} else {
				this.head = (this.head + 1) % this.size;
			}
			this.size--;
		} else {
			System.out.println("empty");
		}
	}
	
	public String print() {
		String result= "empty";
		if (!isEmpty()) {
			result = "";
			int i = this.head;
			while (i != this.tail) {
				result += this.fila[i] + " ";
				i = (i + 1) % this.fila.length;
			}
			result += this.fila[tail] + " ";
		}			
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = sc.nextInt();
		Fila fila = new Fila(tamanho);
		String[] entrada;
		String option;
		do {
			entrada = sc.nextLine().split(" ");
			option = entrada[0];
			if ("add".equals(option)) {
				int elemento = Integer.parseInt(entrada[1]);
				fila.add(elemento);
			}
			if ("remove".equals(option)) {
				fila.remove();
			}
			if ("print".equals(option)) {
				System.out.println(fila.print());
			}
			if ("element".equals(option)) {
				System.out.println(fila.element());
			}	
		} while (!option.equals("end"));		
		sc.close();
	}

}
