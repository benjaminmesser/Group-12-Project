/**
 * Block is subclass of Entity
 * It implements the different types of blocks within the game for example, a grass block or a dirt block
 */
public class Block extends Entity {
  public String type;
  
 /**
 * Constructor that sets the x and y positions of various blocks based on the board and blocks' type 
 * @param x integer for x position of a block
 * @param y integer for y position of a block
 * @param type String for type of block
 */
  public Block(int x, int y, String type) {
    super(x, y);
    setType(type);
  }
  
 /**
 * This methods sets the type of block. Coins are set to be non collideable so Mario is able to collect them.
 * @param t String that is used to directly set the type of block
 */
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
