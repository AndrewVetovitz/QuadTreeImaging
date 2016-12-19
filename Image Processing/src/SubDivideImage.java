import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.PriorityQueue;

public class SubDivideImage {

	private QuadTreeNode[] newQuads;
	
	private PriorityQueue<QuadTreeNode> toDivide = new PriorityQueue<>(Collections.reverseOrder());
	
	public SubDivideImage(BufferedImage image){
		QuadTreeNode root = new QuadTreeNode(image, 0, 0, 10000);
		toDivide.add(root);
	}
	
	public void oneDivision() {
		QuadTreeNode root = toDivide.poll();
		newQuads = subdivide(root);
		for(int j = 0; j < newQuads.length; j++){
			toDivide.add(newQuads[j]);
		}
		
		while(toDivide.size() > 0 && (toDivide.peek().returnRoot().getWidth() < 2 || 
				toDivide.peek().returnRoot().getHeight() < 2 || toDivide.peek().returnRMS() <= .1)){
			QuadTreeNode remove = toDivide.poll();
			remove.setRMS(0);
			toDivide.add(remove);
		}
	}

	private QuadTreeNode[] subdivide(QuadTreeNode root){			
		int tempOrgWX = root.returnX();
		int tempOrgWY = root.returnY();
		
		QuadTreeNode[] returnRoot = new QuadTreeNode[4];
		
		//creating new quadrant of the data
		Quadrant quads = new Quadrant(root);
		
		ColorProcessing color = new ColorProcessing();
			
		//iterating through and setting all the roots to the new quadrants
		for(int i = 0; i < 4; i++){
			//creating a buffered image of subdivisions
			BufferedImage quad = root.returnRoot().getSubimage(quads.pointArrayOfQuadrants()[i].xLeft(), 
					quads.pointArrayOfQuadrants()[i].yLeft(),
					quads.pointArrayOfQuadrants()[i].width(),
					quads.pointArrayOfQuadrants()[i].height());
				
			QuadTreeNode leaf = new QuadTreeNode(quad, 
					quads.pointArrayOfQuadrants()[i].xLeft() + tempOrgWX,
					quads.pointArrayOfQuadrants()[i].yLeft() + tempOrgWY,
					color.RootMeanDifference(quad));
				
			returnRoot[i] = leaf;
		}
			
		return returnRoot;
	}
	
	public QuadTreeNode[] returnImageData(){
		return newQuads;
	}	
}
