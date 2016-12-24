package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.plaf.basic.BasicMenuBarUI;

public class CreateMenu {
	
	private JMenu file, options, info;
	
	private JMenu space;
	
	private JMenuItem newPage, open, save, exit;
	
	private JMenuItem skeleton, square, circle, triangle, random, black, white;
	private boolean skeletonState, squareState, circleState, triangleState, randomState, blackState, whiteState;
	
	private JMenuItem information, howToUse;
	
	private final ImageIcon newPageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andrew\\Desktop\\CSE\\Image Processing Project\\Images\\page-new-icon.png"));
	
	private final ImageIcon openIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andrew\\Desktop\\CSE\\Image Processing Project\\Images\\folder.png"));
	
	private final ImageIcon saveIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andrew\\Desktop\\CSE\\Image Processing Project\\Images\\Floppy-Small-icon.png"));
	
	private final ImageIcon exitIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andrew\\Desktop\\CSE\\Image Processing Project\\Images\\delete-icon.png"));
	
	private final ImageIcon infoIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andrew\\Desktop\\CSE\\Image Processing Project\\Images\\info.png"));
	
	private final ImageIcon questionIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andrew\\Desktop\\CSE\\Image Processing Project\\Images\\question.png"));
	private final Image questionImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andrew\\Desktop\\CSE\\Image Processing Project\\Images\\question.png");
	
	
	private final ImageIcon checkMarkIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andrew\\Desktop\\CSE\\Image Processing Project\\Images\\tick-icon.png"));
	
