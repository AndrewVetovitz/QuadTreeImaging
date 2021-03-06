package quadDataStructure;
import java.awt.Color;
import java.awt.image.BufferedImage;

import quadProcessing.ColorProcessing.ColorData;

public class QuadTreeNode implements Comparable<QuadTreeNode> {

	private BufferedImage root;
	
	private int startX;
	private int startY;
	
	private double weightedError;
	
	private Color averageColor;
	
	private static int printArraySize = 0;
	
	private QuadTreeNode[] children;
	
	private QuadTreeNode quad1 = null;
	
	private QuadTreeNode quad2 = null;

	private QuadTreeNode quad3 = null;

	private QuadTreeNode quad4 = null;
	
	public QuadTreeNode(BufferedImage data, int x, int y, ColorData info){
		this.root = data;
		this.startX = x;
		this.startY = y;
		
		this.averageColor = info.getAverageColor();
		this.weightedError = info.getWeightedError();
	
		children = new QuadTreeNode[4];
		
		children[0] = this.quad1;
		children[1] = this.quad2;
		children[2] = this.quad3;
		children[3] = this.quad4;
	}
	
	public int numberOfChildren(){
		return 4;
	}
	
	public BufferedImage returnRoot(){
		return this.root;
	}
	
	public int returnX(){
		return this.startX;
	}
	
	public int returnY(){
		return this.startY;
	}
	
	public double getRMS(){
		return this.weightedError;
	}
	
	public Color getColor(){
		return this.averageColor;
	}
	
	public void setRMS(double rms){
		this.weightedError = rms;
	}
	
	public int numberOfLeafs(){
		int leafs = 0;
		
		if(!this.hasChildren()){
			leafs = 1;
		} else{
			for(int i = 0; i < this.numberOfChildren(); i++){
				leafs += this.child(i).numberOfLeafs();
			}
		}
		
		return leafs;
	}
	
	public boolean hasChildren(){
		return children[0] != null;
	}
	
	public QuadTreeNode[] children(){
		return this.children;
	}
	
	public QuadTreeNode child(int i){
		return children[i];
	}
	
	public void setChild(QuadTreeNode value, int child){
		children[child] = value;
	}
	
	private void returnLeafs(QuadTreeNode[] leafs) {
		
		if(this.hasChildren()){
			for(int i = 0; i < this.numberOfChildren(); i++){
				this.child(i).returnLeafs(leafs);
			}
		} else{
			leafs[printArraySize] = this;
			printArraySize++;
		}
	}
	
	public QuadTreeNode[] printValues(){
		int size = this.numberOfLeafs();
		
		System.out.println(size);
		
		QuadTreeNode[] printers = new QuadTreeNode[size];
		
		this.returnLeafs(printers);
		
		return printers;
	}

	@Override
	public int compareTo(QuadTreeNode n) {
		if((this.weightedError - n.weightedError) > .0001){
			return 1;
		} else{
			return -1;
		}
	}
	
	public String toString(){
		return String.valueOf(this.getRMS());
	}
}
