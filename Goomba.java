 /**
 * This class stores information about the Goomba(s) location on the map. 
 * It has a copy constructor and has methods to retrieve and set the location of Mario.
 */
public class Goomba extends Character {
  private int health;
	
 /**
 * This constructor takes two integers as parameters corresponding to the Goombas x and y positions. 
 * Within the constructor the Goomba's health is set to a default of 1
 * @param x is the Goomba's x position
 * @param y is Goomba's y position
 */
  public Goomba(int x, int y) {
    super(x, y);
    this.health = 1;
  }
 /**
 * Copy Constructor 
 * @param g instance of Goomba
 */
  public Goomba(Goomba g) {
	  super(g.getXPos(), g.getYPos());
	  this.health = g.health;
  }
	
 /**
 * This method decrements the Goomba's health when defeated by Mario (ultimately killing the Goomba) 
 */
  public void hurt() {
    this.health -= 1;
  }
	
 /**
 * This method sets the Goomba's health to 0 - ultimately killing him/her/it
 */
  public void kill() {
    this.health = 0;
  }
	
 /**
 * Getter Method for Goomba's Health
 * @return returns an Integer representing the Goomba's Health
 */
  public int getHealth() {
    return this.health;
  }

  public String getType() {
    return "Goomba";
  }
}
