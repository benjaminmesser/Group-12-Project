public abstract class Entity {
  private int xPos = 1;
  private int yPos = 1;

  public Entity(int x, int y) {
    if (x >= 0)
    setXPos(x);
    if (y >= 0)
    setYPos(y);
  }
  public Entity(Entity e){
    if (e.xPos > 0){
      this.xPos = e.xPos;
    }
    if (e.yPos > 0){
      this.yPos = e.yPos;
    }
  }

  public void setXPos(int x) {
    if(x > 0)
    this.xPos = x;
  }

  public int getXPos() {
    return this.xPos;
  }

  public void setYPos(int y) {
    if (y > 0)
    this.yPos = y;
  }

  public int getYPos() {
    return this.yPos;
  }
}
