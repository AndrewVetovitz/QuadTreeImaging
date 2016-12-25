package view;

import javax.swing.JOptionPane;

/**
 * Creates the options pane exit dialog when the user wants to exit the program
 * @author Andrew Vetovitz
 *
 */
public class JOptionPaneExit {
	
	private int result;
	
	/**
	 * Constructor unused
	 */
	public JOptionPaneExit(){
	}

	/**
	 * executes the JOptionPane upon calling the exit dialog
	 * @return JOptionPane with yes or no dialog
	 */
	public int dialog() {		
		String ObjButtons[] = {"Yes","No"};
	     result = JOptionPane.showOptionDialog(null, 
	    		 "Would you like to save?", "", 
	    		 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
	    		 ObjButtons, ObjButtons[1]);
		return result;
	}
}
