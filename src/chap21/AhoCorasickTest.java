package chap21;

/**
 * Created by Administrator on 2014-09-26.
 */
public class AhoCorasickTest {

	private static AhoCorasick NAVER_KEYWORD_AC = null;

	public static void main(String[] args) {
		NAVER_KEYWORD_AC = new AhoCorasick();
		NAVER_KEYWORD_AC.add("네이버".getBytes(), "네이버");
	}
}
