package startProgram;

import controller.QuadTreeController;
import model.QuadTreeModel;
import view.Gui;

/**
 * QuadTree Image Processing Project main class
 * @author Andrew
 *
 */
public class MainQuadTreeProgram {
	
	public static void main(String[] args){
		//new frame and graphics
		Gui gui = new Gui();
		
		//data input and construction
		QuadTreeModel qModel = new QuadTreeModel();
		
		//new controller for model and gui
		new QuadTreeController(gui, qModel);
		
		//make frame visible after components have loaded
		gui.setVisible(true);
	}
}
