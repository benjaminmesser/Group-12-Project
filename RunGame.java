import java.util.Scanner;
import java.lang.*;

public class RunGame {
  // basically just how the game is run
  /**
   * This is the main class that runs methods in the Board class in order to facilitate displaying the player and map, as well as
   * allowing the player to interact with the map. This class prints out the board after any move is made by the player and it
   * facilitates the falling of the player if there is an empty space below them. This class also interacts with the user/player and
   * allows for keyboard input to control the movement of the player.
  */
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
          Thread.sleep(500);
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
    System.out.println("----------------");
    for (int i = 0; i < m.length; i++) {
      String row = "";
      for (int j = 0; j < m[i].length; j++) {
        row += m[i][j];
      }
      System.out.println(row);
    }
    System.out.println("----------------");
  }
}
