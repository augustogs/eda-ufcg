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
<<<<<<< HEAD
		printArray(array, leftIndex, rightIndex);
		if (leftIndex < rightIndex) {	
			int middle = (leftIndex + rightIndex) / 2;
			mergeSortPassoAPasso(array, leftIndex, middle);
			mergeSortPassoAPasso(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
=======
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
>>>>>>> branch 'master' of https://github.com/augustogs/EDA.git
		}
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/augustogs/EDA.git
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
		
<<<<<<< HEAD
		while (i <= middle) {
			array[k] = arrayAux[i];
=======
		while (i < arrayA.length) {
			array[k] = arrayA[i];
>>>>>>> branch 'master' of https://github.com/augustogs/EDA.git
			i++;
			k++;
		}
		
<<<<<<< HEAD
		while (j <= rightIndex) {
			array[k] = arrayAux[j];
=======
		while (j < arrayB.length) {
			array[k] = arrayB[j];
>>>>>>> branch 'master' of https://github.com/augustogs/EDA.git
			j++;
			k++;
		}
		printArray(array, leftIndex, rightIndex);
	}
	
<<<<<<< HEAD
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

=======
>>>>>>> branch 'master' of https://github.com/augustogs/EDA.git
}
