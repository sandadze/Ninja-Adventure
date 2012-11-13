package csHW9;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class SecondEnemy extends Creature {
	protected static Image image = new ImageIcon("assets/mimic3.jpeg").getImage();
	
	public SecondEnemy(Dungeon dungeon, Point tileLocation) {
		super(dungeon, tileLocation, image, 1, 3);
	}

	
	
	public void attack(Creature c){
		if(c instanceof Player){
			super.attackPlayer(c);
		}
	}
	public void update(){	
		enemyMove();
	    super.update();
	}
	public void enemyMove(){
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
