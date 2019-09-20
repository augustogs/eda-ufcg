import java.util.Scanner;

public class Pilha {
	
	private int[] pilha;
	private int topo;
	private int size;
	
	public Pilha(int size) {
		this.pilha = new int[size];
		this.topo = -1;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	public boolean isFull() {
		return (this.size == this.pilha.length);
	}
	
	public int peek() {
		return this.pilha[topo];
	}
	
	public void push(int elemento) {
		if (!isFull()) {
			this.topo++;
			this.pilha[topo] = elemento;
			this.size++;
		} else {
			System.out.println("full");
		}
	}
	
	public void pop() {
		if (!isEmpty()) {
			this.topo--;
			this.size--;
		} else {
			System.out.println("empty");
		}
	}
	
	public String print() {
		String result = "empty";
		if (!isEmpty()) {
			result = "";
			for (int i = 0; i < this.topo; i++) {
				result += this.pilha[i] + " "; 
			}
			result += this.pilha[topo];
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = sc.nextInt();
		Pilha pilha = new Pilha(tamanho);
		String[] entrada;
		String option;
		do {
			entrada = sc.nextLine().split(" ");
			option = entrada[0];
			if ("push".equals(option)) {
				int elemento = Integer.parseInt(entrada[1]);
				pilha.push(elemento);
			}
			if ("pop".equals(option)) {
				pilha.pop();
			}
			if ("peek".equals(option)) {
				System.out.println(pilha.peek());
			}
			
			if ("print".equals(option)) {
				System.out.println(pilha.print());
			}	
		} while (!option.equals("end"));		
		sc.close();
	}

}
