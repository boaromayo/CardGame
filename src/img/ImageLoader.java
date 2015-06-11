package img;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class ImageLoader {
	
	public Image loadImage(String fileName) {
		try {
			return Toolkit.getDefaultToolkit().getImage
				(getClass().getResource("/img/" + fileName));
		} catch (Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	public BufferedImage loadBufferedImage(String fileName) {
		BufferedImage bimg = null;
		
		try {
			ImageIO.read(getClass().getResource("/img/" + fileName));
		} catch (Exception berr) {
			berr.getStackTrace();
			return null;
		}
		
		return bimg;
	}
}
