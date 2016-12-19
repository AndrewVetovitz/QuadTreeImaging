import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Gui extends JFrame  {

	/**
	 * Serialized ID
	 */
	private static final long serialVersionUID = 1L;

	private JPanel middle, bottom;
	
	private JLabel pic;
	
	private JLabel divisions;
	
	private JButton start, stop, reset;
	
	private JMenuBar menuBar;
	
	private JMenu file, info, space;
	
	private JMenuItem open, save, exit, information;
	
	private BufferedImage origional;
	
	Gui(){
		setUIManager();
		
		this.setName("Quad");
		
		this.setSize(750, 750);
		
		center();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		createMenu();
		
		createButtons();
		
		createPanel();
		
		frameLayout();
	}

	//setting window UI Manager
	private void setUIManager() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			System.out.println("UI Manager Failed");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.out.println("UI Manager Failed");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("UI Manager Failed");
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			System.out.println("UI Manager Failed");
			e.printStackTrace();
		}
	}

	private void createPanel() {
		middle = new JPanel();
		bottom = new JPanel();
		
		bottom.add(start);
		bottom.add(stop);
		bottom.add(reset);
		
		divisions = new JLabel("Divisions: ");
		divisions.setFont(new Font("serif", Font.BOLD, 20));
		bottom.add(divisions);
		
		bottom.setBackground(Color.WHITE);
		middle.setBackground(Color.WHITE);
	}

	private void createButtons() {
		start = new JButton("START");
		start.setEnabled(false);
		
		stop = new JButton("STOP");
		stop.setEnabled(false);
		
		reset = new JButton("RESET");
		reset.setEnabled(false);
	}

	private void createMenu() {	
		//creating new menu bar item
		menuBar = new JMenuBar();
		
		menuBar.setPreferredSize(new Dimension(20, 35));
		menuBar.setBackground(Color.gray);
		menuBar.setBorderPainted(true);
		
		menuBar.setOpaque(true);
		menuBar.setBackground(Color.GREEN);

		//creating a new menu bar tab
		file = new JMenu("File");
		info = new JMenu("Info");
		
		//creating new JMenu item OPEN
		open = new JMenuItem();
		open.setText("Open");
		
		//creating new JMenu item SAVE
		save = new JMenuItem();
		save.setText("Save");
		
		//creating new JMenu item EXIT
		exit = new JMenuItem();
		exit.setText("Exit");
		
		//creating new JMenu item INFO
		information = new JMenuItem();
		information.setText("Info");
		
		//adding JMenu items to file
		file.add(open);
		
		file.addSeparator();
		
		file.add(save);
		
		file.addSeparator();
		
		file.add(exit);
		
		//adding JMenu items to info
		info.add(information);
		
		//adding JMenus to menuBar
		menuBar.add(file);
		
		//adding space
		space = new JMenu("");
		space.setEnabled(false);
		menuBar.add(space);
		
		menuBar.add(info);
	
		//setting menu to the JFrame
		this.setJMenuBar(menuBar);
	}
	
	private void frameLayout() {
		//frame layout
		this.setLayout(new BorderLayout());
		
		//buttons layout
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//panel layout
		this.add(middle, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);
	}

	void menuListener(ActionListener press){
		//first menu
		open.addActionListener(press);
		save.addActionListener(press);
		exit.addActionListener(press);

		//first second menu
		information.addActionListener(press);
	}
	
	void ButtonListener(ActionListener press){
		start.addActionListener(press);
		stop.addActionListener(press);
		reset.addActionListener(press);
	}
	
	//return menu items
	public JMenuItem returnOpen() {
		return this.open;
	}
	
	public JMenuItem returnSave() {
		return this.save;
	}
	
	public JMenuItem returnExit(){
		return this.exit;
	}

	public JMenuItem returnInformation() {
		return this.information;
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

	public void updatePicture(BufferedImage updated) {
		pic.setIcon(new ImageIcon(updated));
	}
	
	public void setPicture(BufferedImage returnPicture) {
		origional = returnPicture;
		
		pic = new JLabel();
		pic.setIcon(new ImageIcon(origional));
		
		middle.removeAll();
		middle.add(pic);
		
		this.pack();
		
		enbableButtons();
		
		center();
	}
	
	public void resetPicture(){
		pic.setIcon(new ImageIcon(origional));
	}

	private void center() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dimension.width / 2 - this.getWidth() / 2,
				dimension.height / 2 - this.getHeight() / 2);
	}

	private void enbableButtons() {
		start.setEnabled(true);
		stop.setEnabled(true);
		reset.setEnabled(true);
	}
}
