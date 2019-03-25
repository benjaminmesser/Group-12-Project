public class Character extends Entity {
  private char sprite;
  private double velocity = 0;

  public Character(int x, int y) {
    super(x,y);
  }

  public void setSprite(char c) {
    this.sprite = c;
  }

  public char getSprite() {
    return this.sprite;
  }

  public void setVelocity(double v) {
    this.velocity = v;
  }

  public double getVelocity() {
    return this.velocity;
  }
}
