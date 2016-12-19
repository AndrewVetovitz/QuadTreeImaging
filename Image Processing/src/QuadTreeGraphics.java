import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class QuadTreeGraphics {

	QuadTreeNode[] data;
	boolean skeleton;
	
	public QuadTreeGraphics(QuadTreeNode[] tiles) {
		this.data = tiles;
	}

	public BufferedImage drawBufferedImage(BufferedImage data1) {	
		ColorProcessing average = new ColorProcessing();
		
		Graphics g = data1.createGraphics();
		
		if(this.skeleton){
			for(QuadTreeNode s : data){
					Color test = average.AverageColor(s.returnRoot());
					g.setColor(test);
					g.fillRect(s.returnX(), s.returnY(), s.returnRoot().getWidth() - 1, s.returnRoot().getHeight() - 1);
			}
		}else{
			for(QuadTreeNode s : data){
				Color test = average.AverageColor(s.returnRoot());
				g.setColor(test);
				g.fillRect(s.returnX(), s.returnY(), s.returnRoot().getWidth(), s.returnRoot().getHeight());
			}	
		}
	
		
		return data1;
	}

	public void setOptionSkeleton(boolean skeleton) {
		this.skeleton = skeleton;
	}
	
	
//	Graphics g = data1.createGraphics();
//	
//	ColorProcessing average = new ColorProcessing();
}
