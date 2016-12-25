package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Creates all the buttons that go onto the GUI
 * @author Andrew Vetovitz
 *
 */
public class CreateButtons {
	
	private JButton start, stop, reset;
	
	/**
	 * Creating all the buttons to go onto the panel and placing on the panel
	 * @param panel the panel the buttons will be placed onto
	 * @return a panel with the START, STOP, RESET buttons created
	 */
	CreateButtons(JPanel panel){
		start = new JButton("START");
		start.setEnabled(false);
		start.setFocusPainted(false);
		
		stop = new JButton("STOP");
		stop.setEnabled(false);
		stop.setFocusPainted(false);
		
		reset = new JButton("RESET");
		reset.setEnabled(false);
		reset.setFocusPainted(false);
		
		panel.add(start);
		panel.add(stop);
		panel.add(reset);
	}

	/**
	 * Creates the buttons action listeners
	 * @param press the action listener
	 */
	public void ButtonListener(ActionListener press){
		start.addActionListener(press);
		stop.addActionListener(press);
		reset.addActionListener(press);
	}
	
	/*
	 * Sections return the buttons menus for the action listener
	 */
	
	public JButton returnStart(){
		return this.start;
	}
	
	public JButton returnStop(){
		return this.stop;
	}
	
	public JButton returnReset(){
		return this.reset;
	}
	
	/*
	 * Sections enables or disables all the buttons 
	 */
	
	public void enbableButtons() {
		start.setEnabled(true);
		stop.setEnabled(true);
		reset.setEnabled(true);
	}
	
	public void disableButtons(){
		start.setEnabled(false);
		stop.setEnabled(false);
		reset.setEnabled(false);
	}
}
