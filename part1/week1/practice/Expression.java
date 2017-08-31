import java.util.Scanner;
import java.util.Stack;

public class Expression {

	private static boolean hasHigerPrecedense(String operator1, String operator2) {
		operator1 = operator1.trim();
		operator2 = operator2.trim();

		int operator1Precedence = -1;
		int operator2Precedence = -1;

		if(operator1.equals("(")) {
			operator1Precedence = 3;
		} else if(operator1.equals("*") || operator1.equals("/") || operator1.equals("%")) {
			operator1Precedence = 2;
		} else {
			operator1Precedence = 1;
		}

		if(operator2.equals("(")) {
			operator2Precedence = 3;
		} else if(operator2.equals("*") || operator2.equals("/") || operator2.equals("%")) {
			operator2Precedence = 2;
		} else {
			operator2Precedence = 1;
		}

		return operator1Precedence >= operator2Precedence;

	}

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

	private static double evaluate(double operand1, double operand2, String operator) {
		operator = operator.trim();
		double result = 0;

		switch(operator) {
			case "+":
				result = operand1 + operand2;
			break;
			case "-":
				result = operand1 - operand2;
			break; 
			case "*":
				result = operand1 * operand2;
			break;
			case "/":
				result = operand1 / operand2;
			break;
			case "%":
				result = operand1 % operand2;
			break;
			default: 
			break;
		}

		return result;
	}

	public static String inFixToPostFix(String expression) {
		Stack<String> operators = new Stack<>();
		Stack<String> operands = new Stack<>();

		String[] tokens = expression.split(" ");

		for(String token : tokens) {

			if(isOpenParentheses(token)) {
				operators.push(token);
			} else if(isCloseParentheses(token)){
				String operand1 = operands.pop();
				String operand2 = operands.pop();
				String operator = operators.pop();
				// pop open parentheses
				operators.pop();

				StringBuilder sb = new StringBuilder();

				sb.append(operand2).append(" ").append(operand1).append(" ").append(operator);

				operands.push(sb.toString());

			} else if(isOperator(token)) {
				if(!operators.isEmpty() && !isOpenParentheses(operators.peek()) && hasHigerPrecedense(operators.peek(),token)) {
					String operand1 = operands.pop();
					String operand2 = operands.pop();
					String operator = operators.pop();

					StringBuilder sb = new StringBuilder();

					sb.append(operand2).append(" ").append(operand1).append(" ").append(operator);

					operands.push(sb.toString());
				}
				
				operators.push(token);
			} else {
				operands.push(token);
			}
		}

		String postfixExpression = null;

		

		if(!operators.isEmpty() && !operands.isEmpty()) {
			StringBuilder postfixExpressionBuilder = new StringBuilder();
			while(!operators.isEmpty() && !operands.isEmpty()) {
				String operand1 = operands.pop();
				String operand2 = operands.pop();
				String operator = operators.pop();

				postfixExpressionBuilder.append(operand2).append(" ").append(operand1).append(" ").append(operator).append(" ");
			}
			postfixExpression = postfixExpressionBuilder.toString().trim();
		} else {
			postfixExpression = operands.pop();
		}
		

		return postfixExpression;
	}

	public static double evaluatePostfix(String expression) {

		Stack<Double> operands = new Stack<>();

		String[] tokens = expression.split(" ");

		for(String token : tokens) {
			if(isOperator(token)) {
				Double operand1 = operands.pop();
				Double operand2 = operands.pop();

				operands.push(evaluate(operand2, operand1, token));

			} else {
				operands.push(Double.valueOf(token));
			}
		}

		return operands.pop();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while(s.hasNext()) {
			String expression = s.nextLine();
			String postfix = inFixToPostFix(expression);
			double result = evaluatePostfix(postfix);

			System.out.format("postfix of %s is %s and it evaluates to %f%n", expression, postfix, result);
		}
		
	}
}