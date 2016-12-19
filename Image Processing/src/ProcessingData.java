import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.PriorityQueue;

public class ProcessingData implements Runnable {

	private Thread divider;
	
	boolean pause;
	
	private PriorityQueue<QuadTreeNode> toDivide = new PriorityQueue<>(Collections.reverseOrder());
	
	public ProcessingData(){
	}
	
	public QuadTreeNode[] dataToQuadTreeNode(BufferedImage data, int divisions){
		//creates new quadTreeNode
		QuadTreeNode root = new QuadTreeNode(data, 0, 0, 10000);
		
		//adding root to the heap of the priority queue
		toDivide.add(root);
		
		//creating the quadTreeHeap
		createTree(divisions);
		
		//creates a printable quadTreeNode from heap
		QuadTreeNode[] printable = toDivide.toArray(new QuadTreeNode[0]);
		
		return printable;
	}
	
	
	private void createTree(int divisions) {
		for(int i = 0; i < divisions && toDivide.size() > 0; i++){
			QuadTreeNode root = toDivide.poll();
			QuadTreeNode[] newQuads = subdivide(root);
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void start(){
		divider = new Thread(this);
		pause = false;
		
		divider.start();
	}
	
	public void stop(){
		pause = true;
	}
	
	public void resume(){
		pause = false;
	}
}
