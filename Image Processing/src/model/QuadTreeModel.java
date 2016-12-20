package model;
import java.awt.image.BufferedImage;

import FileIO.ImageInputOutput;
import view.Gui;

public class QuadTreeModel {
	
	private ProcessingData processdata;
	
	private BufferedImage image;
	
	public QuadTreeModel(){
	}
	
	public boolean openPicture(Gui gui){
		image = ImageInputOutput.readImage(gui);
		if(image != null){
			processdata = new ProcessingData(image);
			return true;
		}
		return false;
	}

	public void savePicture(Gui gui, BufferedImage picture){
		ImageInputOutput.writeImage(gui, picture);
	}
	
	public BufferedImage returnPicture(){
		return image;
	}
	
	public void divideOnce() {
		processdata.subdivide();	
	}
	

	public void resetPicture() {
		processdata = new ProcessingData(image);
	}
	
	//getters
	public BufferedImage getUpdatedPicture(){
		return processdata.getImage();
	}
	
	public int getTotalDivisions(){
		return processdata.getTotalDivisions();
	}
	
	public int getTotalObjects(){
		return processdata.getTotalObjects();
	}
}
