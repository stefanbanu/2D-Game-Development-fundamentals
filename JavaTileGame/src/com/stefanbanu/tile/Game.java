package com.stefanbanu.tile;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.stefanbanu.tile.display.Display;
import com.stefanbanu.tile.gfx.ImageLoader;
import com.stefanbanu.tile.gfx.SpriteSheet;

public class Game implements Runnable{

	private Display display;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private boolean running = false;
	
	public int width, height;
	private String title;
	
	private BufferedImage testImage;
	private SpriteSheet spriteSheet;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	
	@Override
	public void run() {
		init();	
		
		while(running){
			update();
			render();
		}
		// just in case is not already stopped
		stop();
	}
	private void init() {
		display = new Display(title, width, height);
		testImage = ImageLoader.loadImage("/textures/sheet2.png");
		spriteSheet = new SpriteSheet(testImage);
	}
	private void update() {
	
	}
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		// the paint brush :)
		g = bs.getDrawGraphics();
		
		// Clear the screen
		g.clearRect(0, 0, width, height);
		
		// start drawing
	
		g.drawImage(spriteSheet.crop(32, 0, 32, 32), 50, 50 ,null);
		
		// end drawing
		
		bs.show();
		g.dispose();
	}

	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
