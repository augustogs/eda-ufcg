import java.util.Scanner;

public class Parenteses {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		isValid(entrada);
		sc.close();
	}
	
	public static void isValid(String entrada) {
		boolean result = true;
		int i = 0;
		int j = entrada.length() - 1;
		char[] aux = entrada.toCharArray();

		while (i <= j && result) {
			if (aux[i] != '(' || aux[j] != ')') {
				result = false;
			}
			j--;
			i++;
		}
		if (result == true) System.out.println("S");
		else System.out.println("N");
	}

}

