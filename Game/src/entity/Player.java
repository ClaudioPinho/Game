package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends Entity {
	
	public Player(Rectangle bounds){
		this.bounds = bounds;
		
	}

	@Override
	public void tick() {

		
	}

	@Override
	public void draw(Graphics2D graphics) {
		
		graphics.setColor(color);
		graphics.draw(bounds);
		
	}
	
}
