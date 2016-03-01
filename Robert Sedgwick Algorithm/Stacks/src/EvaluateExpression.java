import java.util.Scanner;
import java.util.Stack;


public class EvaluateExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String exp = cin.nextLine();
		
		double result = evaluateExpression(exp);
		System.out.println(result);
	}
	
	public static double evaluateExpression(String exp){
		Stack<String> operator = new Stack<String>();
		Stack<Double> values = new Stack<Double>();
	
		for(int i = 0; i < exp.length(); ++i){
			String ch = exp.charAt(i)+"";
			if(ch.equals(")")){
				double num1 = values.pop();
				double num2 = values.pop();
				double r = eval(num1, num2, operator.pop());
				values.push(r);
			} else if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") || ch.equals("%")){
				operator.push(ch);
				
			} else if(ch.equals("(")){
				
			} else{
				values.push(Double.parseDouble(ch));
			}
		}
		
		return values.pop();
	}

	public static double eval(double num1, double num2, String op){
		if(op.equals("+")){
			return num1+num2;
		}
		
		if(op.equals("*")){
			return num1*num2;
		}
		
		if(op.equals("-")){
			return num2-num1;
		}
		
		if(op.equals("/")){
			return num2/num1;
		}
		
		if(op.equals("%")){
			return num2%num1;
		}
		
		return 0;
	}
}
