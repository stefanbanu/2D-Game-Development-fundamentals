package com.stefanbanu.tile.tiles;

import java.awt.image.BufferedImage;

import com.stefanbanu.tile.gfx.Assets;

public class RockTile extends Tile {

	public RockTile( int id) {
		super(Assets.stone, id);
		
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
