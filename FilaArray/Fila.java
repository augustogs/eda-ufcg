import java.util.Scanner;

public class Fila {
	
	private int[] fila;
	private int head;
	private int tail;
	
	public Fila(int tamanho) {
		this.fila = new int[tamanho];
		this.head = -1;
		this.tail = -1;
	}
	
	public boolean isEmpty() {
		return (this.head == -1 && this.tail == -1);
	}
	
	public boolean isFull() {
		return this.tail == fila.length;
	}
	
	public int element() {
		return this.fila[head];
	}
	
	public void add(int elemento) {
		if (isFull()) throw new RuntimeException();
		if (isEmpty()) {
			this.head = 0;
			this.tail = 0;
			this.fila[0] = elemento;
		} else {
			this.tail++;
			this.fila[tail] = elemento;
		}
	}
	
	public int remove() {
		if (isEmpty()) throw new RuntimeException();
		
		int valor = fila[0];
		if (this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		} else {
			this.head = (this.head + 1) % fila.length;
		}
		return valor;
	}
	
	public String print() {
		String result= "empty";
		if (!isEmpty()) {
			result = "";
			for (int i = head; i <= tail; i++) {
				result += this.fila[i] + " ";
			}
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = sc.nextInt();
		FilaCircular fila = new FilaCircular(tamanho);
		String[] entrada;
		String option;
		do {
			entrada = sc.nextLine().split(" ");
			option = entrada[0];
			
			switch (option) {
			case "add":
				int elemento = Integer.parseInt(entrada[1]);
				fila.add(elemento);
				break;			
			case "remove":
				fila.remove();
				break;
			case "print":
				System.out.println(fila.print());
				break;			
			case "element":
				System.out.println(fila.element());
				break;			
			default:
				break;
			}
	
		} while (!option.equals("end"));
		sc.close();
	}

}
