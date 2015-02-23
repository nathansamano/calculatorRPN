/*
 * Nathan Samano
 * October 30, 2013 (Sophomore Year)
 * Project 2: Perform calculations using the postfix method of evaluating expressions 
 * aka Reverse Polish Notation Calculator
 */
public class Calculation {

	public static final int SIZE = 50;		// maximum characters
	public static final boolean DEBUG = false;	// used for debugging purposes
	
	Stack expression = new Stack(SIZE);		// take user input and use with a stack
	
	private double pop1;		// popped value
	private double pop2;		// popped value
	private double pushChar;	// character that will be pushed onto stack
	private Boolean valid;      	// state whether or not input is valid
	
	public Calculation() { // zero arg constructor initialization
		pop1 = 0;
		pop2 = 0;
		pushChar = 0;
		valid = false;
	} // constructor
	
	public Calculation(String userString) {	// one arg constructor
		if (userString.length() <= SIZE) {
			char[] charArray = userString.toCharArray();  // convert userInput string to charArray of individual characters
			String temp = new String();  // create temporary string to store characters
			for (int i=0; i < userString.length(); i++) { // numbers ' ', operators
				if ((charArray[i] >= '0' && charArray[i] <= '9') || charArray[i]== ' ' || 
				     charArray[i] == '+' || charArray[i] == '-' || charArray[i] == '*' || 
				     charArray[i] == '/') { // put integer in temp
					temp = temp + charArray[i];
					valid = true;
				}
				else { // print error if another character is entered
					System.out.println("Error: invalid characters");
					valid = false;
					break;
				}
			}
			if (DEBUG) {
				System.out.println("Before conversion to charArray: " + temp); // test the value of temp
			}
			charArray = temp.toCharArray(); // put valid characters back into charArray
			if (DEBUG) {
				System.out.println("After Conversion to charArray:  " + temp); // test the value of temp
			}
			if (valid) {
				for (int i=0; i < charArray.length; i++) {
					if (charArray[i] >= '0' && charArray[i] <= '9') { // if number
						pushChar = charArray[i] - '0';  // convert char to int
						try {
							expression.Push(pushChar);	// Push number onto stack
						} catch (Exception e) {
							valid = false;
							break;
						}
					}
					else {	// if +-*/
						try {
							pop1 = expression.Pop();	// pop top 2 numbers off and execute operation
							pop2 = expression.Pop();
						} catch (Exception e){
							valid = false;
							break;
						}
						switch (charArray[i]) { // operations
							case '+':	pushChar = pop2 + pop1;
										break;
							case '-':	pushChar = pop2 - pop1;
										break;
							case '*':  	pushChar = pop2 * pop1;
										break;
							case '/':  	if (pop1 != 0) { // cannot divide by 0
											pushChar = pop2 / pop1;
											break;
										}
										else {
											valid = false;
											System.out.println("undefined");
											break;
										}
							default: 	System.out.println("Error");
										break;
						} // switch
						expression.Push(pushChar); // put the answer back onto the stack
					} // else
				} // for
			} // if
			else { // invalid
				System.out.println("Error");
				valid = false;
			}
		} // if
		else { // exceeding max characters
			System.out.println("Error");
			valid = false;
		}
	} // constructor
	
	public void setValid(boolean newValid) { 	// needed so Stack.java can set valid
		valid = newValid;
	}
	
	public String toString() {
		String output = new String();
		if (valid && expression.getTop()==0) { // if the final answer is not at top=0 then invalid postfix expression
			if (DEBUG) {
				output = "Pop1: " + pop1 + "\nPop2: " + pop2 + "\nAnswer: " + pushChar;
			}
			else {
				output = "Answer: " + pushChar;
			}
		}
		else {
			output = "Error";
		}
		return output;
	}
	
	public static void main(String[] args) { // just for testing purposes
		Calculation one = new Calculation();
		System.out.println(one);
	}
} // class
