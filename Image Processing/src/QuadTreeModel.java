import java.awt.image.BufferedImage;
import java.io.File;

public class QuadTreeModel {
	
	private ProcessingData divisions;;
	
	private BufferedImage image;
	
	QuadTreeModel(){
//		//processing quadTree
//		ProcessingData processed = new ProcessingData();
//				
//		QuadTreeNode[] tiles = processed.dataToQuadTreeNode(data, divisions);
//				
//		QuadTreeGraphics graphics = new QuadTreeGraphics(tiles);
//				
//		graphics.setOptionSkeleton(skeleton);
//		data1 = graphics.drawBufferedImage(data1);
		
		//making sure program ran successfully
		System.out.println("sucess Create Model");
	}
	
	public void setPicture(File picture){		
		this.image = ImageInputOutput.readImage(picture);
	}
	
	public void savePicture(BufferedImage picture, File output){
		ImageInputOutput.writeImage(picture, output);
	}
	
	public BufferedImage returnPicture(){
		return image;
	}
	
	public void startDivisions()  {
		divisions = new ProcessingData();
		divisions.start();
	}

	public void stopDivisions() {
		divisions.stop();
	}
	
	public void resumeDivisions(){
		divisions.resume();
	}
	
	//BufferedImage divideImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_BGR);		
	

}
