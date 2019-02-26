import java.util.Scanner;

public class RunGame(){
  // basically just how the game is run
  public static void main(String[] args){
    Board b = new Board();
    Scanner input = new Scanner(System.in);
    
    while (true){
      // essentially: keeps checking for input, calls movement methods (b.moveLeft(), b.moveRight(), etc.) accordingly...
      // basically manages all user interaction stuff here.
      Char command = input.nextChar();
      
      switch (command) {
        case 'q':  b.moveUpLeft();
                   break;
        case 'w':  b.jump();
                   break;
        case 'e':  b.moveUpRight();
                   break;
        case 'a':  b.moveLeft();
                   break;
        case 'd':  b.moveRight();
                   break;
        case ' ':  b.jump();
                   break;
      }
      
      printBoard();
    }
  }
  
  private void printBoard() {
    System.out.println("------------------------------");
    for (int i = 0; i < b.length; i++) {
      String row = "";
      for (int j = 0; j < b[i].length; j++) {
        row += b[i][j];
      }
      System.out.println(row);
    }
    System.out.println("------------------------------");
  }
}
