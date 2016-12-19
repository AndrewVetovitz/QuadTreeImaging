package model;
import java.awt.image.BufferedImage;

import FileIO.ImageInputOutput;
import view.Gui;

public class QuadTreeModel {
	
	private ProcessingData subDividedImage;
	
	private BufferedImage image;
	
	public QuadTreeModel(){
	}
	
	public boolean openPicture(Gui gui){
		image = ImageInputOutput.readImage(gui);
		if(image != null){
			subDividedImage = new ProcessingData(image);
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
		subDividedImage.subdivide();	
	}
	

	public void resetPicture() {
		subDividedImage = new ProcessingData(image);
	}
	
	//getters
	public BufferedImage getUpdatedPicture(){
		return subDividedImage.getImage();
	}
	
	public int getTotalDivisions(){
		return subDividedImage.getTotalDivisions();
	}
	
	public int getTotalObjects(){
		return subDividedImage.getTotalObjects();
	}
}
