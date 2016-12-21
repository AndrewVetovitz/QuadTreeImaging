package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.plaf.basic.BasicMenuBarUI;

public class CreateMenu {
	
	private JMenu file, options, info;
	
	private JMenu space;
	
	private JMenuItem newPage, open, save, exit;
	
	private JMenuItem skeleton;
	private boolean skeletonState;
	
	private JMenuItem information;
	
	public CreateMenu(JMenuBar menuBar){
	    menuBar.setUI(new BasicMenuBarUI()
	    {
	        public void paint (Graphics g, JComponent c)
	        {
	            g.setColor (new Color(236, 240, 241));
	            g.fillRect (0, 0, c.getWidth (), c.getHeight ());
	        }
	    } );
		
		
		menuBar.setPreferredSize(new Dimension(20, 35));

		//creating a new menu bar tab
		file = new JMenu("File");
		options = new JMenu("Options");
		info = new JMenu("Info");
		
		//creating the items to add to the file JMenu
		createFileItems(file);
		
		createOptionsItems(options);
		
		createInformationItems(information);
		
		//adding JMenus to menuBar
		//adding FILE
		menuBar.add(file);
	
		//add space between menus
		addSpace(menuBar);
		
		//adding OPTIONS
		menuBar.add(options);
		
		//add space between menus
		addSpace(menuBar);
		
		//adding INFO
		menuBar.add(info);
	}

	private void createFileItems(JMenu file) {
		//creating new JMenu item OPEN
		newPage = new JMenuItem();
		newPage.setText("New");		
		
		//creating new JMenu item OPEN
		open = new JMenuItem();
		open.setText("Open");
				
		//creating new JMenu item SAVE
		save = new JMenuItem();
		save.setText("Save");
		
		//creating new JMenu item EXIT
		exit = new JMenuItem();
		exit.setText("Exit");
		
		//adding JMenu items to file
		file.add(newPage);
		
		file.addSeparator();
		
		file.add(open);
				
		file.addSeparator();
		
		file.add(save);
		
		file.addSeparator();
				
		file.add(exit);		
	}
	
	private void createOptionsItems(JMenu options) {
		//creating new JMneuu item SKELETON
		skeleton = new JMenuItem();
		skeleton.setText("Skeleton");
		
		//adding Jmenu items to options
		options.add(skeleton);
	}
	
	private void createInformationItems(JMenuItem information2) {
		//creating new JMenu item INFO
		information = new JMenuItem();
		information.setText("Info");
				
		//adding JMenu items to info
		info.add(information);
	}
	
	private void addSpace(JMenuBar menuBar) {
		//adding SPACE
		//creating new space JMenu
		space = new JMenu(" ");
		space.setEnabled(false);
		menuBar.add(space);
	}

	//ACTION LISTENERS
	//file action listener
	public void FileListener(ActionListener press){
		newPage.addActionListener(press);
		open.addActionListener(press);
		save.addActionListener(press);
		exit.addActionListener(press);
	}
	
	//options action listener
	public void OptionListener(ActionListener press){
		skeleton.addActionListener(press);
	}
	
	//info action listener
	public void infoListener(ActionListener press){
		information.addActionListener(press);
	}
	
	//get file items
	public JMenuItem getNewPage(){
		return this.newPage;
	}
	
	public JMenuItem getOpen() {
		return this.open;
	}
	
	public JMenuItem getSave() {
		return this.save;
	}
	
	public JMenuItem getExit(){
		return this.exit;
	}

	//get information items
	public JMenuItem getInformation() {
		return this.information;
	}
	
	//get option items
	//**SKELETON**//
	public JMenuItem getSkeleton(){
		return this.skeleton;
	}
		
	public boolean getSkeletonState(){
		return this.skeletonState;
	}
		
	public void setSkeletonState(boolean state){
		this.skeletonState = state;
	}
}
