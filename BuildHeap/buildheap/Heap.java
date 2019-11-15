package buildheap;

import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] entrada = toIntArray(sc.nextLine().split(" "));
		
		Heap heap = new Heap(entrada.length);
		heap.buildHeap(entrada);

		sc.close();
	}

	private static int[] toIntArray(String[] array) {
		int[] v = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			v[i] = Integer.parseInt(array[i]);
		}
		return v;
	}

}

class Heap {

	private int[] heap;
	private int index;

	public Heap(int tamanho) {
		this.heap = new int[tamanho];
		this.index = -1;
	}

	public void buildHeap(int[] entrada) {
		this.heap = entrada;
		this.index = heap.length - 1;

		for (int i = entrada.length / 2; i >= 0; i--) {
			heapify(i);
		}
		System.out.println(Arrays.toString(heap));
	}

	private void heapify(int i) {
		int max = i;

		if (left(i) <= this.index && this.heap[left(i)] > this.heap[max]) {
			max = left(i);
		}
		if (right(i) <= this.index && this.heap[right(i)] > this.heap[max]) {
			max = right(i);
		}
		if (max != i) {
			int aux = this.heap[i];
			this.heap[i] = this.heap[max];
			this.heap[max] = aux;
			this.heapify(max);
		}

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

}
