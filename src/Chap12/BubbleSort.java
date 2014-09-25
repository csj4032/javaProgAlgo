package Chap12;

/**
 * Created by Administrator on 2014-09-25.
 */
public class BubbleSort {

	public static void sort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > i; j++) {
				if (a[j - 1] > a[j]) {
					int temp 	=	a[j];
					a[j]		=	a[j - 1];
					a[j - 1]	=	temp;
				}
			}
		}
	}
}
