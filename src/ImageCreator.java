import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCreator {
	
	public static void main(String[] args) {
		try {
			new ImageCreator(8000, 8000, 25);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ImageCreator(int width, int height, int passes) throws IOException {
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		int[] rgb = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		
		for(int i = 0; i < passes; i++) {
			Color color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
			pass(rgb, color);
			System.out.println("Pass: " + (i+1) + "/" + passes + " color: " + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue());
		}
		
		File file = new File("test.png");
		ImageIO.write(image, "PNG", file);
		System.out.println("File size: " + (file.length()/1000) + "kb out of max: " + (image.getWidth()*image.getHeight()/1000) + "kb");
	}
	
	private void pass(int[] rgb, Color color) {
		for(int i = 0; i < rgb.length; i++) {
			if(Math.random() < 0.1) {
				rgb[i] = color.getRGB();
			}
		}
		
	}
	
}

