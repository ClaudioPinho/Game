package game;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class LevelManager {
	
	public List<Level> allLevels;
	
	public int selectedLevel = 0;

	
	public LevelManager(){
		allLevels = new ArrayList<Level>();
	}
	
	public void tick(){
		allLevels.get(selectedLevel).tick();
	}
	
	public void draw(Graphics2D graphics){
		allLevels.get(selectedLevel).draw(graphics);
	}
	
	public void addLevel(Level level){
		allLevels.add(level);
	}
	
	public void addLevel(int index, Level level){
		allLevels.add(index, level);
	}
	
}
