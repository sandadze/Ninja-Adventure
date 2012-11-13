package csHW9;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class FirstEnemy extends Creature {
	/**
	 * FirstEnemy which is the child of Creature and has its own image, attack and move methods.
	 */
	protected static Image image = new ImageIcon("assets/enemy.jpeg").getImage();
	
	public FirstEnemy(Dungeon dungeon, Point tileLocation) {
		super(dungeon, tileLocation, image, 2, 3);
	}

	
	
	public void attack(Creature c){
		/**
		 * Attacks the player
		 * @param Creature c - player
		 */
		if(c instanceof Player){
			super.attackPlayer(c);
		}
	}
	public void update(){	
		enemyMove();
	    super.update();
	}
	public void enemyMove(){
		/**
		 * Moves the enemy
		 */
	    int x = this.dungeon.getPlayer().getTileLocation().x - this.tileLocation.x;
	    int y = this.dungeon.getPlayer().getTileLocation().y - this.tileLocation.y;
	    if(x>=1){
	    	x=1;
	    }
	    if(x<=-1){
	    	x=-1;
	    }
	    if(y>=1){
	    	y=1;
	    }
	    if(y<=-1){
	    	y=-1;
	    }
	    this.dungeon.move(this, new Point(x, y));
	}
}
