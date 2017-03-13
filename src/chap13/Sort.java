package chap13;

import java.util.Arrays;

public class Sort {

	private static int[] array1 = {1,5,12,23,62,145,367,815,1968,4711,11969,27901,84801,213331,543749,1355339,3501671,8810089,21521774,58548857,157840433,410151271,1131376761,2147483647};

	public static void main(String[] args) {
		ShellSort.sort(array1);
		arrayPrint("ShellSort", array1);
	}

	public static void arrayPrint(String title, int[] array) {
		System.out.println("=============" + title + "=============");
		Arrays.stream(array).forEach(System.out::print);
		System.out.println("");
	}
}