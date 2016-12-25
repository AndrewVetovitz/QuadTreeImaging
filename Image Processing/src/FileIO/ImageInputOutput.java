package FileIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import view.Gui;

public class ImageInputOutput {

	ImageInputOutput(){
	}
	
	/**
	 * Reads an input image from file and returns the BufferedImage to the call
	 * @param gui input file path
	 * @return BufferedImage to the call
	 * @throws IOException if image is not able to be opened
	 */
	public static BufferedImage readImage(Gui gui){
		//creating variables to be used
		BufferedImage img = null;
		
		JFileChooser reader = new JFileChooser("C:\\Users\\Andrew\\Desktop");
		
		reader.setFileFilter(new PictureFilter());
		
		int value = reader.showOpenDialog(gui);
		if(value == JFileChooser.APPROVE_OPTION){
			//try to read input file
			try {
				img = ImageIO.read(reader.getSelectedFile());
			} catch (IOException e){
				System.out.println("File is not found");
			}
		}
	
		//return BufferedImage to call
		return img;
	}
	
	/**
	 * Writes an Image to output file
	 * @param url input file url
	 * @param data1 input bufferedImage
	 * @throws IOException if Image cannot be written to file
	 */
	public static void writeImage(Gui gui, BufferedImage picture) {
		JFileChooser reader = new JFileChooser("C:\\Users\\Andrew\\Desktop");
		reader.setFileFilter(new PictureFilter());
		
		int value = reader.showSaveDialog(gui);
		if(value == JFileChooser.APPROVE_OPTION){
			//getting the output file
			File file = reader.getSelectedFile();
			//writing program to file
			if(!file.toString().endsWith(".png") && !file.toString().endsWith(".jpg") 
					&& !file.toString().endsWith(".raw") && !file.toString().endsWith(".gif")
					&& !file.toString().endsWith(".jpeg") && !file.toString().endsWith(".bmp")){
				file = 	new File(file.toString() + ".png");
			}
			
			String extension = file.toString().substring(file.toString().indexOf(".") + 1);
			
			try {
				if(!ImageIO.write(picture, extension.toUpperCase(), file)){
					throw new RuntimeException("Cannot write extension");
				}
			} catch (IOException e) {
				System.err.println("Image cannot be written to file");
				e.printStackTrace();
			}
		}
	}
}
