import java.util.Arrays;

public class MergeSortPassoAPasso {
	
	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,6,5};
		mergeSortPassoAPasso(array);
		System.out.println(Arrays.toString(array));
	}

	public static void mergeSortPassoAPasso(int[] array) {
		mergeSortPassoAPasso(array, 0, array.length-1);
	}
	
	public static void mergeSortPassoAPasso(int[] array, int leftIndex, int rightIndex) {
		int middle = (leftIndex + rightIndex) / 2;
		if (leftIndex < rightIndex) {	
			mergeSortPassoAPasso(array, leftIndex, middle);
			mergeSortPassoAPasso(array, middle + 1, rightIndex);
		}
		merge(array, leftIndex, middle, rightIndex);
		
	}
	
	private static void merge(int[] array, int leftIndex, int middle, int rightIndex) {
		int[] arrayAux = new int[array.length];
		for (int i = leftIndex; i <= rightIndex; i++) {
			arrayAux[i] = array[i];
		}
		
		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;
		
		while (i <= middle && j <= rightIndex) {
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
			array[k] = array[i];
			i++;
			k++;
		}
		
		while (j <= rightIndex) {
			array[k] = array[j];
			j++;
			k++;
		}
		
	}
	
	

}
