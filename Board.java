public class Board{
  private Player p;
  private char[][] map= new char[15][5];
  public Board(){
    this.p = new Player();
    this.map = createMap();
  }
  
   public char[][] createMap(){
	  //Creates a board that is 5 long and 15 wide
	  for (int column=0; column<14;column++) {
	  for (int row= 0; row<4; row++) {
		  this.map[row][column]=' ';

		  }
	  }
	  System.out.println(map[4]);
	  return map;
  }
  public void updateMap(){
    // adds all necessary changes to the map, for now just moving the player character. called after moves are made.
  }
  /**
  public void moveLeft(){
    // checks to see if space is free to the left of the player's current position; if so, changes xPos accordingly.
    // Something like the following: may need to be changed accordingly if setup changes. Similar kind of idea for the other three.
    if (p.getXPos() - 1 > 0){
      if (map[p.getXPos - 1][p.getYPos].equals(' ')){
        p.setXPos(p.getXPos - 1);
      }
    }
    updateMap();
  }
  public void moveRight(){
    // checks to see if space is free to the right of the player's current position; if so, changes xPos accordingly.
    updateMap();
  }
  public void jump(){
    // checks to see if space is free above the player's current position; if so, changes yPos accordingly.
    updateMap();
  }
  public void fall(){
    // checks to see if space is available below the player's current position; if so, changes yPos accordingly.
    updateMap();
  }
  **/
  
}
