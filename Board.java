public class Board{
  private Player p;
  private char[][] map;
  public Board(){
    this.p = new Player();
    this.map = createMap();
  }
  public char[][] createMap(){
    // draw map here, whoever wants to do that.
  }
  public void updateMap(){
    // adds all necessary changes to the map, for now just moving the player character. called after moves are made.
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
  public void moveRight(){
    // checks to see if space is free to the right of the player's current position; if so, changes xPos accordingly.
    if (p.getXPos() + 1 <= this.map[0].length){
      if (map[p.getXPos() + 1][p.getYPos()] == ' '){
        p.setXPos(p.getXPos() + 1);
      }
    }
    updateMap();
  }
  public void jump(){
    // checks to see if space is free above the player's current position; if so, changes yPos accordingly.
    if (p.getYPos() + 1 <= this.map[0].length){
      if (map[p.getXPos()][p.getYPos() + 1] == ' ')
        p.setYPos(p.getYPos() + 1);
      }
    }
    updateMap();
  }
  public void fall(){
    if (p.getYPos() - 1 > 0){
      if (map[p.getXPos()][p.getYPos() - 1] == ' ')
        p.setYPos(p.getYPos() - 1);
      }
    }
    // checks to see if space is available below the player's current position; if so, changes yPos accordingly.
    updateMap();
  }
  
}
