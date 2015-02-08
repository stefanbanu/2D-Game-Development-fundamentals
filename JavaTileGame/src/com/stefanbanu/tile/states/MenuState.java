package com.stefanbanu.tile.states;

import java.awt.Graphics;

import com.stefanbanu.tile.Game;
import com.stefanbanu.tile.gfx.Assets;

public class MenuState extends State {
	
	
	public MenuState(Game game) {
		super(game);
		
	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, 0, 0, null);
		g.drawString("Menu State", 200, 200);
		
	}

}
