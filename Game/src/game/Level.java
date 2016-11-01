package game;

import java.awt.Graphics2D;

public abstract class Level {
	
	public abstract void tick();
	public abstract void draw(Graphics2D graphics);

}
