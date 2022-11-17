package w07hw;

import java.util.Stack;

/**
 * 
 * @author bahadr
 *
 */
public class Alg71Parentheses {

	private static int checkParentheses(String value) {
		char[] chars = value.toCharArray();							//	1
		Stack<Character> pStack = new Stack<Character>();			//	1	//	LIFO
		for (int i = 0; i < chars.length; i++) {					//	n+1
			char c = chars[i];										//	n
			if ((c == '(') || (c == '[') || (c == '{'))				//	n
				pStack.push(c);										//	n/2
			else
				if ((c == ')') || (c == ']') || (c == '}')) {		//	n/2
					char sChar = pStack.pop();						//	n/2
					if ((sChar != '(') && (c == ')'))				//	n/2
						return i;
					else
						if ((sChar != '[') && (c == ']'))			//	n/2
							return i;
						else
							if ((sChar != '{') && (c == '}'))		//	n/2
								return i;
				}
		}
		return -1;
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) ~ 6n+3	=>	O(n)
	 * 
	 */

	public static void main(String[] args) {
		System.out.println(checkParentheses("(a+b*[c-d])"));
		System.out.println(checkParentheses("(a-b/[c*{d+e})])"));
		System.out.println(checkParentheses("(123[321{000}321]123)"));
		System.out.println(checkParentheses("(123[321{000]321}123)"));
		System.out.println(checkParentheses("(((())))"));
	}
}
