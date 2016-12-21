package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.CreateMenu;

public class Gui extends JFrame  {

	/**
	 * Serialized ID
	 */
	private static final long serialVersionUID = 1L;

	private JPanel left, right, middle, bottom, buttonsBottom, infoBottom;
	
	private JScrollPane middleScroll;
	
	private JLabel pic;
	
	private JButton start, stop, reset;
	
	private JLabel divisions, objects;
	
	private CreateMenu createMenu;
	
	private JMenuBar menuBar;
	
	private BufferedImage origional, current;
	
	private int totalDivisions, totalObjects;
	
	public Gui(){
		setUIManager();
		
		this.setName("Quad");
		
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andrew\\Desktop\\CSE\\Image Processing Project\\Images\\square.jpg");
		
		this.setIconImage(icon);
		
		this.setSize(750, 750);
		
		center();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		buildMenu();
		
		createButtons();
		
		createPanel();
		
		frameLayout();
	}

	//setting window UI Manager
	private void setUIManager() {		
        //FILE stuff
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
		left = new JPanel();
		right = new JPanel();
		middle = new JPanel();
		bottom = new JPanel();
		buttonsBottom = new JPanel();
		infoBottom = new JPanel();
		
		//vertical scroll pane
		middleScroll = new JScrollPane(middle);
		middleScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		middleScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		middleScroll.getVerticalScrollBar().setUnitIncrement(15);
		
		buttonsBottom.add(start);
		buttonsBottom.add(stop);
		buttonsBottom.add(reset);
		
		totalDivisions = 0;
		divisions = new JLabel("Divisions: " + totalDivisions);
		divisions.setFont(new Font("serif", Font.BOLD, 20));
		infoBottom.add(divisions);
		
		totalObjects = 0;
		objects = new JLabel("Objects: " + totalObjects);
		objects.setFont(new Font("serif", Font.BOLD, 20));
		infoBottom.add(objects);
		
		left.setBackground(Color.WHITE);
		right.setBackground(Color.WHITE);
		bottom.setBackground(Color.WHITE);
		buttonsBottom.setBackground(Color.WHITE);
		infoBottom.setBackground(Color.WHITE);
		middle.setBackground(Color.WHITE);
		middleScroll.setBackground(Color.WHITE);
		middleScroll.setBorder(BorderFactory.createEmptyBorder());
	}

	private void createButtons() {
		start = new JButton("START");
		start.setEnabled(false);
		
		stop = new JButton("STOP");
		stop.setEnabled(false);
		
		reset = new JButton("RESET");
		reset.setEnabled(false);
	}

	private void buildMenu() {	
		//creating new menu bar item
		menuBar = new JMenuBar();
		
		//creating menuBar with all the options
		createMenu = new CreateMenu(menuBar);
	
		//setting menu to the JFrame
		this.setJMenuBar(menuBar);
	}
	
	public CreateMenu getCreateMenu(){
		return this.createMenu;
	}
	
	private void frameLayout() {
		//frame layout
		this.setLayout(new BorderLayout());
		
		//buttons layout
		bottom.setLayout(new BorderLayout());
		
		buttonsBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
		infoBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		bottom.add(buttonsBottom, BorderLayout.PAGE_START);
		bottom.add(infoBottom, BorderLayout.PAGE_END);
		
		//panel layout
		this.add(left,	BorderLayout.LINE_START);
		this.add(right, BorderLayout.LINE_END);
		this.add(middleScroll, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.PAGE_END);
	}
	
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

	//get picture stuff
	public BufferedImage getCurrentPicture() {
		return current;
	}

	public void updatePicture(BufferedImage updated) {
		current = updated;
		pic.setIcon(new ImageIcon(updated));
	}
	
	public void updateDivisions(int newDivisions){
		divisions.setText("Divisions: " + newDivisions);
	}
	
	public void updateObjects(int newObjects){
		objects.setText("Total Objects: " + newObjects);
	}
	
	public void setPicture(BufferedImage returnPicture) {
		if(returnPicture == null){
			middle.removeAll();
			updateDivisions(0);
			updateObjects(0);
			disableButtons();
		}else{
			origional = returnPicture;
			current = returnPicture;
			
			pic = new JLabel();
			pic.setIcon(new ImageIcon(origional));
			
			middle.removeAll();
			middle.add(pic);
			
			this.pack();
			
			enbableButtons();
			
			center();
		}
	}
	
	public void resetPicture(){
		pic.setIcon(new ImageIcon(origional));
		current = origional;
		updateDivisions(0);
		updateObjects(0);
	}

	private void center() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setMaximumSize(dimension);
		this.setLocation(dimension.width / 2 - this.getWidth() / 2,
				dimension.height / 2 - this.getHeight() / 2);
		if(this.getLocation().getY() < 0){
			this.setLocation(dimension.width / 2 - this.getWidth() / 2, 
					dimension.height / 2 - this.getHeight() / 2 - (int)this.getLocation().getY());
		}
	}

	private void enbableButtons() {
		start.setEnabled(true);
		stop.setEnabled(true);
		reset.setEnabled(true);
	}
	
	private void disableButtons(){
		start.setEnabled(false);
		stop.setEnabled(false);
		reset.setEnabled(false);
	}
}
