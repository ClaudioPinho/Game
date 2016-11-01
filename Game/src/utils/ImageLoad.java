package utils;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageLoad {
	
	private BufferedImage image;
	
	private String source;
	
	public ImageLoad(String source){
		this.source = source;
		image = null;
		loadImage(source);
	}
	
	public void loadImage(String source){
		try{
			BufferedImage image = ImageIO.read(getClass().getResourceAsStream(source));
			System.out.println("Succesfully loaded image from source: " + "\"" + source + "\"");
			this.image = image;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
