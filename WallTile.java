package csHW9;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class WallTile extends Tile {
	/**
	 * This is WallTile class which is child of Tile and has its own image
	 */
	static Image image = new ImageIcon("assets/wall.jpeg").getImage();
	public WallTile(Dungeon dungeon, Point point ) {
		super(dungeon, point, image);	
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
