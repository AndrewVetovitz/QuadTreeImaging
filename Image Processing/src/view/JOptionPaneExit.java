package view;

import javax.swing.JOptionPane;

public class JOptionPaneExit {
	
	private int result;
	
	public JOptionPaneExit(){
		
	}

	public int dialog() {		
		String ObjButtons[] = {"Yes","No"};
	     result = JOptionPane.showOptionDialog(null, 
	    		 "Would you like to save?", "", 
	    		 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
	    		 ObjButtons, ObjButtons[1]);
		return result;
	}
}
