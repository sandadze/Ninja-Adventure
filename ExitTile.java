package csHW9;

import java.awt.Image;
import java.awt.Point;


import javax.swing.ImageIcon;

public class ExitTile extends Tile {
	/**
	 * This is ExitTile class which is child of Tile and has its own image
	 */
	static Image image = new ImageIcon("assets/ladder.jpeg").getImage();
	public ExitTile(Dungeon dungeon, Point point) {
		super(dungeon, point, image);	
	}			

	public void upgrade(){
		/**
		 * If the player reaches exit tile, it goes to the next round
		 */
		super.upgrade();
		if(this.creature == dungeon.getPlayer()){
			System.out.println("YOU WIN!");
			dungeon.nextRound();
		}
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
