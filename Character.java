public class Character extends Entity {
  private int xVelocity = 0;
  private int yVelocity = 0;
  private boolean grounded = false;

  public Character(int x, int y) {
    super(x,y);
  }

  public void setXVelocity(int vel) {
    // Positive values move right, negatives move left
    this.xVelocity = vel;
  }

  public int getXVelocity() {
    return this.xVelocity;
  }

  public void setYVelocity(int vel) {
    // Positive values move up, negative move down
    this.yVelocity = vel;
  }

  public int getYVelocity() {
    return this.yVelocity;
  }

  public void addXVelocity(int x) {
    this.xVelocity += x;
  }

  public void addYVelocity(int y) {
    this.yVelocity += y;
  }

  public void addXPos(int displacement) {
    super.setXPos(super.getXPos() + displacement);
  }

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
