package model;
import java.awt.image.BufferedImage;

import quadDataStructure.QuadTreeNode;
import quadProcessing.QuadTreeGraphics;
import quadProcessing.SubDivideImage;

public class ProcessingData {

	private SubDivideImage divide;
	
	private QuadTreeGraphics graphics;
	
	private BufferedImage output;
	
	private QuadTreeNode[] data;
	
	public ProcessingData(BufferedImage image) {
		divide = new SubDivideImage(image);
		output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_BGR);
		graphics = new QuadTreeGraphics();
	}
	
	public void subdivide(){
		divide.oneDivision();
		data = divide.returnImageData();
		output = graphics.drawBufferedImage(data, output);
	}

	public BufferedImage getImage() {	
		return output;
	}

	public int getTotalDivisions() {
		return divide.returnTotalDivisions();
	}

	public int getTotalObjects() {
		return divide.returnTotalObjects();
	}
}
