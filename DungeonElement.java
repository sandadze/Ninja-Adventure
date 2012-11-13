package csHW9;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public abstract class DungeonElement {
	/**
	 * This is the parent class of Tile and Creature 
	 */
	//instance data
	protected Image image;
	public Point tileLocation;
	protected Dungeon dungeon;
	
	public DungeonElement(Dungeon dungeon, Point tileLocation, Image image){
		/**
		 * DungeonElement constructor
		 */
		this.dungeon = dungeon;
		this.tileLocation = tileLocation;
		this.image = image;
	}

	public abstract void update(); // abstract update method
	
	protected void draw(Graphics g, int tileWidth, int tileHeight ){
		/**
		 * Draw method
		 * @param Graphics g, int tileWidth, int tileheight
		 */
		g.drawImage(this.image, this.tileLocation.x * tileWidth, this.tileLocation.y * tileHeight, tileWidth,  tileHeight, null);
	}

	public Point getTileLocation(){
		/**
		 * Returns the location of tile
		 * @return Point - tileLocation
		 */
		return this.tileLocation;
	}
	public void setTileLocation(Point newTileLocation){
		/**
		 * Sets the location of the tile
		 */
		this.tileLocation = newTileLocation;
	}
}
