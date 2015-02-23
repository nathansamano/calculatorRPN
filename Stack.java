/*
 * Nathan Samano
 * October 30, 2013 (Sophmore Year)
 * Project 2: Implementation of a Stack
 */
public class Stack {

	public static final boolean DEBUG = false;		// used for debugging purposes
	public static final double ERROR_VALUE = 55555;		// error value to use with boolean
	
	private int size;	// size of stack
	private int top;	// top index value of stack
	private double[] data;	// data array of stack
	Calculation temp;	// used to change validity of an expression from Push & Pop
	
	public Stack(int sizeOfStack) {
		size = sizeOfStack;	// when object is created allow for argument to set the size of the stack
		top = -1;		// initialize top to -1
		data = new double[size];	// initialize data[]
		for (int i=0; i<size; i++) {
			data[i] = 0;
		}
	}
		
	////////////////////////////////////////
	
	public boolean Push(double value) {	// add to stack
		if (top == size-1) {
			if (DEBUG) {
				System.out.println("OVERFLOW ERROR!");
			}
			temp.setValid(false);	// make valid false
			return false;  // ** overflow error **
		}
		else {
			top++;			// increment top
			data[top] = value;	// store that value in a variable
			if (DEBUG) {
				System.out.println("A Push has occured.");
			}
			return true;  // push operation successful
		}
	}
	
	////////////////////////////////////////

	public double Pop() {	// remove from stack
		if (top == -1) {
			if (DEBUG) {
				System.out.println("UNDERFLOW ERROR!");
			}
			temp.setValid(false);	// make valid false
			return ERROR_VALUE;  // ** underflow error **
		}
		else {
			int topLocation = top;  // topLocation is an integer
			if (DEBUG) {
				data[top] = 0.0;  // reset to 0.0 to show value was popped off
			}
			top--;	// decrement top
			if (DEBUG) {
				System.out.println("A Pop has occured");
				System.out.println("topLocation = " + topLocation);
			}
			return data[topLocation];
		}
	}
	
	////////////////////////////////////////
	
	public boolean isEmpty() { // determine if the stack is empty or not
		if (top == -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	////////////////////////////////////////

	public boolean isFull() { // determine if the stack is empty or not
		if (top == size - 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	////////////////////////////////////////
	
	public int getTop() {	// get top of the stack
		return top;
	}
	
	////////////////////////////////////////
	
	public String getData() {			// parses data to a printable string
		String str = new String();		// temp string to hold values of data
		for (int i=0; i<size; i++) {
			str = str + data[i] + " ";
		}
		return str;
	}
	
	////////////////////////////////////////

	public String toString() { // print out current value of top and all items in the stack
		String output = "Top = " + top + "\n" + "Stack: " + getData() + "\n";
		String emptyFull = "Full: " + isFull() + "\nEmpty: " + isEmpty() + "\n";
		if (DEBUG) {
			return output + emptyFull;
		}
		else {
			return output;
		}
	}
	
	////////////////////////////////////////
	
	public static void main(String[] args) { // test all functions
		Stack one = new Stack(2);
		System.out.println(one);
	}
}
