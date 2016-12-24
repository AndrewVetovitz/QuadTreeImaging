package controller;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import model.QuadTreeModel;
import view.CreateButtons;
import view.CreateMenu;
import view.Gui;
import view.JOptionPaneExit;

public class QuadTreeController {
	
	private final Gui gui;
	
	private JRootPane root;
	
	private NewFile keyNew;
	
	private SaveFile keySave;
	
	private final CreateMenu createMenu;
	
	private final CreateButtons createButtons;
	
	private final QuadTreeModel quadTreeModel;
	
	private JOptionPaneExit yesOrNo;
	
	private Timer timer;
	
	//30 frames per second
	private final int FPS = 60;
	
	private int totalDivisions, result;
	
	private boolean resume = false;
	
	private boolean started = false;
	
	public QuadTreeController(Gui gui, QuadTreeModel qModel){
		 this.gui = gui;
		 this.createMenu = gui.getCreateMenu();
		 this.createButtons = gui.getCreateButtons();
		 this.quadTreeModel = qModel;
		 
		 this.createMenu.FileListener(new fileListener());
		 this.createButtons.ButtonListener(new buttonListener());
		 this.createMenu.OptionListener(new optionListener());
		 this.createMenu.InfoListener(new infoListener());
		 this.gui.addWindowListener(new closeListener());
		 
		 addKeyListener(gui);
	 }
	 
