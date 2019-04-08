public abstract class Entity {
  // needs to be abstract for the board's handle collisions method
  private int xPos;
  private int yPos;
  private boolean collision = true;

  public Entity(int x, int y) {
    setXPos(x);
    setYPos(y);
  }

  public void setXPos(int x) {
    this.xPos = x;
  }

  public int getXPos() {
    return this.xPos;
  }

  public void setYPos(int y) {
    this.yPos = y;
  }

  public int getYPos() {
    return this.yPos;
  }

  public void setCollision(boolean collideable) {
    this.collision = collideable;
  }

  public boolean isCollideable() {
    return this.collision;
  }

  public abstract String getType();

  public abstract String getMainClass();
}
