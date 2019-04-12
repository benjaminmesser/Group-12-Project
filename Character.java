 /**
 * Character is a Subclass of Entity. Character itself extends itself to Goomba and Mario.
 * This class contains a constructor for the positions of characters as well as setting the velocity for smooth movement
 */
public class Character extends Entity {
  private int xVelocity = 1;
  private int yVelocity = 0;
  private boolean grounded = false;
  
 /**
 * This constructor sets the x and y positions of a character by calling the super class Entity
 * @param x Integer for the x position of a character
 * @param y Integer for the y position of a character
 */
  public Character(int x, int y) {
    super(x,y);
  }
  
 /**
 * Setter Method for x coordinate (sideways) Velocity
 * @param vel sets the velocity 
 * Positive values move right, negatives move left
 */
  public void setXVelocity(int vel) {
    // Positive values move right, negatives move left
    this.xVelocity = vel;
  }
 /**
 * @return an integer which represents a characters' velocity, right and left
 */
  public int getXVelocity() {
    return this.xVelocity;
  }
  
 /**
 * Setter Method for y coordinate (vertical) Velocity
 * @param vel sets the velocity 
 * Positive values move up, negative move down
 */
  public void setYVelocity(int vel) {
    // Positive values move up, negative move down
    this.yVelocity = vel;
  }
  
 /**
 * @return an integer which represents the characters' velocity, up and down
 */
  public int getYVelocity() {
    return this.yVelocity;
  }
  
 /**
 * This methods adds onto the x coordinates velocity
 * @param x an integer added to the x-velocity
 */
  public void addXVelocity(int x) {
    this.xVelocity += x;
  }
  
 /**
 * This methods adds onto the y coordinates velocity
 * @param y an integer added to the y-velocity 
 */
  public void addYVelocity(int y) {
    this.yVelocity += y;
  }
  
 /**
 * @param displacement integer that is added to the current x position of the character
 */
  public void addXPos(int displacement) {
    super.setXPos(super.getXPos() + displacement);
  }
  
 /**
 * @param displacement integer that is added to the current y position of the character
 */
  public void addYPos(int displacement) {
    super.setYPos(super.getYPos() + displacement);
  }

  public String getType() {
    return "Character";
  }

  public String getMainClass() {
    return "Character";
  }

  public boolean isGrounded() {
    return this.grounded;
  }

  public void setGrounded(boolean g) {
    this.grounded = g;
  }
}
