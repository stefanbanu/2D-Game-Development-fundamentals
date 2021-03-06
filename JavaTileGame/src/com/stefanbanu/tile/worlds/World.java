package com.stefanbanu.tile.worlds;

import java.awt.Graphics;

import com.stefanbanu.tile.tiles.Tile;
import com.stefanbanu.tile.utils.Utils;

public class World {

	private int width, height;
	private int spawnX, spawnY;
	private int[][] tilesWorld;
	
	public World(String path) {
		loadWorld(path);
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g){
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getTile(x, y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
			}
		}
	}
	
	public Tile getTile(int x, int y){
		
		Tile t = Tile.tiles[tilesWorld[x][y]];
		if(t == null){
			return Tile.dirtTile;
		}
		return t;
	}
	
	private void loadWorld(String path){
		/*width = 5;
		height = 5;
		tilesWorld = new int[width][height];
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tilesWorld[x][y] = 0; 
			}
		}*/
		
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tilesWorld = new  int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x  = 0; x < width; x++) {
				tilesWorld[x][x] = Utils.parseInt(tokens[(x + y * width) + 4]); 
			}
		}
	}
}
