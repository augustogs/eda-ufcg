import java.util.Arrays;

public class MergSort {
	
	public static void main(String[] args) {	
		int[] v = new int[] {1,2,3,4,6,5};
		mergeSort(v);
		System.out.println(Arrays.toString(v));	
	}
	
	public static void mergeSort(int[] v) {
		mergeSort(v, 0, v.length-1);
	}
	
	public static void mergeSort(int[] v, int inicio, int fim) {
		int meio = (inicio + fim) / 2;
		if (inicio < fim) {
			mergeSort(v, inicio, meio);
			mergeSort(v, meio+1, fim);					
		}
		merge(v, inicio, meio, fim);	
	}
	
	private static void merge(int[] v, int inicio, int meio, int fim) {
		int[] arrayAux = new int[v.length];
		for (int i = 0; i < v.length; i++) {
			arrayAux[i] = v[i];
		}
			
		int i = inicio;
		int j = meio + 1;
		int k = inicio;
		
		while (i <= meio && j <= fim) {
			if (arrayAux[i] < arrayAux[j]) {
				v[k] = arrayAux[i];
				i++;
			} else {
				v[k] = arrayAux[j];
				j++;
			}
			k++;
		}
		
		while (i <= meio) {
			v[k] = arrayAux[i];
			i++;
			k++;
		}
		
		while (j <= fim) {
			v[k] = arrayAux[j];
			j++;
			k++;
		}
		
	}

}
