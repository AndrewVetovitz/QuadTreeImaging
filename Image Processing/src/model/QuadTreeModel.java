package model;
import java.awt.image.BufferedImage;

import FileIO.ImageInputOutput;
import view.Gui;

public class QuadTreeModel {
	
	private ProcessingData processdata;
	
	private BufferedImage image;
	
	final int size = 1024;
	
	public QuadTreeModel(){
	}
	
	public boolean openPicture(Gui gui){
		if(gui == null){
			processdata = new ProcessingData();
		}else{
			image = ImageInputOutput.readImage(gui);
			if(image != null){
				processdata = new ProcessingData();
				image = Resize.scaleImage(image, size);
				processdata.setData(image);
				return true;
			}
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
		processdata = new ProcessingData();
		processdata.setData(image);
	}
	
	//getters
	public BufferedImage getUpdatedPicture(){
		return processdata.getImage();
	}
	
	public int getTotalDivisions(){
		return processdata.getTotalDivisions();
	}

	public void setOptions(boolean returnSkeletonState) {
		processdata.setOptions(returnSkeletonState);
	}
}
