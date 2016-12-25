package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpGui {
	private final JDialog help;
	
	private final JPanel helpPanel;
	
	private final JLabel textLabel;
	
	private final String pL = "<p class=\"tab\">";
	
	private final String pR = "</p>";
	
	private final String helpText = "<br>" 
			+ pL + "To use the program upload any image from file." + pR + "<br>"
			+ pL + "Begin by setting your settings." + pR + "<br>"
			+ pL + "<u>Settings</u>:" + pR
			+ pL + "<u>Skeleton</u>: Use this to create a wire frame around each image division." + pR
			+ "<br>"
			+ pL + "<u>Objects</u>: " + pR
			+ pL + "<u>Square</u>: Division objects will be of type square." + pR 
			+ pL + "<u>Circle</u>: Division objects will be of type circle." + pR
			+ pL + "<u>Triangle</u>: Division objects will be of type triangle." + pR
			+ pL + "You can choose the direction of the triangle direction to be left, right, up, down." + pR
			+ "<br>"
			+ pL + "<u>BackGround</u>:" + pR
			+ pL + "<u>Black BackGround</u>: Set the background color behind the image to be black." + pR
			+ pL + "<u>White BackGround</u>: Set the background color behind the image to be white." + pR
			+ "<br>"
			+ pL + "Refer to the git page under info to see example and read about the Algorithms behind this project." + pR
			+ "<br>";
	
	HelpGui(Gui gui, CreateMenu createMenu){
		//creating new JDialog
		help = new JDialog(gui, "How To Use", ModalityType.DOCUMENT_MODAL);
		
		help.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		help.setIconImage(createMenu.getQuestionIcon());
		
		//Creating helpPanel and Layout to go on top of JDialog
		helpPanel = new JPanel();
		
		helpPanel.setLayout(new BorderLayout());
		
		//Creating JLabel to go on top of JPanel. textLabel contains the text the user reads
		textLabel = new JLabel("<html><head>" 
				+ "<style type=\"text/css\"><!--.tab { margin-left: 15px; margin-right:20px; }--></style>"
				+ "</head><div style='text-align: justify;'>" + helpText + "</div></html>");
		
		textLabel.setBackground(Color.WHITE);
		
		textLabel.setFont(new Font("serif", Font.BOLD, 20));
		
		//adding text to the helpPanel;
		helpPanel.add(textLabel, BorderLayout.PAGE_START);
		
		helpPanel.setBackground(new Color(236, 240, 241));
		
		//adding helpPanel to the JDialog help
		help.add(helpPanel);
		
		//setting JDialog to the center of the main JFrame
		help.pack();
		
		int x = (int)(gui.getLocation().getX() + gui.getSize().getWidth() / 2 - help.getWidth() / 2);
		int y = (int)(gui.getLocation().getY() + gui.getSize().getHeight() / 2 - help.getHeight() / 2);
		
		help.setLocation(x, y);
		
		//Rendering the JFrame into view
		help.setVisible(true);
	}
}
