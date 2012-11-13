package csHW9;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Dungeon {
	/**
	 * This is Dungeon class where the Map is generated and other objects are added to it.
	 * This class also provides different methods for the objects to perform different actions.
	 * @author gtkesh
	 *
	 */
	
	//instance data
	private Player player;
	protected Tile [][] layout;
	char [][] map;
	private int round = 1;
	
	public Dungeon(){
		/**
		 * Dungeon constructor which builds the game layout
		 */
		createLayout(2);
	}
	
	public Tile getTile(Point tileIndex){
		/**
		 * Returns the Tile object on the Point given
		 * @param Point tileIndex
		 * @return Tile - tile at current point, current tileIndex
		 */
		return this.layout[tileIndex.x][tileIndex.y];
	}
	
	public Player getPlayer(){
		/**
		 * @return player
		 */
		return this.player;
	}
	public void createLayout(int z){
		/**
		 * Builds the layout, adds WallTiles, FloorTiles, ExitTile, Enemies and a Player on it.
		 * @param int z - number of the round which is used for the dimension of the map
		 */
		map = MapGenerator.generateMap(z, z, 2, true, '+', ' ');
		layout = new Tile[map.length][map[0].length];
		int i = new Random().nextInt(this.layout.length);
	    int j = new Random().nextInt(this.layout[i].length);
	    int p = new Random().nextInt(this.layout.length);
	    int k = new Random().nextInt(this.layout[p].length);
		for(int x=0; x<map.length; x++){
			for(int y=0; y<map[x].length; y++){
				if(map[x][y] == '+'){
					this.layout[x][y] = new WallTile(this, new Point (x,y));
				}
				if(map[x][y] == ' '){
					this.layout[x][y] = new FloorTile(this, new Point (x,y));
				}		
			}
		}
		
		//adding Player on the layout
		 boolean playerOnTile = false;
		    while (!playerOnTile) {
		      int x = new Random().nextInt(this.layout.length);
		      int y = new Random().nextInt(this.layout[x].length);
		      if ((this.layout[x][y] instanceof FloorTile)) {
		        this.player = new Player(this, new Point(x, y));
		        this.layout[x][y].setCreature(this.player);
		        playerOnTile = true;
		      }
		    }
		//adding ExitTile on the layout
		boolean ladderOnTile = false;
	    while (!ladderOnTile) {
	      int x = new Random().nextInt(this.layout.length);
	      int y = new Random().nextInt(this.layout[x].length);
	      if (((this.layout[x][y] instanceof FloorTile)) && (this.layout[x][y].getCreature()==null)) {
	        this.layout[x][y] = new ExitTile(this, new Point(x, y));
	        ladderOnTile = true;
	      }
	    }
	  

	    //adding FirstEnemy on the tile
	    int firstEnemyNumber = z--;
	      while (firstEnemyNumber != 0) {
	          int m = new Random().nextInt(this.layout.length);
	          int n = new Random().nextInt(this.layout[m].length);
	          if (((this.layout[m][n] instanceof FloorTile)) && (this.layout[m][n].getCreature()==null)) {
	            this.layout[m][n].setCreature(new FirstEnemy(this, new Point(m, n)));
	            firstEnemyNumber--;
	          }
	      }
	      //adding SecondEnemy on the tile
	      int secondEnemyNumber = z--;
	      while (secondEnemyNumber != 0) {
	          int a = new Random().nextInt(this.layout.length);
	          int b = new Random().nextInt(this.layout[a].length);
	          if (((this.layout[a][b] instanceof FloorTile)) && (this.layout[a][b].getCreature()==null)) {
	            this.layout[a][b].setCreature(new SecondEnemy(this, new Point(a, b)));
	            secondEnemyNumber--;
	          }
	      }
	      
	      
	}
	public void update() {
		/**
		 * Updates the layout
		 */
	    for (int x = 0; x < this.layout.length; x++)
	      for (int y = 0; y < this.layout[x].length; y++)
	        this.layout[x][y].upgrade();
	  }
	
	
	
	 public void draw(Graphics g, int screenWidth, int screenHeight){
		 /**
		  * Draws the layout(dungeon)
		  * @param int screenWidth, int screenHeight 
		  * 
		  */
	    int dimension = Math.min(screenWidth, screenHeight); 
	    for (int x = 0; x < this.layout.length; x++)
	      for (int y = 0; y < this.layout[x].length; y++)
	        this.layout[x][y].draw(g, dimension / this.layout.length, dimension / this.layout[x].length);
	  }
	 
	 public void move(Creature creature, Point point){
		 /**
		  * This is move method for all kind of Creatures
		  *@param Creature creature, Point point
		  * 
		  */
		 	Tile tile = getTile(new Point(creature.getTileLocation().x, creature.getTileLocation().y ));
			Tile nextTile = getTile(new Point(creature.getTileLocation().x + point.x, creature.getTileLocation().y + point.y));
			if(tile.getCreature() instanceof Player){
				if((nextTile instanceof FloorTile || nextTile instanceof ExitTile) && (nextTile.getCreature()==null)){		
					getTile(new Point(creature.getTileLocation().x, creature.getTileLocation().y)).setCreature(null);
				    nextTile.setCreature(creature);
				    creature.setTileLocation(nextTile.getTileLocation());
				}else{
					if(((nextTile.getCreature() instanceof FirstEnemy) || (nextTile.getCreature() instanceof SecondEnemy)) 
							&& (tile.getCreature() instanceof Player)){
						creature.attackEnemy(nextTile.getCreature());		
					}
					if((nextTile.getCreature() instanceof Player) && ((tile.getCreature() instanceof FirstEnemy)
							|| (tile.getCreature() instanceof FirstEnemy))){
					creature.attackPlayer(nextTile.getCreature());		
					}
				}
			}
			if(tile.getCreature() instanceof FirstEnemy){
				if((nextTile instanceof FloorTile) && (nextTile.getCreature()==null)){		
					getTile(new Point(creature.getTileLocation().x, creature.getTileLocation().y)).setCreature(null);
				    nextTile.setCreature(creature);
				    creature.setTileLocation(nextTile.getTileLocation());
				}else{
					if((nextTile.getCreature() instanceof FirstEnemy) && (tile.getCreature() instanceof Player)){
						creature.attackEnemy(nextTile.getCreature());		
					}
					if((nextTile.getCreature() instanceof Player) && (tile.getCreature() instanceof FirstEnemy)){
					creature.attackPlayer(nextTile.getCreature());		
					}
				}
			}
			if(tile.getCreature() instanceof SecondEnemy){
				if((nextTile instanceof FloorTile) && (nextTile.getCreature()==null)){		
					getTile(new Point(creature.getTileLocation().x, creature.getTileLocation().y)).setCreature(null);
				    nextTile.setCreature(creature);
				    creature.setTileLocation(nextTile.getTileLocation());
				}else{
					if((nextTile.getCreature() instanceof SecondEnemy) && (tile.getCreature() instanceof Player)){
						creature.attackEnemy(nextTile.getCreature());		
					}
					if((nextTile.getCreature() instanceof Player) && (tile.getCreature() instanceof SecondEnemy)){
					creature.attackPlayer(nextTile.getCreature());		
					}
				}
			}
			
			
		}
	 public void nextRound(){
		 /**
		  * For extra credit:
		  * Creates the layout for the next round if the user wins the previous one.
		  */
		 	this.round++;
		    createLayout(this.round+1);
		    System.out.println("You went to the" + + this.round + " round.");    
		  }

}
