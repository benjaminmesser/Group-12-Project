public class Board {
  private Player p;
  private char[][] map;

  /**
   * This class stores information on the map where the player is located and facilitates different interactions the player can make
   * with the environment. It uses instance variables to store information on the player location and the graphical display of the map.
   * This class has methods to retrieve copies of its instance variables, as well as methods to move the player around the map.
   */
  public Board() {
    this.p = new Player();
    this.map = createMap();
  }

  public char[][] createMap() {
    // draw map here, whoever wants to do that.
    map = new char[][] {
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', ' ', ' ', ' ', 'x', 'x', 'x', 'x'},
            {'d', ' ', ' ', 'x', ' ', ' ', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x'}};
	p.setYPos(map.length - 1);
    return map;
  }

  public void updateMap() {
    // adds all necessary changes to the map, for now just moving the player character. called after moves are made.
    int x = p.getXPos();
    int y = p.getYPos();
    this.map[y][x] = p.getSprite();
  }

  public void moveLeft() {
    // checks to see if space is free to the left of the player's current position; if so, changes xPos accordingly.
    // Something like the following: may need to be changed accordingly if setup changes. Similar kind of idea for the other three.
    if (p.getXPos() - 1 >= 0) {
      if (map[p.getYPos()][p.getXPos() - 1] == ' ') {
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
      if (map[p.getYPos() - 1][p.getXPos() - 1] == ' ') {
        this.map[p.getYPos()][p.getXPos()] = ' ';
        p.setXPos(p.getXPos() - 1);
        p.setYPos(p.getYPos() - 1);
	p.setSprite('q');
      }
    }
    updateMap();
  }

  public void moveRight() {
    // checks to see if space is free to the right of the player's current position; if so, changes xPos accordingly.
    if (p.getXPos() + 1 < map[0].length) {
      if (map[p.getYPos()][p.getXPos() + 1] == ' ') {
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
      if (map[p.getYPos() - 1][p.getXPos() + 1] == ' ') {
        this.map[p.getYPos()][p.getXPos()] = ' ';
        p.setXPos(p.getXPos() + 1);
        p.setYPos(p.getYPos() - 1);
	p.setSprite('e');
      }
    }
    updateMap();
  }

  public void jump() {
    // checks to see if space is free above the player's current position; if so, changes yPos accordingly.
    if (p.getYPos() - 1 >= 0) {
      if (map[p.getYPos() - 1][p.getXPos()] == ' ') {
        this.map[p.getYPos()][p.getXPos()] = ' ';
        p.setYPos(p.getYPos() - 1);
      }
    }
    updateMap();
  }

  public void fall() {
    // checks to see if space is available below the player's current position; if so, changes yPos accordingly.
    if (p.getYPos() + 1 < map.length) {
      if (map[p.getYPos() + 1][p.getXPos()] == ' ') {
        this.map[p.getYPos()][p.getXPos()] = ' ';
        p.setYPos(p.getYPos() + 1);
	if (p.getSprite() == 'e'){
		p.setSprite('d');
	} else if (p.getSprite() == 'q'){
		p.setSprite('a');
	}
      }
    }
	  updateMap();
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

  public Player getPlayer() {
    //returns a copy of the player.
    Player pp = new Player(p);
    return pp;
  }
}
