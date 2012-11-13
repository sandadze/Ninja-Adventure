package csHW9;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public abstract class Tile extends DungeonElement {
	/**
	 * This is an abstract class Tile which is a child of DungeonElement abstract class
	 */
	protected Creature creature;
	
	public Tile(Dungeon dungeon, Point tileLocation, Image image){
		/**
		 * Tile Constructor
		 */
		super(dungeon, tileLocation, image);
	}
	public Creature getCreature(){
		/**
		 * Returns the creature
		 * return@ Creature creature
		 */
		return this.creature;
	}
	public void setCreature(Creature creature){
		/**
		 * Sets the creature
		 */
		this.creature = creature;
	}
	public void draw(Graphics g, int tileWidth, int tileHeight) {
		/**
		 * Draw method for creature
		 */
	    super.draw(g, tileWidth, tileHeight);
	    if(this.creature != null){
	    	this.creature.draw(g, tileWidth, tileHeight);
	    }	    
	 }
	public void upgrade() {
		/**
		 * Upgrade method, which calls the upgrade() method of its superclass.
		 */
	    if (this.creature!=null){
	    	this.creature.update();
	    }
	 }
}
