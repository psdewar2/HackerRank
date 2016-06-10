import java.util.Stack;
import java.util.Scanner;

public class Stacks {
	public static void main(String[] args) {
		balanced();

	}

	static void balanced() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		outer:
		for (int i = 0; i < n; i++) {
			Stack<Character> stack = new Stack<Character>();
			String parens = input.next();
			for (int ch = 0; ch < parens.length(); ch++) {
				char c = parens.charAt(ch);
				if (c == '{' || c == '[' || c == '(') {
					stack.push(c);
				} else if (c == '}') {
					if (stack.empty() || stack.pop() != '{') {
						System.out.println("NO");
						continue outer;
					}
				} else if (c == ']') {
					if (stack.empty() || stack.pop() != '[') {
						System.out.println("NO");
						continue outer;
					}
				} else if (c == ')') {
					if (stack.empty() || stack.pop() != '(') {
						System.out.println("NO");
						continue outer;
					}
				}
			}
			if (stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	static void getMax() {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> maxStack = new Stack<Integer>();
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			int type = input.nextInt();
			if (type == 1) {
				int x = input.nextInt();
				stack.push(x);
				if (maxStack.empty()) {
					maxStack.push(x);
				} else {
					if (x > maxStack.peek()) {
						maxStack.push(x);
					} else {
						maxStack.push(maxStack.peek());
					}
				}
			}

			if (type == 2) {
				stack.pop();
				maxStack.pop();
			}

			if (type == 3) {
				System.out.println(maxStack.peek());
			}
		}
	}
}