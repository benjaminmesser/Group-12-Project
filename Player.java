public class Player{
  private int xPos;
  private int yPos;
  // eventually add more for health, coins, etc.
  public Player(){
    this.xPos = 0;
    this.yPos = 0;
    // eventually change to automatically put player at the origin, once we find out where that is
  }
  
  //setter and getter methods: these only change the stats for the file. Actual movement and such takes place in the board class.
  public int getXPos(){
    return this.xPos;
  }
  public int getYPos(){
    return this.yPos;
  }
  public void setXPos(int x){
    this.xPos = x;
  }
  public void setYPos(int y){
    this.yPos = y;
  }

}
