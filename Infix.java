import java.util.EmptyStackException;import java.util.StringTokenizer;/* A class that represents and calculates infix expression. COMPSCI 105 Assignment 2 - Part 1 Name:  UPI:      */public class Infix {	// based on pseudocode in programming problem 8 in Chapter 7 of the textbook	public static double evaluateInfix(String infix) {		CalculatorStack<Character> s1 = new CalculatorStack<Character>(); // operator		// stack		CalculatorStack<Double> s2 = new CalculatorStack<Double>(); // operand		// stack		StringTokenizer tokenizer = new StringTokenizer(infix);		try /*			 * To solve the problem, look for exceptions. Return Double.NaN -			 * Not A Number - for values that are not numbers or for empty			 * Stack. Catch divide by zero exceptions. You may use negative			 * infinity to show division by zero on the GUI.			 */		{			while (tokenizer.hasMoreTokens()) {				String token = tokenizer.nextToken();				char ch = token.charAt(0);				if (Character.isDigit(ch)) {					s2.push(valueOf(ch));				} else {					while (!s1.isEmpty()) {						if (ch == ')') {							compute(s2.pop(), s2.pop(), s1.pop());						} else if (precedence(s1.peek()) > precedence(ch)) {							s2.push(compute(s2.pop(), s2.pop(), s1.pop()));							//System.out.print(s2.peek().toString());							s1.push(ch);						} else if (ch == '(') {							continue;						} else {							s1.push(ch);						}					}					s1.push(ch);				}				while (!s1.isEmpty()) {					s2.push(compute(s2.pop(), s2.pop(), s1.pop()));				}			}			/* **********			 * Task 3 complete this section to calculate the infix expression			 */		} // end try		catch (EmptyStackException e) {			System.out.println("");			/* **********			 * Task 3 complete this to return Double.NaN			 */		} catch (ArithmeticException e) {			/* **********			 * Task 3 complete this to return Double.NEGATIVE_INFINITY			 */		}		return s2.pop(); /*						 * ********** DUMMY VALUE TO DEMONSTRATE HOW THE						 * APPLICATION WORKS REPLACE WITH APPROPRIATE RETURN						 * VALUE*********						 */	} // end evaluateInfix	private static int precedence(char operator) {		switch (operator) {		case '(':		case ')':			return 0;		case '+':		case '-':			return 1;		case '*':		case '/':			return 2;		default:			throw new IllegalArgumentException("invalid operator");		}		/*		 * ********** DUMMY VALUE TO DEMONSTRATE HOW THE APPLICATION WORKS		 * REPLACE WITH APPROPRIATE RETURN VALUE*********		 */	} // end precedence	private static double valueOf(char variable) {		switch (variable) {		case '1':			return 1.0;		case '2':			return 2.0;		case '3':			return 3.0;		case '4':			return 4.0;		case '5':			return 5.0;		case '6':			return 6.0;		case '7':			return 7.0;		case '8':			return 8.0;		case '9':			return 9.0;		case '0':			return 0.0;		} // end switch		return 0;	} // end valueOf	private static Double compute(Double operandOne, Double operandTwo,			char operator) {		/* **********		 * Task 2		 */		switch (operator) {		case '+':			return operandOne + operandTwo;		case '-':			return operandOne - operandTwo;		case '*':			return operandOne * operandTwo;		case '/':			return operandOne / operandTwo;		default:			throw new IllegalArgumentException("invalid infix expression");		}		/*		 * ********** DUMMY VALUE TO DEMONSTRATE HOW THE APPLICATION WORKS		 * REPLACE WITH APPROPRIATE RETURN VALUE*********		 */	} // end compute} // end Infix