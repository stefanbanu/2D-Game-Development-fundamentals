package com.stefanbanu.tile.entities.creature;

import com.stefanbanu.tile.entities.Entity;

public abstract class Creature extends Entity {
	
	protected int health;

	public Creature(float x, float y) {
		super(x, y);
		health = 10;
		
	}
}
