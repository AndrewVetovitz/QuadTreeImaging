package quadProcessing;

import java.awt.Color;
import java.awt.Graphics;

import quadDataStructure.QuadTreeNode;

public class GraphicsQuadTree{
	
	private Color border;
	
	private Graphics g;
	
	private QuadTreeNode[] tiles;
	
	private boolean skeleton;
	
	private int x, y, width, height;
	
	private int[] xp, yp; 

	public GraphicsQuadTree(boolean skeleton, boolean black, QuadTreeNode[] tiles, Graphics g) {
		this.g = g;
		this.tiles = tiles;
		this.skeleton = skeleton;
		
		if(black){
			this.border = Color.BLACK;
		} else{
			this.border = Color.WHITE;
		}
		
	}

	public void squares() {
		if(this.skeleton){
			for(QuadTreeNode tile : this.tiles){
				g.setColor(tile.getColor());
				
				this.x = tile.returnX();
				this.y = tile.returnY();
				this.width = tile.returnRoot().getWidth();
				this.height = tile.returnRoot().getHeight();
				
				g.fillRect(this.x, this.y, this.width, this.height);
				
				g.setColor(this.border);
				paintSkeleton(g, this.border, this.x, this.y, this.width, this.height);
			}
		}else{
			for(QuadTreeNode tile : this.tiles){
				g.setColor(tile.getColor());
				g.fillRect(tile.returnX(), tile.returnY(), tile.returnRoot().getWidth(), 
						tile.returnRoot().getHeight());
			}
		}
	}

	public void circles() {
		for(QuadTreeNode tile : this.tiles){
			this.x = tile.returnX();
			this.y = tile.returnY();
			this.width = tile.returnRoot().getWidth();
			this.height = tile.returnRoot().getHeight();
			
			g.setColor(this.border);
			g.fillRect(this.x, this.y, this.width, this.height);
			g.setColor(tile.getColor());
			g.fillOval(this.x, this.y, this.width, this.height);
		}
	}

	public void triangles(int direction) {
		for(QuadTreeNode tile : this.tiles){
			this.x = tile.returnX();
			this.y = tile.returnY();
			this.width = tile.returnRoot().getWidth();
			this.height = tile.returnRoot().getHeight();
			
			g.setColor(this.border);
			g.fillRect(this.x, this.y, this.width, this.height);
			g.setColor(tile.getColor());
			fillTrig(g, this.x, this.y, this.width, this.height, direction);
		}
	}

	private void paintSkeleton(Graphics g, Color border, int x, int y, int width, int height) {
		g.drawLine(x, y, x + width - 1, y);
		g.drawLine(x, y, x, y + height - 1);
		g.drawLine(x + width - 1, y, x + width - 1, y + height - 1);
		g.drawLine(x, y + height - 1, x + width, y + height - 1);
	}
	
	private void fillTrig(Graphics g, int x, int y, int width, int height, int direction) {
		xp = new int[3];
		yp = new int[3];
		if(direction == 0){
			xp[0] = x;
			xp[1] = x + width;
			xp[2] = x + width;
			yp[0] = y + height / 2;
			yp[1] = y;
			yp[2] = y + height;
		}else if(direction == 1){
			xp[0] = x;
			xp[1] = x + width / 2;
			xp[2] = x + width;
			yp[0] = y + height;
			yp[1] = y;
			yp[2] = y + height;
		}else if(direction == 2){
			xp[0] = x;
			xp[1] = x;
			xp[2] = x + width;
			yp[0] = y;
			yp[1] = y + height;
			yp[2] = y + height / 2;
		}else{
			xp[0] = x;
			xp[1] = x + width;
			xp[2] = x + width / 2;
			yp[0] = y;
			yp[1] = y;
			yp[2] = y + height;
		}
		
		g.fillPolygon(xp, yp, 3);		
	}
}
