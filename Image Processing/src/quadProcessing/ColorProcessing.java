package quadProcessing;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Processes an image based on color
 */
public class ColorProcessing {
	//constructor is not used
	ColorProcessing(){
	}
	
	//calculates the average color of a BufferedImage
	public Color AverageColor(BufferedImage data){
		//declaring color variables used
		int red = 0, blue = 0, green = 0;
		
		/*
		 * iterating through all the colors in the image to get the total sums of red,
		 * green, blue in the image
		 */
		for(int y = 0; y < data.getHeight(); y++){
			for(int x = 0; x < data.getWidth(); x++){
				Color pixel = new Color(data.getRGB(x, y));
				blue += pixel.getBlue();
				red += pixel.getRed();
				green += pixel.getGreen();
			}
		}
		
		//getting totalPixels in the entire image
		int totalPixels = data.getHeight() * data.getWidth();
		
		//return the average color to the call 
		return new Color(red / totalPixels, green / totalPixels, blue / totalPixels);
	}
	
	public double RootMeanDifference(BufferedImage data, Color average){
		//declaring variables
		double difference = 0; //, differenceR = 0, differenceG = 0, differenceB = 0;
		
		//get the average color if the average is currently null
		if(average == null){
			average = AverageColor(data);
		}
		
		//extracting average color values
		int red = average.getRed();
		int blue = average.getBlue();
		int green = average.getGreen();
		
		//for loop to go through entire BufferedImagePixels
		for(int y = 0; y < data.getHeight(); y++){
			for(int x = 0; x < data.getWidth(); x++){
				Color current = new Color(data.getRGB(x, y));
				
				//calculating absolute difference between between the average colors and the current color
				difference += Math.abs(red - current.getRed());
				difference += Math.abs(green - current.getGreen());
				difference += Math.abs(blue - current.getBlue());
			}
		}
		
		
		//getting totalPixels in the entire image
		//TODO int totalPixels = data.getHeight() * data.getWidth();
		
		return difference;
	}
	
	public double RootMeanDifference(BufferedImage data){
		return RootMeanDifference(data, null);
	}
}
