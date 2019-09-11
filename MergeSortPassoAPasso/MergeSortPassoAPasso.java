import java.util.Scanner;

public class MergeSortPassoAPasso {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = toIntArray(sc.nextLine().split(" "));
		mergeSortPassoAPasso(array);
		sc.close();
	}

	public static void mergeSortPassoAPasso(int[] array) {
		mergeSortPassoAPasso(array, 0, array.length-1);
	}
	
	public static void mergeSortPassoAPasso(int[] array, int leftIndex, int rightIndex) {
		printArray(array, leftIndex, rightIndex);
		if (leftIndex < rightIndex) {	
			int middle = (leftIndex + rightIndex) / 2;
			mergeSortPassoAPasso(array, leftIndex, middle);
			mergeSortPassoAPasso(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
		}
	}
		
	private static void merge(int[] array, int leftIndex, int middle, int rightIndex) {
		int[] arrayAux = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayAux[i] = array[i];
		}
		
		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;
		
		while (i < middle && j < rightIndex) {
			if (arrayAux[i] < arrayAux[j]) {
				array[k] = arrayAux[i];
				i++;
			} else {
				array[k] = arrayAux[j];
				j++;
			}
			k++;
		}
		
		while (i <= middle) {
			array[k] = arrayAux[i];
			i++;
			k++;
		}
		
		while (j <= rightIndex) {
			array[k] = arrayAux[j];
			j++;
			k++;
		}
		printArray(array, leftIndex, rightIndex);
	}
	
	private static int[] toIntArray(String[] array) {
		int[] v = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			v[i] = Integer.parseInt(array[i]);
		}		
		return v;	
	}
	
	private static void printArray(int[] array, int leftIndex, int rightIndex) {
		String result = "[";
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (i == rightIndex) {
				result += array[i] + "]";
			} else {
				result += array[i] + ", ";
			}
		}
		System.out.println(result);
	}
}
