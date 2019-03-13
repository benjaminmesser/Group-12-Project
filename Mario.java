public class Mario extends Character {
  private int health;
  private int coins;
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
}
