/**
 * This class stores information about Mario's location on the map. 
 * It has a copy constructor and has methods to retrieve and set the location of Mario.
*/
public class Mario extends Character {
  private int health;
  private int coins;
  private String sprite = "Right";
  private int startPositionX;
  private int startPositionY;
	
 /**
 * This constructor takes two integers as parameters corresponding to Mario's x and y positions. 
 * Within the constructor Mario's health is set to a default of 3 - this is before any interaction with Goombas 
 * or any other obstacles that may reduce his health. Coins are also set to a default of 0 which increments as collects them.
 * @param x is Mario's x position
 * @param y is Mario's y position
 */	
  public Mario(int x, int y) {
    super(x, y);
    this.setStartPositionX(x);
    this.setStartPositionY(y);
    setHealth(3);
    setCoins(0);
  }
 /**
 * Copy Constructor 
 * @param m instance of Mario
 */	
  public Mario(Mario m) {
    super(m.getXPos(), m.getYPos());
    setHealth(m.getHealth());
    setCoins(m.getCoins());
  }
 /**
 * Setter Method that takes an integer as a parameter which corresponds to Mario's health
 * @param health represents Mario's health
 */	
  public void setHealth(int health) {
    this.health = health;
  }
	
 /**
 * This method takes an integer that decrements Marios health when he comes into contact with obstacles 
 * on the board that may cause harm to him 
 * @param damage represents how much to decrement Mario's health (usually by 1)
 */	
  public void hurt(int damage){
    this.health -= damage;
  }
	
 /**
 * Getter Method for Health
 * @return returns an Integer which is Mario's Health
 */
  public int getHealth() {
    return this.health;
  }
	
/**
 * Setter Method that takes an integer as a parameter which represents coins collected
 * @param coins represents coins collected by Mario
 */
  public void setCoins(int coins) {
    this.coins = coins;
  }
	
 /**
 * Getter Method for Coins
 * @return returns an Integer coins collected
 */
  public int getCoins() {
    return this.coins;
  }
	
 /**
 * This method increments the each coins Mario collects during the gameplay by 1 
 */
  public void addCoin() {
    this.coins += 1;
  }

  public String getType() {
    return "Mario";
  }
	
 /**
  * Getter Method for sprites
  * @return returns a String which is set to a default of "Right"
  */
  public String getSprite(){
    return sprite;
  }
	
 /**
 * Setter Method for sprites
 * @param s setting the sprite to s which corresponds to user input and changes accordingly
 */
  public void setSprite(String s){
    sprite = s;
  }

/**
 * Getter Method for the starting x position of Mario
 * @return returns an Integer corresponding to Mario's initial x position on the board
 */
	
  public int getStartPositionX() {
	return startPositionX;
  }
	
/**
* Setter Method for the starting x position of Mario
* @param startPositionX sets the initial x position of Mario on the board
*/
  public void setStartPositionX(int startPositionX) {
	this.startPositionX = startPositionX;
  }
	
 /**
 * Getter Method for the starting y position of Mario
 * @return returns an Integer corresponding to Mario's initial y position on the board
 */
  public int getStartPositionY() {
	return startPositionY;
  }

 /**
 *Setter Method for the starting y position of Mario
 * @param startPositionX sets the initial y position of Mario on the board
 */	
  public void setStartPositionY(int startPositionY) {
	this.startPositionY = startPositionY;
  }
	
}
