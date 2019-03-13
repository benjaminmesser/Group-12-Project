public abstract class Entity {
  private int xPos;
  private int yPos;

  public Entity(x, y) {
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
}
