import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] v = new int[] {3,2,1,1,2,3,1,5,1,2,3};
		quickSort(v, 0, v.length - 1);
		System.out.println(Arrays.toString(v));
	}	
	
	
	public static void quickSort(int[] v, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int iPivot = particiona(v, leftIndex, rightIndex);
			quickSort(v, leftIndex, iPivot - 1);
			quickSort(v, iPivot + 1, rightIndex);
		}
	}
	
	private static int particiona(int[] v, int leftIndex, int rightIndex) {
		int pivot = v[leftIndex];
		int i = leftIndex + 1;
		int j = leftIndex + 1;
		
		while (i <= rightIndex) {
			if (v[i] <= pivot) {
				swap(v, j, i);
				j++;
			}
			i++;
		}
		swap(v, leftIndex, j-1);		
		return j-1;
	}
	
	private static void swap(int[] v, int i, int j) {
		if (v == null)
			throw new IllegalArgumentException();

		int temp = v[i];
		v[i] = v[j];
		v[j] = temp;
	}

}
