package quadProcessing;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Processes an image based on color
 */
public class ColorProcessing {
	
	public class ColorData{
		private Color average;
		
		private double error;
		
		private ColorData(double error, Color average){
			this.average = average;
			this.error = error;
		}
		
		public Color getAverageColor(){
			return this.average;
		}

		public double getWeightedError() {
			return this.error;
		}
	}
	
	//constructor not used
	ColorProcessing(){
	}
	
	public ColorData computeColor(BufferedImage data){
		double[] values = weightedAverage(data);
		return new ColorData(values[3], (new Color((int)values[0], (int)values[1], (int)values[2])));
	}
	
	//calculates the average color of a BufferedImage
	public double[] weightedAverage(BufferedImage data){
		//values to be returned
		double[] colorAndError = new double[4];
		
		//arrays to store weighted color averages by weight and frequency
		int[] red = new int[256];
		int[] green = new int[256];
		int[] blue = new int[256];
		
		/*
		 * iterating through all the colors in the image to get the total sums of red,
		 * green, blue in the image
		 */
		for(int y = 0; y < data.getHeight(); y++){
			for(int x = 0; x < data.getWidth(); x++){
				Color pixel = new Color(data.getRGB(x, y));
				red[pixel.getRed()]++;
				green[pixel.getGreen()]++;
				blue[pixel.getBlue()]++;
			}
		}
		
		double totalRed = 0, totalGreen = 0, totalBlue = 0;
		double countRed = 0, countGreen = 0, countBlue = 0;
		
		for(int i = 0; i < 256; i++){
			totalRed += red[i];
			countRed += red[i] * i;
			
			totalGreen += green[i];
			countGreen += green[i] * i;
			
			totalBlue += blue[i];
			countBlue += blue[i] * i;
		}
		
		countRed = countRed / totalRed;
		countGreen = countGreen / totalGreen;
		countBlue = countBlue / totalBlue;

		//getting errors
		double redError = 0;
		double greenError = 0;
		double blueError = 0;
		
		for(int i = 0; i < 256; i++){
			redError += ((countRed - i) * (countRed - i) * red[i]);
			
			greenError += ((countGreen - i) * (countGreen - i) * green[i]);
			
			blueError += ((countBlue - i) * (countBlue - i) * blue[i]);
		}
		
		redError = Math.sqrt(redError / totalRed);
		greenError = Math.sqrt(greenError / totalGreen);
		blueError = Math.sqrt(blueError / totalBlue);
		
		double error = redError * .2126 + greenError * .7152 + blueError * .0722;
		//Other formula that does not work as well
		//double error = redError * .299 + greenError * .587 + blueError * .114;
		
		//setting values
		colorAndError[0] = countRed;
		colorAndError[1] = countGreen;
		colorAndError[2] = countBlue;
		colorAndError[3] = error * Math.pow(data.getWidth() * data.getHeight(), .25);
		
		//return the average color to the call 
		return colorAndError;
	}
}
