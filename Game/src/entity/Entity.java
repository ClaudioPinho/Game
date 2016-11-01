package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Entity {
	
	public Rectangle bounds;
	
	public boolean drawHitBoxes;
	
	public Color color = Color.WHITE;
	
	public BufferedImage[] sprites;
	public int transitionSpeed;
	
	public abstract void tick();
	public abstract void draw(Graphics2D graphics);
	
	public void setColor(Color newColor){
		color = newColor;
	}
	
	public boolean collides(Entity otherEntity){
		return bounds.intersects(otherEntity.bounds);
	}
	
	public void renderHitBoxes(){
		drawHitBoxes = true;
	}
	
	public int posX(){
		return bounds.x;
	}
	
	public int posY(){
		return bounds.y;
	}

	public int getWidth(){
		return bounds.width;
	}
	
	public int getHeight(){
		return bounds.height;
	}

}
