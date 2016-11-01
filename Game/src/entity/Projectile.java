package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Projectile extends Entity {
	
	public Projectile(Rectangle bounds, double speed){
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
