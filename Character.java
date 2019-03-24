public class Character extends Entity {
  
  private char sprite;

  public Character(int x, int y) {
    super(x,y);
  }

  public Character(Character c){
    super(c);
  }

  public void setSprite(char c) {
    this.sprite = c;
  }

  public char getSprite() {
    return this.sprite;
  }
}
