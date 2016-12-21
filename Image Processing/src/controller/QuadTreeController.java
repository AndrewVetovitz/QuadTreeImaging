package controller;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Timer;

import model.QuadTreeModel;
import view.CreateMenu;
import view.Gui;

public class QuadTreeController {
	
	private Gui gui;
	
	private CreateMenu createMenu;
	
	private QuadTreeModel quadTreeModel;
	
	private Timer timer;
	
	//30 frames per second
	private final int FPS = 60;
	
	private int totalDivisions;
	
	private boolean resume = false;
	
	 public QuadTreeController(Gui gui, QuadTreeModel qModel){
		 this.gui = gui;
		 this.createMenu = gui.getCreateMenu();
		 this.quadTreeModel = qModel;
		 
		 this.createMenu.FileListener(new fileListener());
		 this.gui.ButtonListener(new buttonListener());
		 this.createMenu.OptionListener(new optionListener());
		 this.createMenu.infoListener(new infoListener());
	 }
	 
	 class fileListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == createMenu.getNewPage()){
				gui.setPicture(null);
				quadTreeModel.openPicture(null);
			}else if(e.getSource() == createMenu.getOpen()){
				if(quadTreeModel.openPicture(gui)){
					gui.setPicture(quadTreeModel.returnPicture());
					resume = false;
				}
			}else if(e.getSource() == createMenu.getSave()){
				quadTreeModel.savePicture(gui, gui.getCurrentPicture());
			}else if(e.getSource() == createMenu.getExit()){
				gui.dispose();
				System.exit(0);
			}
		} 
	 }
	 
	 class optionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == createMenu.getSkeleton()){
					if(createMenu.getSkeletonState()){
						createMenu.setSkeletonState(false);
						System.out.println("skeleton FALSE");
					} else{
						createMenu.setSkeletonState(true);
						System.out.println("skeleton TRUE");
					}
				}
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
				}
			}
		 }
	 
	 class buttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == gui.returnStart()){
				if(!resume){
					quadTreeModel.setOptions(createMenu.getSkeletonState());
					resume = true;
					timer = new Timer(1000/FPS, updateFrame);
					timer.start();
				} else{
					timer.start();
				}
			} else if(e.getSource() == gui.returnStop()){
				timer.stop();
			} else if(e.getSource() == gui.returnReset()){
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
			}
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
