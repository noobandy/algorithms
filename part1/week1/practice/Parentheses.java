import java.util.Stack;
import java.util.Scanner;

public class Parentheses {
	
	private static boolean isOperator(String token) {
		token = token.trim();
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%");
	}

	private static boolean isOpenParentheses(String token) {
		token = token.trim();
		return token.equals("(");
	}

	private static boolean isCloseParentheses(String token) {
		token = token.trim();
		return token.equals(")");
	}

    public static void main(String[] args) {
        	Scanner s = new Scanner(System.in);

        	Stack<String> operands = new Stack<>();
        	Stack<String> operators = new Stack<>();

        	while(s.hasNext()) {
        		String token = s.next();

        		if(isOperator(token)) {
        			operators.push(token);

        		} else if(isCloseParentheses(token)) {
        			String operand1 = operands.pop();
        			String operand2 = operands.pop();
        			String operator = operators.pop();
        			StringBuilder sb = new StringBuilder();
        			sb.append("(").append(" ").append(operand2).append(" ").
        			append(operator).append(" ").append(operand1).append(" ").
        			append(")");
        			operands.push(sb.toString());

        		} else {
        			operands.push(token);
        		}

        	}

        	System.out.format("%s%n", operands.pop());
    }
}