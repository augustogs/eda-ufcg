import java.util.Scanner;
import java.util.Stack;

public class InverteFrase {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = sc.nextLine();
		String fraseInvertida = inverteFrase(frase);
		System.out.println(fraseInvertida);
		sc.close();	
	}

	public static String inverteFrase(String frase) {
		Stack<String> pilha = new Stack<String>();
		String palavra = "";
		for (int i = 0; i < frase.length(); i++) {
			if (Character.isSpaceChar(frase.charAt(i))) {
				pilha.push(palavra);
				palavra = "";
			} else {
				palavra += frase.charAt(i);				
			}
		}
		pilha.push(palavra);
		
		String fraseInvertida = "";
		while (!pilha.isEmpty()) {
			if (pilha.size() > 1) {
				fraseInvertida += pilha.pop() + " ";
			} else {
				fraseInvertida += pilha.pop();
			}
		}	
		return fraseInvertida;
	}
}
