import java.util.Scanner;

public class EstatisticaDeOrdem {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = toIntArray(sc.nextLine().split(" "));
		estatisticaDeOrdem(array);
		sc.close();
	}
	
	public static void estatisticaDeOrdem(int[] array) {
		int elem = array[0];
		int i = 1;
		int j = array.length - 1;
		
		while (i <= j) {
			if (array[i] < elem) {
				i++;
			}
			else if (elem < array[j]) {
				j--;
			} else {
				int aux = array[i];
				array[i] = array[j];
				array[j] = aux;
				i++;
				j--;
			} 
		}
		int aux = array[0];
		array[0] = array[j];
		array[j] = aux;
		i++;
		System.out.println(i);
		
	}
	
	private static int[] toIntArray(String[] array) {
		int[] v = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			v[i] = Integer.parseInt(array[i]);
		}		
		return v;	
	}

}
