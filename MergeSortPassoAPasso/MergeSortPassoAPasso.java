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
		System.out.println(Arrays.toString(array));
		int middle = (leftIndex + rightIndex) / 2;
		if (leftIndex < rightIndex) {
			int sizeA = middle - leftIndex;
			int[] arrayA = new int[sizeA];
			for (int i = leftIndex; i < middle; i++) {
				arrayA[i] = array[i];
			}
			
			int sizeB = rightIndex - middle + 1;
			int[] arrayB = new int[sizeB];
 			for (int j = middle + 1; j < rightIndex; j++) {
				arrayB[j] = array[j];
			}
 			mergeSortPassoAPasso(arrayA);
 			mergeSortPassoAPasso(arrayB);
 			merge(array, arrayA, arrayB);
		}
	}
	
	private static void merge(int[] array, int[] arrayA, int[] arrayB) {
		int[] arrayAux = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayAux[i] = array[i];
		}
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < arrayA.length && j < arrayB.length) {
			if (arrayA[i] < arrayB[j]) {
				array[k] = arrayA[i];
				i++;
			} else {
				array[k] = arrayB[j];
				j++;
			}
			k++;
		}
		
		while (i < arrayA.length) {
			array[k] = arrayA[i];
			i++;
			k++;
		}
		
		while (j < arrayB.length) {
			array[k] = arrayB[j];
			j++;
			k++;
		}
		
	}
	
}
