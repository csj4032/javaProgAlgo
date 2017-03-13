package chap18;

public class BruteForce {

	public static int search(final String text, final String pattern) {
		int i = 0;
		int j = 0;

		while (i < text.length() && j < pattern.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}

		return (j == pattern.length()) ? (i - j) : -1;
	}

	public static void main(String[] args) {
		BruteForce bf = new BruteForce();
		System.out.println(bf.search("baaabaadcddd", "baadcdd"));
	}
}
