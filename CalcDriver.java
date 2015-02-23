import javax.swing.JOptionPane;

/*
 * Nathan Samano
 * October 30, 2013 (Sophomore Year)
 * Project 2: Driver class for Calculation.java
 */
public class CalcDriver {

	public static void main(String[] args) {
		while (true) {
			String userInput = JOptionPane.showInputDialog(null, "Enter a postfix expression.\nType 'exit' to exit the program.");		// string used to hold user input
			if (userInput.equals("exit")) { // exit
				System.exit(0);
			}
			Calculation expression = new Calculation(userInput);	// use user string and make a calculation with it
		
			JOptionPane.showMessageDialog(null, expression, "Answer", JOptionPane.INFORMATION_MESSAGE, null);
		}
	} 
}
