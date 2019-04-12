public class Mario extends Character {
  private int health;
  private int coins;
  private String sprite = "Right";
  private int startPositionX;
  private int startPositionY;
  
  // eventually add more for health, coins, etc.
  /**
   * This class stores information about the player's location on the map. It has a copy constructor and has methods to retrieve and
   * set the location of the player.
  */
  public Mario(int x, int y) {
    super(x, y);
    this.setStartPositionX(x);
    this.setStartPositionY(y);
    setHealth(3);
    setCoins(0);
    // eventually change to automatically put player at the origin, once we find out where that is
  }

  public Mario(Mario m) {
    super(m.getXPos(), m.getYPos());
    setHealth(m.getHealth());
    setCoins(m.getCoins());
  }

  public void setHealth(int health) {
    this.health = health;
  }
  public void hurt(int damage){
    this.health -= damage;
  }

  public int getHealth() {
    return this.health;
  }

  public void setCoins(int coins) {
    this.coins = coins;
  }

  public int getCoins() {
    return this.coins;
  }

  public void addCoin() {
    this.coins += 1;
  }

  public String getType() {
    return "Mario";
  }
  public String getSprite(){
    return sprite;
  }
  public void setSprite(String s){
    sprite = s;
  }
 
  public int getStartPositionX() {
		return startPositionX;
	}
	
	public void setStartPositionX(int startPositionX) {
		this.startPositionX = startPositionX;
	}
	
	public int getStartPositionY() {
		return startPositionY;
	}
	
	public void setStartPositionY(int startPositionY) {
		this.startPositionY = startPositionY;
	}
}
