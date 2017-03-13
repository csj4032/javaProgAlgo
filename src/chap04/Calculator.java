package chap04;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;

public class Calculator {

	private static void push(MyStack stack, long value) {
		stack.push(new Long(value));
	}

	private static long pop(MyStack stack) {
		Long l = (Long) stack.pop();
		return l.longValue();
	}

	public static void main(String[] args) throws IOException {
		MyStack stack = new MyStack();
		PushbackReader input = new PushbackReader(new InputStreamReader(System.in));
		int c;
		long a, b;
		while ((c = input.read()) != -1) {
			char ch = (char) c;
			if (Character.isDigit(ch)) {
				long num = 0;
				while (Character.isDigit(ch)) {
					// 아스키 코드표 (ch - '0') --> (ch - 48)
					// 예) '0' --> 48
					// num = 10 * num + (ch - 48);
					num = 10 * num + (ch - '0');
					c = input.read();
					ch = (char) c;
				}
				input.unread(c);
				push(stack, num);
			} else {
				switch (ch) {
				case '+':
					b = pop(stack);
					a = pop(stack);
					push(stack, a + b);
					break;
				case '\n':
					if (!stack.isEmpty()) {
						System.out.println("답은 " + pop(stack) + "입니다.");
					}
					stack.clear();
					break;
				case ' ':
				case '\t':
				case '\r':
					break;
				default:
					System.out.println("올바르지 않은 문자");
					System.out.println("다시 입력해 주십시오.");
					while ((c = input.read()) != -1 & c != '\n')
						;
					stack.clear();
					break;
				}
			}
		}
	}
}