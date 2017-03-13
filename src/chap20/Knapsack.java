package chap20;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Knapsack {

	int[] size;
	int[] value;
	int n;

	public Knapsack(int[] size, int[] value) throws IllegalAccessException {
		if (size.length != value.length) {
			throw new IllegalAccessException("'size'와 value'의 요소 수가 일치하지 않습ㄴ다.");
		}
		n = size.length;
		this.size = size.clone();
		this.value = value.clone();
	}

	public void solved(int m) {
		int[] total = new int[m + 1];
		int[] choice = new int[m + 1];
		Arrays.fill(choice, -1);

		int repackTotal;

		System.out.println("배낭크기는 " + m);

		for (int i = 0; i < n; i++) {
			for (int j = size[i]; j <= m; j++) {
				repackTotal = total[j - size[i]] + value[i];
				if (repackTotal > total[j]) {
					total[j] = repackTotal;
					choice[j] = i;
				}
			}
			System.out.println(Arrays.toString(total));
		}

		System.out.println("가격의 합계 = " + total[m]);
	}

	public static void main(String[] args) throws IllegalAccessException {
		int m = new Scanner(in).nextInt();
		Knapsack knapsack = new Knapsack(new int[]{2, 5, 6, 7, 8, 9}, new int[]{100, 201, 5, 6, 7, 9});
		knapsack.solved(m);
	}
}
