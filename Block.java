public class Block extends Entity {
  public String type;

  public Block(int x, int y, String type) {
    super(x, y);
    setType(type);
  }

  public void setType(String t) {
    switch (t) {
      case "Coin":
        super.setCollision(false);
      case "Dirt":
      case "Grass":
      case "Block":
      case "QuestionBlock":
        this.type = t;
        break;
      default:
        this.type = "Undefined";
    }
  }

  public String getType() {
    return this.type;
  }

  public String getMainClass() {
    return "Block";
  }
}
