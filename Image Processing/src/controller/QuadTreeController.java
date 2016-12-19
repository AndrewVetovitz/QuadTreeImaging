package controller;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Timer;

import model.QuadTreeModel;
import view.Gui;

public class QuadTreeController {
	
	private Gui gui;
	
	private QuadTreeModel qModel;
	
	private Timer timer;
	
	//30 frames per second
	private int delay = 1000/30;
	
	private boolean resume = false;
	
	 public QuadTreeController(Gui gui, QuadTreeModel qModel){
		 this.gui = gui;
		 this.qModel = qModel;
		 
		 this.gui.menuListener(new menuListener());
		 this.gui.ButtonListener(new buttonListener());
	 }
	 
	 class menuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == gui.returnExit()){
				gui.dispose();
				System.exit(0);
			}else if(e.getSource() == gui.returnOpen()){
				if(qModel.openPicture(gui)){
					gui.setPicture(qModel.returnPicture());
					resume = false;
				}
			}else if(e.getSource() == gui.returnSave()){
				qModel.savePicture(gui, qModel.getUpdatedPicture());
			} else if(e.getSource() == gui.returnInformation()){
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
					resume = true;
					timer = new Timer(delay, updateFrame);
					timer.start();
				} else{
					timer.start();
				}
			} else if(e.getSource() == gui.returnStop()){
				timer.stop();
			} else if(e.getSource() == gui.returnReset()){
				timer.stop();
				qModel.resetPicture();
				gui.resetPicture();
				resume = false;
			}
		} 
	 }
	 
	  ActionListener updateFrame = new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
				qModel.divideOnce();
				gui.updatePicture(qModel.getUpdatedPicture());
				gui.updateDivisions(qModel.getTotalDivisions());
				gui.updateObjects(qModel.getTotalObjects());
	      }
	  };
}
