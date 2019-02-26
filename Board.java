public class Board{
  private Player p;
  private char[][] map;

  public Board(){
    this.p = new Player();
    this.map = createMap();
  }

  public char[][] createMap(){
    // draw map here, whoever wants to do that.
    map = new char[][]{
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', ' ', ' ', ' ', 'x', 'x', 'x', 'x'},
            {' ', ' ', ' ', 'x', ' ', ' ', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x'}};
    return map;
  }

  public void updateMap(){
    // adds all necessary changes to the map, for now just moving the player character. called after moves are made.
    while (p.getYPos() > 0 && map[p.getXPos()][p.getYPos() - 1] == ' '){
      p.setYPos(p.getXPos() - 1);
    }
    int x = p.getXPos();
    int y = p.getYPos();
    this.map[x][y] = '|';
  }

  public void moveLeft(){
    // checks to see if space is free to the left of the player's current position; if so, changes xPos accordingly.
    // Something like the following: may need to be changed accordingly if setup changes. Similar kind of idea for the other three.
    if (p.getXPos() - 1 > 0){
      if (map[p.getXPos() - 1][p.getYPos()] == ' '){
        p.setXPos(p.getXPos() - 1);
      }
    }
    updateMap();
  }

  public void moveUpLeft(){
    // checks to see if space is free above and to the left of the player's current position; if so, changes xPos accordingly.
    if (p.getXPos() - 1 > 0 && p.getYPos() + 1 <= this.map[0].length){
      if (map[p.getXPos() - 1][p.getYPos() + 1] == ' '){
        p.setXPos(p.getXPos() - 1);
        p.setYPos(p.getXPos() + 1);
      }
    }
    updateMap();
  }

  public void moveRight(){
    // checks to see if space is free to the right of the player's current position; if so, changes xPos accordingly.
    if (p.getXPos() + 1 <= this.map[0].length){
      if (map[p.getXPos() + 1][p.getYPos()] == ' '){
        p.setXPos(p.getXPos() + 1);
      }
    }
    updateMap();
  }

  public void moveUpRight(){
    // checks to see if space is free above and to the right of the player's current position; if so, changes xPos accordingly.
    if (p.getXPos() + 1 <= this.map[0].length && p.getYPos() + 1 <= this.map[0].length){
      if (map[p.getXPos() + 1][p.getYPos() + 1] == ' '){
        p.setXPos(p.getXPos() + 1);
        p.setYPos(p.getXPos() + 1);
      }
    }
    updateMap();
  }

  public void jump(){
    // checks to see if space is free above the player's current position; if so, changes yPos accordingly.
    if (p.getYPos() + 1 <= this.map[0].length){
      if (map[p.getXPos()][p.getYPos() + 1] == ' '){
        p.setYPos(p.getYPos() + 1);
      }
    }
    updateMap();
  }

  public void fall(){
    // checks to see if space is available below the player's current position; if so, changes yPos accordingly.
    if (p.getYPos() - 1 > 0){
      if (map[p.getXPos()][p.getYPos() - 1] == ' '){
        p.setYPos(p.getYPos() - 1);
      }
    }
  }

  public char[][] getMap(){
    //returns a copy of the map.
    char[][] mapClone = new char[map.length][map[0].length];
    for (int i = 0; i < map.length; i++){
      for (int j = 0; j < map[0].length; j++){
        mapClone[i][j] = map[i][j];
      }
    }
    return mapClone;
  }
}