	public CreateMenu(JMenuBar menuBar){
		createMenuUI(menuBar);

		//creating a new menu bar tab
		file = new JMenu("File");
		options = new JMenu("Options");
		info = new JMenu("Info");
		
		//creating the items to add to the file JMenu
		createFileItems(file);
		
		createOptionsItems(options);
		
		createInformationItems(info);
		
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

	private void createMenuUI(JMenuBar menuBar) {
		menuBar.setBorderPainted(false);
	    menuBar.setUI(new BasicMenuBarUI(){
	        public void paint (Graphics g, JComponent c)
	        {
	            g.setColor (new Color(236, 240, 241));
	            g.fillRect (0, 0, c.getWidth (), c.getHeight ());
	        }
	    } );
		
		menuBar.setPreferredSize(new Dimension(20, 35));
	}

	private void createFileItems(JMenu file) {
		//creating new JMenu item newPage
		newPage = new JMenuItem("New                Ctrl+N");
		//setting newPage icon
		newPage.setIcon(newPageIcon);
		setNewPageEnabled(false);
		
		//creating new JMenu item OPEN
		open = new JMenuItem("Open              Ctrl+O");
		//setting open icon
		open.setIcon(openIcon);
		
		//creating new JMenu item SAVE
		save = new JMenuItem("Save As          Ctrl+S");
		//setting save icon
		save.setIcon(saveIcon);
		setSaveEnabled(false);
		
		//creating new JMenu item EXIT
		exit = new JMenuItem();
		exit.setText("Exit                 Ctrl+X");
		//setting Exit icon
		exit.setIcon(exitIcon);
		
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
		skeleton = new JMenuItem("Skeleton");
		
		//creating new JMneuu item SQUARE
		square = new JMenuItem("Square");
		
		//creating new JMneuu item CIRCLE
		circle = new JMenuItem("Circle");
		
		//creating new JMneuu item TRIANGLE
		triangle = new JMenuItem("Triangle");
		
		//creating new JMneu item RANDOM
		random = new JMenuItem("Random");
		
		//creating new JMenu item BLACK BACKGROUND
		black = new JMenuItem("Black BackGround");
		
		//creating new JMenu item WHITE BACKGROUND
		white = new JMenuItem("White BackGround");
		
		//adding Jmenu items to options
		options.add(skeleton);
		
		options.addSeparator();
		
		options.add(square);
		
		options.add(circle);
		
		options.add(triangle);
		
		options.add(random);
		
		options.addSeparator();
		
		options.add(black);
		
		options.add(white);
		
		setInitialOptions();
		
		setOptionsEnabled(false);
	}
	
	private void createInformationItems(JMenu info) {
		//creating new JMenu item INFO
		information = new JMenuItem("Info");
		information.setIcon(infoIcon);
		
		//creating new JMenu item HOW TO USE
		howToUse = new JMenuItem("How To Use");
		howToUse.setIcon(questionIcon);
				
		//adding JMenu items to info
		info.add(information);
		
		info.addSeparator();
		
		info.add(howToUse);
	}
	
	public void openJFileMenu(){
		file.doClick();
	}
	
	public void openJOptionsMenu() {
		options.doClick();
	}
	
	private final void setInitialOptions() {
		setSkeletonState(false);
		setSquareState(true);
		setCircleState(false);
		setTriangleState(false);
		setRandomState(false);
		setBlackState(true);
		setWhiteState(false);
	}
	
	private final void addSpace(JMenuBar menuBar) {
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
		square.addActionListener(press);
		circle.addActionListener(press);
		triangle.addActionListener(press);
		random.addActionListener(press);
		black.addActionListener(press);
		white.addActionListener(press);
	}
	
	//info action listener
	public void InfoListener(ActionListener press){
		information.addActionListener(press);
		howToUse.addActionListener(press);
	}
	
	//GETTERS & SETTERS
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
	
	public JMenuItem getHelp(){
		return this.howToUse;
	}
	
	//setting newPageEnabled
	public void setNewPageEnabled(boolean state) {
		this.newPage.setEnabled(state);
	}
	
	//setting saveEnabled
	public final void setSaveEnabled(boolean state){
		this.save.setEnabled(state);
	}
	
	//get option items
	//**SKELETON**//
	public JMenuItem getSkeleton(){
		return this.skeleton;
	}
		
	public boolean getSkeletonState(){
		return this.skeletonState;
	}
	
	public final void setSkeletonState(boolean state){
		this.skeletonState = state;
		if(state){
			this.skeleton.setIcon(checkMarkIcon);
		}else{
			this.skeleton.setIcon(null);
		}
	}
	
	//**SQUARE**//
	public JMenuItem getSquare(){
		return this.square;
	}
		
	public boolean getSquareState(){
		return this.squareState;
	}
	
	public final void setSquareState(boolean state){
		this.squareState = state;
		if(state){
			this.square.setIcon(checkMarkIcon);
		}else{
			this.square.setIcon(null);
		}
	}
	
	//**CIRLCE**//
	public JMenuItem getCircle(){
		return this.circle;
	}
		
	public boolean getCircleState(){
		return this.circleState;
	}
	
	public final void setCircleState(boolean state){
		this.circleState = state;
		if(state){
			this.circle.setIcon(checkMarkIcon);
		}else{
			this.circle.setIcon(null);
		}
	}
	
	//**TRIANGLE**//
	public JMenuItem getTriangle(){
		return this.triangle;
	}
		
	public boolean getTriangleState(){
		return this.triangleState;
	}
	
	public final void setTriangleState(boolean state){
		this.triangleState = state;
		if(state){
			this.triangle.setIcon(checkMarkIcon);
		}else{
			this.triangle.setIcon(null);
		}
	}
	
	//**RANDOM**//
	public JMenuItem getRandom(){
		return this.random;
	}
		
	public boolean getRandomState(){
		return this.randomState;
	}
	
	public final void setRandomState(boolean state){
		this.randomState = state;
		if(state){
			this.random.setIcon(checkMarkIcon);
		}else{
			this.random.setIcon(null);
		}
	}
	
	//**BLACKBACKGROUND**//
	public JMenuItem getBlack(){
		return this.black;
	}
		
	public boolean getBlackState(){
		return this.blackState;
	}
	
	public final void setBlackState(boolean state){
		this.blackState = state;
		if(state){
			this.black.setIcon(checkMarkIcon);
		}else{
			this.black.setIcon(null);
		}
	}
	
	//**WHIEBACKGROUND**//
	public JMenuItem getWhite(){
		return this.white;
	}
		
	public boolean getWhiteState(){
		return this.whiteState;
	}
	
	public final void setWhiteState(boolean state){
		this.whiteState = state;
		if(state){
			this.white.setIcon(checkMarkIcon);
		} else{
			this.white.setIcon(null);
		}
	}

	public void setOptionsEnabled(boolean state) {
		this.skeleton.setEnabled(state);
		this.square.setEnabled(state);
		this.circle.setEnabled(state);
		this.triangle.setEnabled(state);
		this.random.setEnabled(state);
		this.white.setEnabled(state);
		this.black.setEnabled(state);
	}

	public boolean[] getOptions() {
		boolean[] options = {this.skeletonState, this.squareState,
				this.circleState, this.triangleState, this.randomState,
				this.blackState, this.whiteState};
		return options;
	}
	
	public Image getQuestionIcon(){
		return this.questionImage;
	}
}
