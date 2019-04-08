public class Goomba extends Character {
  private int health;

  public Goomba(int x, int y) {
    super(x, y);
    this.health = 1;
  }

  public Goomba(Goomba g) {
	  super(g.getXPos(), g.getYPos());
	  this.health = g.health;
  }

  public void hurt() {
    this.health -= 1;
  }

  public void kill() {
    this.health = 0;
  }

  public int getHealth() {
    return this.health;
  }

  public String getType() {
    return "Goomba";
  }
}
