package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Resize {
	//constructor not used
	Resize(){		
	}

	public static BufferedImage scaleImage(BufferedImage image, int size) {
		 Image origional = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
		 BufferedImage scaled = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);

		 Graphics2D g2d = scaled.createGraphics();
		 g2d.drawImage(origional, 0, 0, null);
		 g2d.dispose();

		 return scaled;
	}
}
