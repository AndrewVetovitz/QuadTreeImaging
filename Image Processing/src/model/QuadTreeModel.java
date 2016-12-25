package model;
import java.awt.image.BufferedImage;

import FileIO.ImageInputOutput;
import view.Gui;

public class QuadTreeModel {
	
	private ProcessingData processdata;
	
	private BufferedImage image;
	
	final int size = 1024;

	private boolean[] options;
	
	public QuadTreeModel(){
	}
	
	public boolean openPicture(Gui gui){
		if(gui == null){
			processdata = new ProcessingData();
			image = null;
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
	
	public boolean divideOnce() {
		return processdata.subdivide();	
	}
	

	public void resetPicture() {
		processdata = new ProcessingData();
		processdata.setData(image);
		processdata.setOptions(this.options);
	}
	
	//getters
	public BufferedImage getUpdatedPicture(){
		return processdata.getImage();
	}
	
	public int getTotalDivisions(){
		return processdata.getTotalDivisions();
	}

	public void setOptions(boolean[] options) {
		this.options = options;
		processdata.setOptions(this.options);
	}
}
