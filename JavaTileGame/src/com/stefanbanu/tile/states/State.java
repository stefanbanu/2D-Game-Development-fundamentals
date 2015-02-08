package com.stefanbanu.tile.states;

import java.awt.Graphics;

import com.stefanbanu.tile.Game;

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
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}

	public abstract void update();

	public abstract void render(Graphics g);
}
