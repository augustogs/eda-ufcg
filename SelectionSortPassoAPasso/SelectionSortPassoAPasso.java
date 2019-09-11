import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortPassoAPasso {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = toIntArray(sc.nextLine().split(" "));
		SelectionSort(array);
		sc.close();
	}
		
	private static void SelectionSort(int[] v) {
		for (int i = 0; i < v.length; i++) {
			int i_menor = i; 
			boolean trocou = false;
			for (int j = i+1; j< v.length; j++) {
				if (v[j] < v[i_menor]) {
					i_menor = j;
					trocou = true;
				}
			}		 
			if (trocou) {
				int aux = v[i];
				v[i] = v[i_menor];
				v[i_menor] = aux;
				System.out.println(Arrays.toString(v));
			}		
		}			
	}
		
	private static int[] toIntArray(String[] entrada) {
		int[] array = new int[entrada.length];
		for (int i = 0; i < entrada.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}	
		return array;
	}

}


