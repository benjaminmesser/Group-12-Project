 /**
 * The Entity class is declared abstract to implement the boards handle collisions method
 * Within Bad Mario, an Entity can be a Block or a Character and hence these are subclasses of Entity
 * This class basically stores and sets the x and y positions of an entity which are further defined in the subclasses
 */
public abstract class Entity {
  private int xPos;
  private int yPos;
  private boolean collision = true;
  
 /**
 * This constructor holds the x and y positions of the "Entity"
 * @param x is the x position of the "Entity"
 * @param y is the y position of the "Entity"
 */
  public Entity(int x, int y) {
    setXPos(x);
    setYPos(y);
  }

 /**
 * Setter Method for an Entity's x position
 * @param x is an integer representing the x position of an "Entity"
 */
  public void setXPos(int x) {
    this.xPos = x;
  }
  
 /**
 * @return an integer that is the x position of an Entity
 */
  public int getXPos() {
    return this.xPos;
  }
  
 /**
 * Setter Method for an Entity's y position
 * @param y is an integer representing the y position of an "Entity"
 */
  public void setYPos(int y) {
    this.yPos = y;
  }
  
 /**
 * @return an integer that is the y position of an Entity
 */
  public int getYPos() {
    return this.yPos;
  }

 /**
 * Setter Method for collisions between objects
 * @param boolean collideable, sets collision to collideable
 */  
  public void setCollision(boolean collideable) {
    this.collision = collideable;
  }
  
 /**
 * @return returns a boolean collision that is defaulted to true 
 * based on whether or not an object is collideable and thus whether or not there would be a collision between objects
 */
  public boolean isCollideable() {
    return this.collision;
  }

 /**
 * An abstract method later implemented in the subclasses
 * @return returns the type of Entity
 */
  public abstract String getType();
 
 /**
 * @return returns the main class as a String within which this method is held
 */
  public abstract String getMainClass();
}
