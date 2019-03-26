public class Board {
  private Mario p;
  private Goomba g;
  private char[][] map;

  /**
   * This class stores information on the map where the player is located and facilitates different interactions the player can make
   * with the environment. It uses instance variables to store information on the player location and the graphical display of the map.
   * This class has methods to retrieve copies of its instance variables, as well as methods to move the player around the map.
   */
  public Board() {
    this.p = new Mario();
	  this.g= new Goomba(5,5);
    this.map = createMap();
  }

  public char[][] createMap() {
    // draw map here, whoever wants to do that.
    map = new char[][] {
			      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'c', 'c', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'c', 'c', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' '},
            {' ', ' ', ' ', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', 'c', 'c', 'c', ' ', ' ', ' ',' ',' ',' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', ' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' '},
            {' ', ' ', ' ', 'x', ' ', ' ', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', 'x', 'x', 'x', ' ', ' ', ' ',' ',' ',' '},
			      {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', ' ','b','b','b'},
			      {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', ' ','u','u','u'}};
	  p.setYPos(map.length - 3);
    return map;
  }

  public void updateMap() {
    // adds all necessary changes to the map, for now just moving the player character. called after moves are made.
    int x = p.getXPos();
    int y = p.getYPos();
    this.map[y][x] = p.getSprite();
	  if (y==map.length-1) {
		  marioPit();
	  }
	  int gx = g.getXPos();
	  int gy = g.getYPos();
	  this.map[gy][gx] = g.getSprite();
  }

  public void marioPit() {
	  p.setHealth(p.getHealth()-1);
	  this.map[p.getYPos()][p.getXPos()]=' ';
	  p.setXPos(p.getXPos()-1);
	  p.setYPos(p.getYPos()-2);
	  updateMap();
  }

  public void moveLeft() {
    // checks to see if space is free to the left of the player's current position; if so, changes xPos accordingly.
    // Something like the following: may need to be changed accordingly if setup changes. Similar kind of idea for the other three.
    if (p.getXPos() - 1 >= 0) {
      if (map[p.getYPos()][p.getXPos() - 1] == ' ' || map[p.getYPos()][p.getXPos() -1] == 'c') {
        if (map[p.getYPos()][p.getXPos() -1] == 'c') p.addCoin();
        this.map[p.getYPos()][p.getXPos()] = ' ';
        p.setXPos(p.getXPos() - 1);
	      p.setSprite('a');
      }
    }
    updateMap();
  }

  public void moveUpLeft() {
    // checks to see if space is free above and to the left of the player's current position; if so, changes xPos accordingly.
    if (p.getXPos() - 1 >= 0 && p.getYPos() - 1 >= 0) {
		  if (map[p.getYPos() + 1][p.getXPos()] != ' ') {
		    if (map[p.getYPos() - 1][p.getXPos() - 1] == ' ' || map[p.getYPos() - 1][p.getXPos() - 1] == 'c') {
          if (map[p.getYPos() - 1][p.getXPos() - 1] == 'c') p.addCoin();
			    this.map[p.getYPos()][p.getXPos()] = ' ';
			    p.setXPos(p.getXPos() - 1);
			    p.setYPos(p.getYPos() - 1);
			    p.setSprite('q');
		    }
		  }
    }
    updateMap();
  }

  public void moveRight() {
    // checks to see if space is free to the right of the player's current position; if so, changes xPos accordingly.
    if (p.getXPos() + 1 < map[0].length) {
      if (map[p.getYPos()][p.getXPos() + 1] == ' ' || map[p.getYPos()][p.getXPos() + 1] == 'c' || map[p.getYPos()][p.getXPos() + 1] == 'f') {
        if (map[p.getYPos()][p.getXPos() + 1] == 'c') p.addCoin();
        this.map[p.getYPos()][p.getXPos()] = ' ';
        p.setXPos(p.getXPos() + 1);
	      p.setSprite('d');
      }
    }
    updateMap();
  }

  public void moveUpRight() {
    // checks to see if space is free above and to the right of the player's current position; if so, changes xPos accordingly.
    if (p.getXPos() + 1 < map[0].length && p.getYPos() - 1 >= 0) {
		  if (map[p.getYPos() + 1][p.getXPos()] != ' ') {
			  if (map[p.getYPos() - 1][p.getXPos() + 1] == ' ' || map[p.getYPos() - 1][p.getXPos() + 1] == 'c') {
          if (map[p.getYPos() - 1][p.getXPos() + 1] == 'c') p.addCoin();
				  this.map[p.getYPos()][p.getXPos()] = ' ';
				  p.setXPos(p.getXPos() + 1);
				  p.setYPos(p.getYPos() - 1);
				  p.setSprite('e');
			  }
		  }
    }
    updateMap();
  }

  public void jump() {
    // checks to see if space is free above the player's current position; if so, changes yPos accordingly.
    if (p.getYPos() - 1 >= 0) {
	    if(map[p.getYPos() + 1][p.getXPos()] != ' ') {
        if (map[p.getYPos() - 1][p.getXPos()] == ' ' || map[p.getYPos() - 1][p.getXPos()] == 'c') {
          if (map[p.getYPos() - 1][p.getXPos()] == 'c') p.addCoin();
          this.map[p.getYPos()][p.getXPos()] = ' ';
          p.setYPos(p.getYPos() - 1);
	          if (p.getSprite() == 'd') {
		          p.setSprite('e');
	          } else if (p.getSprite() == 'a') {
		          p.setSprite('q');
	          }
         }
      }
      updateMap();
	  }
	}

  public void fall() {
    // checks to see if space is available below the player's current position; if so, changes yPos accordingly.
    if (p.getYPos() + 1 < map.length) {
      if (map[p.getYPos() + 1][p.getXPos()] == ' ' || map[p.getYPos() + 1][p.getXPos()] == 'c' || map[p.getYPos() + 1][p.getXPos()] == 'f') {
        if (map[p.getYPos() + 1][p.getXPos()] == 'c') p.addCoin();
        this.map[p.getYPos()][p.getXPos()] = ' ';
        p.setYPos(p.getYPos() + 1);
      }
    }
	  if (p.getSprite() == 'e') {
		  p.setSprite('d');
	  } else if (p.getSprite() == 'q') {
		  p.setSprite('a');
	  }
	  updateMap();
  }

	public String getDirection() {
		String direction="left";
		if (map[g.getYPos()][g.getXPos() + 1] != ' ') {
			direction="left";
		} else if (map[g.getYPos()][g.getXPos() - 1] != ' ') {
			direction = "right";
		}
	  return direction;
	}

	public void goombaMove() {
		if (getDirection()=="left") {
			goombaMoveLeft();
		} else if(getDirection()=="right") {
			goombaMoveRight();
		}
	}

	public void goombaMoveLeft() {
	  if (g.getXPos() + 1 < map[0].length) {
      if (map[g.getYPos()][g.getXPos() + 1] == ' ') {
        this.map[g.getYPos()][g.getXPos()] = ' ';
        g.setXPos(g.getXPos() - 1);
      }
    }
    updateMap();
  }

  public void goombaMoveRight() {
   if (g.getXPos() + 1 < map[0].length) {
      if (map[g.getYPos()][g.getXPos() + 1] == ' ') {
        this.map[g.getYPos()][g.getXPos()] = ' ';
        g.setXPos(p.getXPos() + 1);
      }
    }
    updateMap();
  }

  public void goombaFall() {
    if (g.getYPos() + 1 < map.length) {
      if (map[g.getYPos() + 1][g.getXPos()] == ' ') {
        this.map[g.getYPos()][g.getXPos()] = ' ';
        g.setYPos(g.getYPos() + 1);
      }
    }
  }

  public char[][] getMap() {
    //returns a copy of the map.
    char[][] mapClone = new char[map.length][map[0].length];
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        mapClone[i][j] = map[i][j];
      }
    }
    return mapClone;
  }

  public Mario getMario() {
    //returns a copy of the player.
    Mario pp = new Mario(p);
    return pp;
  }

  public Goomba getGoomba(){
	Goomba gg= new Goomba(g);
	return gg;
  }
  
  public int getHealth(){
	return g.getHealth();
  }
}
