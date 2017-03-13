package chap12;

import java.util.Arrays;

public class Sort {

	private static int[] array1 = {20, 21, 22, 23, 24, 25, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	private static int[] array2 = {20, 21, 22, 23, 24, 25, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	private static int[] array3 = {20, 21, 22, 23, 24, 25, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

	public static void main(String[] args) {
		BubbleSort.sort(array1);
		arrayPrint("BubbleSort", array1);

		SelectSort.sort(array2);
		arrayPrint("SelectSort", array2);

		InsertSort.sort(array3);
		arrayPrint("InsertSort", array3);
	}

	public static void arrayPrint(String title, int[] array) {
		System.out.println("=============" + title + "=============");
		Arrays.stream(array).forEach(System.out::print);
		System.out.println("");
	}
}