		public void addKeyListener(JFrame gui){
			// Component that you want listening to your key
			root = gui.getRootPane();
			
			keyNew = new NewFile();
			keySave = new SaveFile();
			
			keyNew.setEnabled(false);
			keySave.setEnabled(false);
			
			root.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK),
		            "NewFile");
			root.getActionMap().put("NewFile",
								keyNew);
			
			root.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK),
			                    "OpenFile");
			root.getActionMap().put("OpenFile",
								new OpenFile());
			
			root.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK),
		            "SaveFile");
			root.getActionMap().put("SaveFile",
								keySave);

			root.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK),
		        "CloseProgram");
			root.getActionMap().put("CloseProgram",
								new ExitProgram());
		}
	 
	 class fileListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == createMenu.getNewPage()){
				gui.setPicture(null);
				quadTreeModel.openPicture(null);
				createMenu.setOptionsEnabled(false);
				createMenu.setNewPageEnabled(false);
				createMenu.setSaveEnabled(false);
				keyNew.setEnabled(false);
				keySave.setEnabled(false);
				createMenu.openJFileMenu();
			}else if(e.getSource() == createMenu.getOpen()){
				if(quadTreeModel.openPicture(gui)){
					gui.setPicture(quadTreeModel.returnPicture());
					resume = false;
					if(started){
						timer.stop();
					}
					started = false;
					createMenu.setOptionsEnabled(true);
					createMenu.setNewPageEnabled(true);
					createMenu.setSaveEnabled(true);
					keyNew.setEnabled(true);
					keySave.setEnabled(true);
				}
			}else if(e.getSource() == createMenu.getSave()){
				quadTreeModel.savePicture(gui, gui.getCurrentPicture());
			}else if(e.getSource() == createMenu.getExit()){
				gui.dispatchEvent(new WindowEvent(gui, WindowEvent.WINDOW_CLOSING));
			}
		} 
	 }
	 
	 class optionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == createMenu.getSkeleton()){
					createMenu.setSkeletonState(!createMenu.getSkeletonState());
				} else if(e.getSource() == createMenu.getSquare()){
					if(createMenu.getCircleState() == true ||	
							createMenu.getTriangleState() == true || 
							createMenu.getRandomState() == true){
						createMenu.setSquareState(!createMenu.getSquareState());
					}
				}else if(e.getSource() == createMenu.getCircle()){
					if(createMenu.getSquareState() == false &&
							createMenu.getTriangleState() == false && 
							createMenu.getRandomState() == false){
						createMenu.setSquareState(true);
					}
					createMenu.setCircleState(!createMenu.getCircleState());
				}else if(e.getSource() == createMenu.getTriangle()){
					if(createMenu.getSquareState() == false &&
							createMenu.getCircleState() == false && 
							createMenu.getRandomState() == false){
						createMenu.setSquareState(true);
					}
					createMenu.setTriangleState(!createMenu.getTriangleState());
				}else if(e.getSource() == createMenu.getRandom()){
					if(createMenu.getSquareState() == false &&
							createMenu.getCircleState() == false && 
							createMenu.getTriangleState() == false){
						createMenu.setSquareState(true);
					}
					createMenu.setRandomState(!createMenu.getRandomState());
				}else if(e.getSource() == createMenu.getBlack()){
					createMenu.setBlackState(true);
					createMenu.setWhiteState(false);
				}else if(e.getSource() == createMenu.getWhite()){
					createMenu.setWhiteState(!createMenu.getWhiteState());
					if(createMenu.getWhiteState()){
						createMenu.setBlackState(false);
					}else{
						createMenu.setBlackState(true);
					}
				}
				createMenu.openJOptionsMenu();
			}
		 }
	 
	 class infoListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == createMenu.getInformation()){
					try {
						Desktop.getDesktop().browse(new URI("https://github.com/AndrewVetovitz/QuadTreeImaging"));
					} catch (IOException e1) {
						System.out.println("IO Exception in website input");
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						System.out.println("Wrong website name");
						e1.printStackTrace();
					}
				}else if(e.getSource() == createMenu.getHelp()){
					gui.CreateHelp();
				}
			}
		 }
	 
	 class buttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == createButtons.returnStart()){
				if(!resume){
					quadTreeModel.setOptions(createMenu.getOptions());
					resume = true;
					started = true;
					createMenu.setOptionsEnabled(false);
					timer = new Timer(1000/FPS, updateFrame);
					timer.start();
				} else{
					timer.start();
				}
			} else if(e.getSource() == createButtons.returnStop()){
				timer.stop();
			} else if(e.getSource() == createButtons.returnReset()){
				if(timer.isRunning()){
					timer.stop();
					quadTreeModel.resetPicture();
					gui.resetPicture();
					resume = true;
					timer = new Timer(1000/FPS, updateFrame);
					timer.start();
				}else{
					quadTreeModel.resetPicture();
					gui.resetPicture();
					resume = false;
				}
				createMenu.setOptionsEnabled(true);
			}
		} 
	 }
	 
	 class closeListener extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			 if(quadTreeModel.returnPicture() == null){
				 System.exit(0);
			 }else{
				 yesOrNo = new JOptionPaneExit();
				 result = yesOrNo.dialog();
			     if(result == 1){
			    	 System.exit(0);
			     } else if(result == 0){
			    	 quadTreeModel.savePicture(gui, gui.getCurrentPicture());
			     }
			 }
		 }
	 }

	class NewFile extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			gui.setPicture(null);
			quadTreeModel.openPicture(null);
			createMenu.setOptionsEnabled(false);
			createMenu.setNewPageEnabled(false);
			createMenu.setSaveEnabled(false);
			keyNew.setEnabled(false);
			keySave.setEnabled(false);
		}
	}	
	
	class OpenFile extends AbstractAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(quadTreeModel.openPicture(gui)){
				gui.setPicture(quadTreeModel.returnPicture());
				resume = false;
				if(started){
					timer.stop();
				}
				started = false;
				createMenu.setOptionsEnabled(true);
				createMenu.setNewPageEnabled(true);
				createMenu.setSaveEnabled(true);
				keyNew.setEnabled(true);
				keySave.setEnabled(true);
			}
		}	
	}
	
	class SaveFile extends AbstractAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			quadTreeModel.savePicture(gui, gui.getCurrentPicture());
		}	
	}
	
	class ExitProgram extends AbstractAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			gui.dispatchEvent(new WindowEvent(gui, WindowEvent.WINDOW_CLOSING));
		}	
	}
	 
	ActionListener updateFrame = new ActionListener() {
	     public void actionPerformed(ActionEvent e) {
    	  	quadTreeModel.divideOnce();
			gui.updatePicture(quadTreeModel.getUpdatedPicture());
			totalDivisions = quadTreeModel.getTotalDivisions();
			gui.updateDivisions(totalDivisions);
			gui.updateObjects(1 + totalDivisions * 3);
	     }
	  };
}
