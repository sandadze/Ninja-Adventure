package csHW9;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

import javax.swing.JPanel;
/**
 * This is the GUI part of the game. KeyListener is added to it to listen to key events from the user.
 * Graphic components are drawn here. 
 * 
 *
 */
public class DisplayPanel extends JPanel{	
	private Dungeon dungeon;
	
	public DisplayPanel(){
	/**
	 * DisplayPanel constructor
	 */
		System.out.println("DisplayPanel constructed!");
		setPreferredSize(new Dimension(600, 600));
		this.dungeon = new Dungeon();
		setFocusable(true);
		addKeyListener(new KListener());
			
	}
	public void paintComponent(Graphics s){
		/**
		 * This method draws every component on the panel
		 */
		 int width = getWidth();
		 int height = getHeight();
	    this.dungeon.draw(s, width, height);
	  } 
	private class KListener implements KeyListener{
		/**
		 * This is listener which acts correspondingly to the keys pressed by the user
		 */
		boolean keyPressed = false;
		@Override
		public void keyPressed(KeyEvent e) {
			if(!this.keyPressed){
			switch (e.getKeyCode()){
			case 37:
				 DisplayPanel.this.dungeon.move(DisplayPanel.this.dungeon.getPlayer(), new Point(-1, 0));
				break;
			case 38:
				 DisplayPanel.this.dungeon.move(DisplayPanel.this.dungeon.getPlayer(), new Point(0, -1));
				break;
			case 39:
				 DisplayPanel.this.dungeon.move(DisplayPanel.this.dungeon.getPlayer(), new Point(1, 0));
				break;
			case 40:
				 DisplayPanel.this.dungeon.move(DisplayPanel.this.dungeon.getPlayer(), new Point(0, 1));
				break;			
			}
			DisplayPanel.this.repaint();
	        DisplayPanel.this.dungeon.update();
	        this.keyPressed=true;
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			this.keyPressed = false;
		}
		@Override
		public void keyTyped(KeyEvent e) {}
	
	}
}
