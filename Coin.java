public class Coin extends Block {
  private int value;

  public Coin(int x, int y, int aValue) {
    super(x, y, false);
    setValue(aValue);
  }

  public void setValue(int aValue) {
    this.value = aValue;
  }

  public int getValue() {
    return this.value;
  }
}
