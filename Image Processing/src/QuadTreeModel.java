import java.awt.image.BufferedImage;
import java.io.File;

public class QuadTreeModel {
	
	private ProcessingData subDivdeImage;
	
	private BufferedImage image;
	
	QuadTreeModel(){
	}
	
	public void setPicture(File picture){		
		image = ImageInputOutput.readImage(picture);
		subDivdeImage = new ProcessingData(image);
	}

	public void savePicture(BufferedImage picture, File output){
		ImageInputOutput.writeImage(picture, output);
	}
	
	public BufferedImage returnPicture(){
		return image;
	}
	
	public void divideOnce() {
		subDivdeImage.subdivide();	
	}
	
	public BufferedImage getUpdatedPicture(){
		return subDivdeImage.getImage();
	}

	public void resetPicture() {
		subDivdeImage = new ProcessingData(image);
	}
}
