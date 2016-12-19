import java.awt.image.BufferedImage;

/**
 * Quadrant class for getting data of quadrant points
 * @author andrew Vetovitz
 *
 */
public class Quadrant {

	/*
	 * Private variables used
	 */
	private int width;
	private int height;
	
	private Point[] quadrants;
	
	/**
	 * Point Class holding and returning the values of a quadrants corner
	 */
	public class Point{
		private int xLeft;
		private int yLeft;
		private int xRight;
		private int yRight;
		
		private int Qwidth;
		private int Qheight;
		
		public int xLeft(){
			return this.xLeft;
		}
		
		public int yLeft(){
			return this.yLeft;
		}
		
		public int xRight(){
			return this.xRight;
		}
		
		public int yRight(){
			return this.yRight;
		}
		
		public int width(){
			return Qwidth;
		}
		
		public int height(){
			return Qheight;
		}
	}
	
	/**
	 * Returns given Buffered Image coordinates from the 4 respective corners of the Buffered Image.
	 * coordinate 1 is created starting at the top left corner and moving clockwise ends at the bottom left corner.
	 * 
	 * @param data Buffered Image to have Quadrant coordinates returned.
	 */
	Quadrant(BufferedImage data){
		//create new point class of the 4 quadrants
		this.quadrants = new Point[4];
		
		//setting data values for image width and height
		this.width = data.getWidth(null);
		this.height = data.getHeight(null);
		
		//for look through and set the 4 quadrants
		for(int i = 0; i < 4; i++){
			quadrants[i] = setQuadrant(i);
		}
	}
	
	Quadrant(QuadTreeNode data){
		//create new point class of the 4 quadrants
		this.quadrants = new Point[4];
		
		//setting data values for image width and height
		this.width = data.returnRoot().getWidth(null);
		this.height = data.returnRoot().getHeight(null);
		
		//for look through and set the 4 quadrants
		for(int i = 0; i < 4; i++){
			quadrants[i] = setQuadrant(i);
		}
	}
	
	/**
	 * Returns the quadrant values of the 4 Points based on the input quadrant number quad
	 * @param quad The quadrant number
	 * @return The quadrant Point coordinates
	 */
	private Point setQuadrant(int quad) {
		Point newQuad = new Point();
		
		switch(quad){
			case 0:{
				newQuad.xLeft = 0;
				newQuad.yLeft =  0;
				newQuad.xRight = width - width / 2;
				newQuad.yRight = height - height / 2;
				
				newQuad.Qwidth = width - width / 2;
				newQuad.Qheight = height - height / 2;
				
				break;
			}
			case 1:{
				newQuad.xLeft = width - width/2;
				newQuad.yLeft = 0;
				newQuad.xRight = width;
				newQuad.yRight = height - height/2;

				newQuad.Qwidth = width / 2;
				newQuad.Qheight = height - height / 2;
				
				break;
			}
			case 2:{
				newQuad.xLeft = width - width / 2;
				newQuad.yLeft = height - height / 2;
				newQuad.xRight = width;
				newQuad.yRight = height;
				
				newQuad.Qwidth = width / 2;
				newQuad.Qheight = height / 2;
				
				break;
			}
			case 3:{
				newQuad.xLeft = 0;
				newQuad.yLeft = height - height / 2;
				newQuad.xRight = width - width / 2;
				newQuad.yRight = height;
				
				newQuad.Qwidth = width - width / 2;
				newQuad.Qheight = height / 2;
				
				break;
			}
			default: {
				System.err.println("Unkown Quadrant Called");
			}
		}
		return newQuad;
	}
	
	/**
	 * @return Return a Point array of Quadrants
	 */
	public Point[] pointArrayOfQuadrants(){
		return quadrants;
	}
}
