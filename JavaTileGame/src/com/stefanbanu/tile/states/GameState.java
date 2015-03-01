package com.stefanbanu.tile.states;

import java.awt.Graphics;

import com.stefanbanu.tile.Game;
import com.stefanbanu.tile.entities.creature.Player;
import com.stefanbanu.tile.worlds.World;

public class GameState extends State {

	private Player player;
	private World world;
	private World world1;

	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);
		world = new World("res/worlds/world1.txt");
	//	world1 = new World("res/worlds/world1.txt");
	}

	@Override
	public void update() {
		world.update();
	//	world1.update();
		player.update();

	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	//	world1.update();
		player.render(g);
		
	}

}
