package csHW9;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * HW9: This is a game where user is trying to reach the exit, while enemies are trying to kill him.
 * The player can attack enemies by simply moving to the point, where enemy stands.
 * The program uses the principles of encapsulation, polymorphism and inheritance as well.
 * Collaboration statement: I have worked alone on this assignment
 * @author Giorgi Tkeshelashvili
 * @version 1.0
 *
 */
public class Driver {
/**
 * This is the Driver class. Here starts the program.
 *
 */
	public static void main(String[] args){		
	    JFrame frame = new JFrame("Dungeon Adventure");
	    DisplayPanel panel = new DisplayPanel();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(panel);
	    frame.pack();
	    frame.setVisible(true);
	  }
}
