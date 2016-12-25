package model;
import java.awt.image.BufferedImage;

import quadDataStructure.QuadTreeNode;
import quadProcessing.QuadTreePrinting;
import quadProcessing.SubDivideImage;

public class ProcessingData {

	private SubDivideImage subdivideImage;
	
	private QuadTreePrinting printing;
	
	private BufferedImage output;
	
	private QuadTreeNode[] data;
	
	public ProcessingData() {
	}
	
	public void setData(BufferedImage image){
		subdivideImage = new SubDivideImage(image);
		output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		printing = new QuadTreePrinting();
	}
	
	public boolean subdivide(){
		if(subdivideImage.oneDivision()){
			data = subdivideImage.returnImageData();
			output = printing.drawBufferedImage(data, output);
			return true;
		}else{
			return false;
		}
	}

	public BufferedImage getImage() {	
		return output;
	}

	public int getTotalDivisions() {
		return subdivideImage.returnTotalDivisions();
	}

	public void setOptions(boolean[] options) {
		printing.setOptions(options);
	}
}
