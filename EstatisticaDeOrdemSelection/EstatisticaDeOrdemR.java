
public class EstatisticaDeOrdemR<T extends Comparable<T>> {
	
	public static void main(String[] args) {
		Integer[] array = new Integer[] {2,9,4,11,3};
		Integer elem = new EstatisticaDeOrdemR<Integer>().getEstatisticaDeOrdem(array, 4);
		System.out.println(elem);
	}
	
	public T getEstatisticaDeOrdem(T[] array, int k) {
		int iMin = 0;
		int iMax = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(array[iMin]) < 0) {
				iMin = i;
			}
			if (array[i].compareTo(array[iMax]) > 0) {
				iMax = i;
			}
		}
		return auxGetEstatisticaDeOrdem(array, k, 1, iMin, iMax);
	}

	private T auxGetEstatisticaDeOrdem(T[] array, int k, int qntdMinimos, int iMin, int iMax) {
		if (k == qntdMinimos) {
			return array[iMin];
		}
		if (k == array.length) {
			return null;
		} 
		int iLastMin = iMax;
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(array[iLastMin]) < 0) {
				if (array[i].compareTo(array[iMin]) > 0) {
					iLastMin = i;
				}
			}
		}
		return auxGetEstatisticaDeOrdem(array, k, qntdMinimos + 1, iLastMin, iMax); 
	}
	
}
