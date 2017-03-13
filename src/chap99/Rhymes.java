package chap99;

import java.util.Random;

/**
 * Created by Administrator on 2014-12-11.
 */
public class Rhymes {

	private static Random rnd = new Random();

	public static void main(String[] args) {
		String word;
		switch (rnd.nextInt(2)) {
			case 0:
				word = "0";
				break;
			case 1:
				word = "1";
				break;
			default:
				word = "2";
				break;
		}
		System.out.println(word);
	}
}
