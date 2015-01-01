package com.stefanbanu.tile;

import com.stefanbanu.tile.display.Display;

public class Game implements Runnable{

	private Display display;
	private Thread thread;
	
	private boolean running = false;
	
	public int width, height;
	private String title;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		start();
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
	}
	private void update() {
	//	System.out.println("running");
	}
	private void render() {
		
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
