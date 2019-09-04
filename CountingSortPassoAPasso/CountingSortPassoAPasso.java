import java.util.Scanner;

public class CountingSortPassoAPasso {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = toIntArray(sc.nextLine().split(" "));
		int maior = sc.nextInt();
		sc.close();
		countingSortPassoAPasso(array, maior);
		System.out.println(printArray(array));
	}
	
	private static void countingSortPassoAPasso(int[] array, int maior) {
		int[] arrayB = new int[maior + 1];
		for (int i = 0; i < array.length; i++) {
			arrayB[array[i]] += 1;
			System.out.println(printArray(arrayB));
		}
		
		for (int j = 1; j < arrayB.length; j++) {
			arrayB[j] += arrayB[j-1];
		}
		System.out.println("Cumulativa do vetor de contagem - "+ printArray(arrayB));
		
		int[] arrayC = new int[array.length];
		for (int i = array.length - 1; i >= 0; i--) {
			arrayC[arrayB[array[i]] - 1] = array[i];
			arrayB[array[i]] -= 1;
		}
		System.out.println(printArray(arrayB));
		
		for (int j = 0; j < array.length; j++) {
			array[j] = arrayC[j];
		}
		
	}

	private static int[] toIntArray(String[] array) {
		int[] v = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			v[i] = Integer.parseInt(array[i]);
		}
		return v;	
	}
	
	private static String printArray(int[] array) {
		String result = "";	
		for (int i = 0; i < array.length; i++) {
			if (i < array.length - 1) {
				result += array[i] + " ";				
			} else {
				result += array[i];
			}
		}
		
		return result;
	}
	
}
