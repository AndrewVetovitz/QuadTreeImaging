package model;
import java.awt.image.BufferedImage;

import quadDataStructure.QuadTreeNode;
import quadProcessing.QuadTreeGraphics;
import quadProcessing.SubDivideImage;

public class ProcessingData {

	private SubDivideImage subdivideImage;
	
	private QuadTreeGraphics graphics;
	
	private BufferedImage output;
	
	private QuadTreeNode[] data;
	
	public ProcessingData() {
	}
	
	public void setData(BufferedImage image){
		subdivideImage = new SubDivideImage(image);
		output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		graphics = new QuadTreeGraphics();
	}
	
	public void subdivide(){
		subdivideImage.oneDivision();
		data = subdivideImage.returnImageData();
		output = graphics.drawBufferedImage(data, output);
	}

	public BufferedImage getImage() {	
		return output;
	}

	public int getTotalDivisions() {
		return subdivideImage.returnTotalDivisions();
	}

	public void setOptions(boolean returnSkeletonState) {
		graphics.setOptionSkeleton(returnSkeletonState);
	}
}
