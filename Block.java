public class Block extends Entity {
  private boolean collision;

  public Block(int x, int y, boolean collideable) {
    super(x, y);
    setCollision(collideable);
  }

  public void setCollision(boolean collideable) {
    this.collision = collideable;
  }

  public boolean getCollision() {
    return this.collision;
  }
}
