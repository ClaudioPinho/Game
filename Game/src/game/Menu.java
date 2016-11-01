package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import utils.ImageLoad;

public class Menu extends Level {
	
	public BufferedImage[] backgrounds;
	
	public int currentBG = 0;
	public double selection = currentBG;
	public double transSpeed = 0.03;
	
	public ImageLoad imageLoad;
	
	public Menu(){
		
		backgrounds = new BufferedImage[2];
		
		backgrounds[0] = new ImageLoad("/menu/snow_1.png").getImage();
		backgrounds[1] = new ImageLoad("/menu/snow_2.png").getImage();
	}

	@Override
	public void tick() {
		System.out.println(selection);
		if((selection += transSpeed) < 2){
			//selection += transSpeed;
			currentBG = (int) selection;
		} else {
			selection = 0;
		}
	}

	@Override
	public void draw(Graphics2D graphics) {
		
		graphics.drawImage(backgrounds[currentBG], 0, 0, null);
		
	}
	
}
