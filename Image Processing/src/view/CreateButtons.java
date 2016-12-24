package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CreateButtons {
	
	private JButton start, stop, reset;
	
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

	//buttons action listener
	public void ButtonListener(ActionListener press){
		start.addActionListener(press);
		stop.addActionListener(press);
		reset.addActionListener(press);
	}
	
	//return button items
	public JButton returnStart(){
		return this.start;
	}
	
	public JButton returnStop(){
		return this.stop;
	}
	
	public JButton returnReset(){
		return this.reset;
	}
	
	//enable buttons
	public void enbableButtons() {
		start.setEnabled(true);
		stop.setEnabled(true);
		reset.setEnabled(true);
	}
	
	//disable buttons
	public void disableButtons(){
		start.setEnabled(false);
		stop.setEnabled(false);
		reset.setEnabled(false);
	}
}
