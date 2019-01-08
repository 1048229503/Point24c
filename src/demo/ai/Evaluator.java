package demo.ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Evaluator {
	private static final double ERROR = -1;

	public static void main(String[] args) {
		System.out.println(eval("2 + 3".split("\\s+")));
		List<String> list=new ArrayList<String>();
		System.out.println(eval(list));

	}
	public static double eval(List<String> exp) {//right but ugly
		Stack<Double> stack = new Stack<Double>();
		for (String s : exp) {
			if (isNumber(s)) {
				stack.push(Double.valueOf(s));
			} else if (isOperator(s)) {
				if (stack.isEmpty())
					return ERROR;
				double b = stack.pop();
				double a = 0;
				try {
					a = stack.pop();
				} catch (EmptyStackException e) {
					return ERROR;
				}
				double c = 0;
				switch (s) {
				case "+":
					c = a + b;
					break;
				case "-":
					c = a - b;
					break;
				case "*":
					c = a * b;
					break;
				case "/":
					c = a / b;
					break;

				}
				stack.push(c);
			}
		}
		if(stack.size()!=1)return ERROR;
		return stack.peek();
	}
	public static double eval(String[] exp) {
		return eval(Arrays.asList(exp));
	}

	public static boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}

	public static boolean isNumber(String s) {
		try {
			double t = Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}

}
