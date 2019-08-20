import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LineTest {

	public static void main(String[] args) {
		try {
			new LineTest(800,800, 16, 20);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public LineTest(int width, int height, int lineWidth, int secondaryLineWidth) throws IOException {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Color one = Color.RED;
		Color two = Color.WHITE;
		
		boolean first = true;
		int remaining = lineWidth;
		
		for(int x = 0; x < image.getWidth(); x++) {
			for(int y = 0; y < image.getHeight(); y++) {
				if(first) {
					image.setRGB(x, y, one.getRGB());
				}else {
					image.setRGB(x, y, two.getRGB());
				}
			}
			remaining--;
			if(remaining == 0) {
				first = !first;
				if(first) {
					remaining = lineWidth;
				}else {
					remaining = secondaryLineWidth;
				}
			}
		}
		
		for(int y = 0; y < image.getHeight()/2; y++) {
			for(int x = 0; x < image.getWidth()/2; x++) {
				if(first) {
					image.setRGB(x, y, one.getRGB());
				}else {
					image.setRGB(x, y, two.getRGB());
				}
			}
			remaining--;
			if(remaining == 0) {
				first = !first;
				if(first) {
					remaining = lineWidth;
				}else {
					remaining = secondaryLineWidth;
				}
			}
		}
		
		ImageIO.write(image, "PNG", new File("LineTest.png"));
		
	}
	
}
