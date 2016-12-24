package quadProcessing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import quadDataStructure.QuadTreeNode;

public class QuadTreeGraphics {
	
	private boolean skeleton = false;
	
	public QuadTreeGraphics() {
	}

	public BufferedImage drawBufferedImage(QuadTreeNode[] tiles, BufferedImage output) {
		Graphics g = output.createGraphics();
		
		if(this.skeleton){
			for(QuadTreeNode tile : tiles){
					Color test = tile.getColor();
					g.setColor(test);
					g.fillRect(tile.returnX(), tile.returnY(), 
							tile.returnRoot().getWidth() - 1, tile.returnRoot().getHeight() - 1);
			}
		}else{
			for(QuadTreeNode tile : tiles){
				Color test = tile.getColor();
				g.setColor(test);
				g.fillRect(tile.returnX(), tile.returnY(), 
						tile.returnRoot().getWidth(), tile.returnRoot().getHeight());
			}	
		}
		
		g.dispose();
		
		return output;
	}

	public void setOptionSkeleton(boolean[] states) {
		for(int i = 0; i < states.length; i++){
			//TODO fix this whole method
		}
		this.skeleton = false;
	}
}
