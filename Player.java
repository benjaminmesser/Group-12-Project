public class Player {
  private int xPos;
  private int yPos;
  private char sprite;
  // eventually add more for health, coins, etc.
  /**
   * This class stores information about the player's location on the map. It has a copy constructor and has methods to retrieve and
   * set the location of the player.
  */
  // The various sprites: d for facing right, a for facing left, e for jumping right, q for jumping left (corresponding to keyboard controls)
  public Player() {
    this.xPos = 0;
    this.yPos = 0;
    this.sprite = 'd';
    // eventually change to automatically put player at the origin, once we find out where that is
  }

  public Player(Player p) {
    this.xPos = p.getXPos();
    this.yPos = p.getYPos();
    this.sprite = p.getSprite();
  }

  //setter and getter methods: these only change the stats for the file. Actual movement and such takes place in the board class.
  public int getXPos() {
    return this.xPos;
  }
  public int getYPos() {
    return this.yPos;
  }
  public char getSprite(){
    return this.sprite;
  }
  public void setXPos(int x) {
    this.xPos = x;
  }
  public void setYPos(int y) {
    this.yPos = y;
  }
  public void setSprite(char s){
    this.sprite = s;
  }

}
