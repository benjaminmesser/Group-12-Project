public class Goomba extends Character {
  private int health = 1;
  private boolean CanDealDamage = true;

  public Goomba(int x, int y) {
    super(x, y);
    setHealth(1);
  }

  public void setHealth(int aHealth) {
    if (this.health > 0)
    if (aHealth > 0)
    this.health = aHealth;
  }

  public int getHealth() {
    return this.health;
  }

  public void setStatus(boolean b){
    this.CanDealDamage = b;
  }

  public boolean getStatus(){
    return this.CanDealDamage;
  }
}
