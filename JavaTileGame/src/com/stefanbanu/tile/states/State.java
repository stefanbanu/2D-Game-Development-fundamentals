package com.stefanbanu.tile.states;

import java.awt.Graphics;

public abstract class State {

	// game state manager
	private static State currentState = null;

	public static void setState(State state) {
		currentState = state;
	}

	public static State getCurrentState() {
		return currentState;
	}
	// game state manager
	

	// class
	public abstract void update();

	public abstract void render(Graphics g);
}
