import java.util.Scanner;
import java.lang.*;

public class RunGame {
  // basically just how the game is run
  public static void main(String[] args){
    Board b = new Board();
    Scanner input = new Scanner(System.in);

    System.out.println("Welcome to our adventure game");
   	System.out.println("Please enter 1 to start");
	  boolean start = false;
	  while (!start){
		  int startNumber = Integer.parseInt(input.nextLine());
		  if(startNumber==1) {
			  start = true;
		  }
	  }
    printBoard(b);

    while (true){
      // essentially: keeps checking for input, calls movement methods (b.moveLeft(), b.moveRight(), etc.) accordingly...
      // basically manages all user interaction stuff here.
      char command = input.nextLine().charAt(0);

      switch (command) {
        case 'q':  b.moveUpLeft();
                   break;
        case 'w':
	      case ' ':  b.jump();
                   break;
        case 'e':  b.moveUpRight();
                   break;
        case 'a':  b.moveLeft();
                   break;
        case 'd':  b.moveRight();
                   break;
      }
	  printBoard(b);
	  while (b.getPlayer().getYPos() < b.getMap().length - 1 && b.getMap()[b.getPlayer().getYPos() + 1][b.getPlayer().getXPos()] == ' '){
	    try {
          Thread.sleep(2000);
	    } catch (InterruptedException ex){
          Thread.currentThread().interrupt();
	    }
        b.fall();
        printBoard(b);
	  }
    }
  }

  private static void printBoard(Board b) {
    char[][] m = b.getMap();
    System.out.println("------------------------------");
    for (int i = 0; i < m.length; i++) {
      String row = "";
      for (int j = 0; j < m[i].length; j++) {
        row += m[i][j];
      }
      System.out.println(row);
    }
    System.out.println("------------------------------");
  }
}
