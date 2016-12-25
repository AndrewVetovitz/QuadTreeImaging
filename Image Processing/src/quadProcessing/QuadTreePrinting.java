package quadProcessing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import quadDataStructure.QuadTreeNode;

public class QuadTreePrinting {
	
	private GraphicsQuadTree printing;
	
	private Graphics g;
	
	private boolean skeleton;
	
	private boolean square;
	
	private boolean circle;
	
	private boolean left, right, up, down;
	
	private int direction;
	
	private boolean black;
	
	public QuadTreePrinting() {
	}

	public BufferedImage drawBufferedImage(QuadTreeNode[] tiles, BufferedImage output) {
		g = output.createGraphics();
		//tiles only has a size of 4
		printing = new GraphicsQuadTree(skeleton, black, tiles, g);
		
		if(left){
			direction = 0;
		}else if(right){
			direction = 2;
		}else if(up){
			direction = 1;
		}else if(down){
			direction = 3;
		}
		
		if(square){
			printing.squares();
		}else if(circle){
			printing.circles();
		}else{
			printing.triangles(direction);
		}
			
		g.dispose();
		
		return output;
	}

	public void setOptions(boolean[] options) {
		this.skeleton = options[0];
		this.square = options[1];
		this.circle = options[2];
		this.left = options[3];
		this.right = options[4];
		this.up = options[5];
		this.down = options[6];
		this.black = options[7];
	}
}
