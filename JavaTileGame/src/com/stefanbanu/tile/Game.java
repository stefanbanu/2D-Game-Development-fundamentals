package com.stefanbanu.tile;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.stefanbanu.tile.display.Display;
import com.stefanbanu.tile.gfx.Assets;

public class Game implements Runnable{

	private Display display;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private boolean running = false;
	
	public int width, height;
	private String title;
	
	int x = 0;
	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	
	@Override
	public void run() {
		init();	
		
		int fps = 60;
		double timePerUpdate = 1000000000 /fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int updates = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerUpdate;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta > 1){
				update();
				render();
				updates++;
				delta--;
			}
			if(timer > 1000000000){
				System.out.println("Updates and frames: " + updates);
				updates = 0;
				timer = 0;
			}
		}
		// just in case is not already stopped
		stop();
	}
	private void init() {
		display = new Display(title, width, height);
		Assets.initAssets();
	}
	private void update() {
		x++;
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
		g.drawImage(Assets.tree, x, 50, null);
		g.drawImage(Assets.player, 200, 250, null);
		
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
