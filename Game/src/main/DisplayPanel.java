package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import entity.Projectile;
import game.LevelManager;
import game.Menu;

public class DisplayPanel extends JPanel implements Runnable, MouseListener, KeyListener {

	/**
	 * Some random shit that eclipses kinda wants me to write it
	 */
	private static final long serialVersionUID = 1L;
	
	//Timers for runtime (very rough)
	public static final int FPS = 60;
	public static final long triggerTick = 1000/FPS;
	
	//Some of the game specs
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	//Some Graphical stuff
	private Graphics2D graphics;
	private BufferedImage bufferImg;
	
	//Level Manager class
	private LevelManager levelManager;
	
	//Entities
	public static List<Entity> entityList;
	
	public static Player player;
	
	private Thread thread;
	
	public DisplayPanel(){
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	@Override
	public void addNotify(){
		super.addNotify();
		if(thread == null){
			thread = new Thread(this);
			addKeyListener(this);
			addMouseListener(this);
			thread.start();
		}
	}
	
	public void initialize(){
		
		//Initialize the levelManager
		levelManager = new LevelManager();
		
		//Initialize the graphical unit
		bufferImg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D) bufferImg.getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		
		//Add some levels to levelManager
		levelManager.addLevel(new Menu());
		
		entityList = new ArrayList<Entity>();

		
	}
	
	public void drawToScreen(){
		
		Graphics graphics = getGraphics();
		graphics.drawImage(bufferImg, 0, 0, WIDTH, HEIGHT, null);
		graphics.dispose();
	}
	
	public void draw(){
		
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		
		levelManager.draw(graphics);
		
		for(Entity entity: entityList) entity.draw(graphics);
		
	}
	
	public void tick(){
		
		levelManager.tick();
		
		for(Entity entity: entityList) entity.tick();
		
	}
	
	@Override
	public void run() {
		
		initialize();
		
		long startTimer = System.currentTimeMillis();
		long currentTime = startTimer;
		long elapsed;
		
		while(true){
			elapsed = System.currentTimeMillis() - currentTime;
			if(elapsed >= triggerTick){
				draw();
				drawToScreen();
				tick();
				currentTime = System.currentTimeMillis();
			} try {
				Thread.sleep(1);
			} catch (Exception t){}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
