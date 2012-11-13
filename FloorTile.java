package csHW9;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class FloorTile extends Tile {
	/**
	 * This is FloorTile class which is child of Tile and has its own image
	 */
	static Image image = new ImageIcon("assets/floor.jpeg").getImage();
	public FloorTile(Dungeon dungeon, Point point) {
		super(dungeon, point, image);	
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
