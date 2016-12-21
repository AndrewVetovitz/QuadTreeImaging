package quadProcessing;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.PriorityQueue;

import quadDataStructure.QuadTreeNode;
import quadDataStructure.QuadTreeQuadrant;

public class SubDivideImage {

	private QuadTreeNode[] newQuads;
	
	private ColorProcessing color;
	
	private int totalDivisions;
	
	private PriorityQueue<QuadTreeNode> toDivide;
	
	public SubDivideImage(BufferedImage image){
		color = new ColorProcessing();
		QuadTreeNode root = new QuadTreeNode(image, 0, 0, color.computeColor(image));
		totalDivisions = 0;
		toDivide = new PriorityQueue<>(Collections.reverseOrder());
		toDivide.add(root);
	}
	
	public void oneDivision() {
		totalDivisions++;
		QuadTreeNode root = toDivide.poll();
		newQuads = subdivide(root);
		for(int j = 0; j < newQuads.length; j++){
			toDivide.add(newQuads[j]);
		}
		
		while(toDivide.size() > 0 && (toDivide.peek().returnRoot().getWidth() < 4 || 
				toDivide.peek().returnRoot().getHeight() < 4 || toDivide.peek().getRMS() <= .1)){
			QuadTreeNode remove = toDivide.poll();
			remove.setRMS(0);
			toDivide.add(remove);
		}
	}

	private QuadTreeNode[] subdivide(QuadTreeNode root){
		//will return a QuadTreeNode of 4 quadTree children per division
		QuadTreeNode[] returnRoot = new QuadTreeNode[4];
		
		//creating new quadrant of the data
		QuadTreeQuadrant quads = new QuadTreeQuadrant(root);
			
		//iterating through and setting all the roots to the new quadrants
		for(int i = 0; i < 4; i++){
			//creating a buffered image of subdivisions
			BufferedImage quad = root.returnRoot().getSubimage(quads.pointArrayOfQuadrants()[i].xLeft(), 
					quads.pointArrayOfQuadrants()[i].yLeft(),
					quads.pointArrayOfQuadrants()[i].width(),
					quads.pointArrayOfQuadrants()[i].height());
				
			QuadTreeNode leaf = new QuadTreeNode(quad, 
					quads.pointArrayOfQuadrants()[i].xLeft() + root.returnX(),
					quads.pointArrayOfQuadrants()[i].yLeft() + root.returnY(),
					color.computeColor(quad));
				
			returnRoot[i] = leaf;
		}
		return returnRoot;
	}
	
	public QuadTreeNode[] returnImageData(){
		return newQuads;
	}

	public int returnTotalDivisions() {
		return totalDivisions;
	}
}
