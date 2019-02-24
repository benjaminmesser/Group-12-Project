import java.util.ArrayList;
import java.util.List;

public class Board{
  private Player p;
  private ArrayList<ArrayList<String>> map;
  public Board(){
    this.p = new Player();
    this.map = createMap();
  }
  public ArrayList<ArrayList<String>> createMap(){
	  ArrayList<ArrayList<String>> map= new ArrayList<ArrayList<String>>();
	  ArrayList<String> space= new ArrayList<String>();
	  ArrayList<String> newLine= new ArrayList<String>();
	  newLine.add("\n");
	  //adds row to board
	  int numOfRows= 5;
	  //Creates a board that is numOfRows long and i wide
	  while (numOfRows != 0) {
	  for (int i= 0; i<=15; i++) {
		  map.add(space);
		  if(i == 15) {
			  map.add(newLine);
		  }
	  }
	  numOfRows-=1;
	  }
	  System.out.println(map);
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
