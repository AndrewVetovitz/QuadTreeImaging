public class MainQuadTreeProgram {
	
	public static void main(String[] args){
		//new frame and graphics
		Gui gui = new Gui();
		
		//data input and construction
		QuadTreeModel qModel = new QuadTreeModel();
		
		//new controller for model and gui
		new QuadTreeController(gui, qModel);
		
		//make frame visible
		gui.setVisible(true);
	}
}
