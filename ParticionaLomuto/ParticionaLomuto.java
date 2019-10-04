import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ParticionaLomuto {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = toIntArray(sc.nextLine().split(" "));
		particionaLomuto(array);
		sc.close();
		System.out.println(Arrays.toString(array));
	}
	
	public static void particionaLomuto(int[] array) {
		int pivot = array[0];
		int i = 0;
		int j = 1;
		
		while (j < array.length) {
			if (array[j] < pivot) {
				i++;
				int aux = array[i];
				array[i] = array[j];
				array[j] = aux;
				System.out.println(Arrays.toString(array));
			}
			j++;
		}
		int aux = array[i];
		array[i] = pivot;
		array[0] = aux;
		System.out.println(Arrays.toString(array));
	}
	
	private static int[] toIntArray(String[] array) {
		int[] v = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			v[i] = Integer.parseInt(array[i]);
		}
		return v;
	}	

}
