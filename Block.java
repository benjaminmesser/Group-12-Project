public class Block extends Entity {
  private boolean collision = true;
  private boolean length = 1;
  private boolean width = 1;

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
