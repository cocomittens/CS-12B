/* Name: Corrie Gripnestraw
 * ID: 1381682
 * Class: CMPS 12B
 * Date: Oct 29, 2014
 * Filename: Calc.java
 * Description: Calculates operations using Reverse Polish Notation
 */

// Calc.java
// Define a class for doing RPN.

import java.lang.Exception; 
public class Calc {
	private int max;
	private double[] stackArray;
	private int top;
	private double first, second;
    // Constructor
    public Calc() {
	max = 100;
	stackArray = new double[max];
	top= -1;
    }

    // Push a number
    public void push(double x) {
	stackArray[++top] = x;
    }

    // Pop top number (removes)
    public double pop() {
        return stackArray[top--];
    }

    // Peek at top number (does not remove)
    public double peek() {
        return stackArray[top];
    }

    // Add top two numbers
    public void add() throws ArithmeticException{
	first = pop();
	second = pop();
	push(first+second);
    }

    // Subtract top two numbers (top on right side)
    public void subtract() throws ArithmeticException {
	first = pop();
	second = pop();
	push(second-first);
    }

    // Multiply top two numbers
    public void multiply() throws ArithmeticException{
	first = pop();
	second = pop();
	push(first*second);
    }

    // Divide top two numbers (top on bottom)
    public void divide() throws ArithmeticException{
	first = pop();
	second = pop();
	push(second/first);
    }

    // Calculate reciprocal of a number
    public void reciprocal() throws ArithmeticException{
	first = pop();
	push((1.0)/first);
   } 
    // Return how many numbers are in the stack
    public int depth() {
        return top+1;
    }
    
 

}
