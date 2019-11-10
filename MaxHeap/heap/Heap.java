package heap;

import java.util.Scanner;

class Heap {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] entrada = toIntArray(sc.nextLine().split(" "));
		
		System.out.println(isHeap(entrada));	
		sc.close();
	}
	
	private static boolean isHeap(int[] array) {
		boolean isHeap = true;
		
		int i = 0;
		while (isHeap && left(i) < array.length && right(i) < array.length) {
			if (array[parent(i)] < array[left(i)] || array[parent(i)] < array[right(i)]) {
				isHeap = false;
			}
			i++;
		}
		return isHeap;	
	}
	
	private static int left(int i) {
		return (2 * i + 1);
	}
	
	private static int right(int i) {
		return (2 * i + 1) + 1;
	}
	
	private static int parent(int i) {
		return (i - 1) / 2;
	}

	private static int[] toIntArray(String[] array) {
		int[] v = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			v[i] = Integer.parseInt(array[i]);
		}
		return v;	
	}

}
