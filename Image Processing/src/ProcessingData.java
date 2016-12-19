import java.awt.image.BufferedImage;

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
}
