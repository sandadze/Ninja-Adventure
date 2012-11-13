package csHW9;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import csHW8.GamePanel;

public class Player extends Creature {
	/**
	 * This is a Player class which is child of Creature
	 */
	protected static Image image = new ImageIcon("assets/player.jpeg").getImage();
	public Player(Dungeon dungeon, Point tileLocation) {
		super(dungeon, tileLocation, image, 3, 15);
	}
	@Override
	public void update() {
		/**
		 * Checks the health of the player. 
		 * If it is equal to or below zero, the game ends.
		 */
		if(this.health <= 0){
			System.out.println("Your enemy has killed you. You've lost! :(");
			System.exit(0);
		}
		super.update();	
	}
}
