import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class QuadTreeGraphics {
	
	private boolean skeleton = false;
	
	public QuadTreeGraphics() {
	}

	public BufferedImage drawBufferedImage(QuadTreeNode[] tiles, BufferedImage output) {
		ColorProcessing average = new ColorProcessing();
		
		Graphics g = output.createGraphics();
		
		if(this.skeleton){
			for(QuadTreeNode tile : tiles){
					Color test = average.AverageColor(tile.returnRoot());
					g.setColor(test);
					g.fillRect(tile.returnX(), tile.returnY(), 
							tile.returnRoot().getWidth() - 1, tile.returnRoot().getHeight() - 1);
			}
		}else{
			for(QuadTreeNode tile : tiles){
				Color test = average.AverageColor(tile.returnRoot());
				g.setColor(test);
				g.fillRect(tile.returnX(), tile.returnY(), 
						tile.returnRoot().getWidth(), tile.returnRoot().getHeight());
			}	
		}

		return output;
	}

	public void setOptionSkeleton(boolean skeleton) {
		this.skeleton = skeleton;
	}
}
