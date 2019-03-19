public class Goomba extends Character {
  private int health;

  public Goomba(int x, int y) {
    super(x, y);
    setHealth(1);
  }

  public void setHealth(int aHealth) {
    this.health = aHealth;
  }

  public int getHealth() {
    return this.health;
  }
}
