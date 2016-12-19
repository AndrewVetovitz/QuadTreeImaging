import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageInputOutput {

	ImageInputOutput(){
	}
	
	/**
	 * Reads an input image from file and returns the BufferedImage to the call
	 * @param picture input file path
	 * @return BufferedImage to the call
	 * @throws IOException if image is not able to be opened
	 */
	public static BufferedImage readImage(File picture){
		//creating variables to be used
		BufferedImage img = null;
		
		//try to read input file
		try {
			img = ImageIO.read(picture);
		} catch (IOException e){
			System.out.println("File is not found");
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
	public static void writeImage(BufferedImage picture, File output) {
		
		//writing program to file
		try {
			ImageIO.write(picture, "jpg", output);
		} catch (IOException e) {
			System.err.println("Image cannot be written to file");
			e.printStackTrace();
		}	
	}
}
