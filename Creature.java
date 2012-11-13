package csHW9;

import java.awt.Image;
import java.awt.Point;

public abstract class Creature extends DungeonElement{
	/**
	 * Abstract class Creature which is Child of DungeonElement.
	 */
	
	protected int damage;
	protected int health;
	

	public Creature(Dungeon dungeon, Point tileLocation, Image image, int damage, int health){
		/**
		 * Creature constructor
		 */
		super(dungeon, tileLocation, image);
		this.damage = damage;
		this.health = health;	
	}
	public void attackEnemy(Creature c){
		/**
		 * This method is used to attack Enemy
		 * @param Creature c - Enemy
		 */
		if(Math.random()<=0.6D){
			c.health = c.health - this.damage; 
			System.out.println("Player has attacked his enemy and gave " + this.damage + " damage and enemy has" + c.health + " remaining!");
		}else{
			System.out.println("Player has attacked his enemy and missed the target!");
		}
	}
	public void attackPlayer(Creature c){
		/**
		 * This method is used to attack Player
		 * @param Creature c - Player
		 */
		if(Math.random()<=0.3D){
			c.health = c.health - this.damage; 
			System.out.println("Enemy has attacked player and gave " + this.damage + " damage and player has " + c.health + " remaining!");
		}else{
			System.out.println("Enemy has attacked player and missed the target!");
		}		
	}	
	public void update(){
		/**
		 * If the health of the Creature is below or equal to zero, it gets removed from the dungeon
		 */
		if(this.health <= 0){
			this.dungeon.getTile(this.tileLocation).setCreature(null);
			
		}		
	}	
}
