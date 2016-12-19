import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFileChooser;

public class QuadTreeController {

	private Gui gui;
	private QuadTreeModel qModel;
	
	 public QuadTreeController(Gui gui, QuadTreeModel qModel){
		 this.gui = gui;
		 this.qModel = qModel;
		 
		 this.gui.menuListener(new menuListener());
		 this.gui.ButtonListener(new buttonListener());
	 }
	 
	 class menuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == gui.returnExit()){
				gui.dispose();
				System.exit(0);
			}else if(e.getSource() == gui.returnOpen()){
				JFileChooser fileChooser = new JFileChooser();
			
				int value = fileChooser.showOpenDialog(gui);
				if(value == JFileChooser.APPROVE_OPTION){
					qModel.setPicture(fileChooser.getSelectedFile());
					gui.setPicture(qModel.returnPicture());
				}
			} else if(e.getSource() == gui.returnInformation()){
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/AndrewVetovitz"));
				} catch (IOException e1) {
					System.out.println("IO Exception in website input");
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					System.out.println("Wrong website name");
					e1.printStackTrace();
				}
			}
		} 
	 }
	 
	 class buttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == gui.returnStart()){
				qModel.startDivisions();
			} else if(e.getSource() == gui.returnStop()){
				qModel.stopDivisions();
			} else if(e.getSource() == gui.returnReset()){
				gui.resetPicture();
			}
		} 
	 }
}
