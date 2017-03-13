package chap14;

public class QuickSort1 {

	private static int partition(int[] a, int l, int r) {
		int i = l - 1;
		return i;
	}

	private static void quickSort(int[] a, int l, int r) {
		if (l >= r) {
			return;
		}

		int v = partition(a, l, r);
		quickSort(a, l, v - 1);
		quickSort(a, v + 1, r);
	}

	public static void sor(int[] a) {
		quickSort(a, 0, a.length - 1);
	}
}
