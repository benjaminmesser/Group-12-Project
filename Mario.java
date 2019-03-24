public class Mario extends Character {
  private int health;
  private int coins;
  private int hVelocity = 0;
  private int vVelocity = 0;
  private booleon grounded = true;
  // eventually add more for health, coins, etc.
  /**
   * This class stores information about the player's location on the map. It has a copy constructor and has methods to retrieve and
   * set the location of the player.
  */
  public Mario() {
    super(0, 0);
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

  public int getHVelocity(){
    return hVelocity;
  }

  public void setHVelocity(int a){
    this.hVelocity = a;
  }

  public int getVVelocity(){
    return vVelocity;
  }

  public void setVVelocity(int a){
    this.vVelocity = a;
  }

  public void notMoving(){
    while (vVelocity > 0){
      vVelocity = vVelocity - 1;
    }
  }

  public void fall(){
    while(grounded = false){
      hVelocity = hVelocity - 0.981;
    }
  }
}
