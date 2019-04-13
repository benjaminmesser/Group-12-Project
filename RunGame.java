import java.util.Scanner;
import java.lang.*;
import java.util.ArrayList;

public class RunGame {
  /**
   * This is the main class that runs methods in the Board class in order to facilitate displaying the player and map, as well as
   * allowing the player to interact with the map. This class prints out the board after any move is made by the player and it
   * facilitates the falling of the player if there is an empty space below them. This class also interacts with the user/player and
   * allows for keyboard input to control the movement of the player.
   * It modifies the initial map, which is the same as the GUI map, so that there are no additional characters.
   * This is a very basic version of the GUI game, with no goombas or coins, only the character moving on a map.
  */
  private static char[][] map;
  public static void main(String[] args) {
    map = new Board().getTextMap();
    boolean playerFound = false;
    for (int y = 0; y < map.length; y++){
      for (int x = 0; x < map[0].length; x++){
        if (map[y][x] == 'd' && playerFound == true){
          map[y][x] = ' ';
        } else if (map[y][x] == 'd' && playerFound == false){
          playerFound = true;
          map[y][x] = 'm';
        }
        if (map[y][x] == 'c' || map[y][x] == 'g'||map[y][x] == 'f'){
          map[y][x] = ' ';
        }
      }
    }
    Scanner input = new Scanner(System.in);

    System.out.println("Welcome to our adventure game");
   	System.out.println("Please enter 1 to start");
	  boolean start = false;
	  while (!start) {
		  int startNumber = Integer.parseInt(input.nextLine());
		  if (startNumber==1) {
			  start = true;
		  }
	  }
    printBoard();

    while (true) {
      // essentially: keeps checking for input, calls movement methods handleInput with the input.
      char command = input.nextLine().charAt(0);
      handleInput(command);
	    printBoard();
      fall();

    }
  }
  /**
  * The class that handles input by updating the map according to the user's input.
  * @param input is the character corresponding to movement.
  */
  public static void handleInput(char input) {
    for (int y = 0; y < map.length; y++) {
      for (int x = 0; x < map[0].length; x++){
        if (map[y][x] == 'm'){
          if ((input == 'w' || input == ' ')) {
            if (y- 1 >= 0) {
              if (map[y - 1][x] == ' ') {
                map[y][x] = ' ';
                map[y - 1][x] = 'm';
              }
            }
          }
          else if (input == 'a') {
            if (x - 1 >= 0) {
              if (map[y][x-1] == ' ') {
                map[y][x] = ' ';
                map[y][x -1] = 'm';
              }
            }
          }
          else if (input == 'd'){
            if (x + 1 < map[0].length) {
              if (map[y][x+1] == ' ') {
                map[y][x] = ' ';
                map[y][x +1] = 'm';
                break;
              }
            }
          }
          else if (input == 'q') {
            if (x - 1 >= 0 && y - 1 >= 0) {
              if (map[y-1][x-1] == ' ') {
                map[y][x] = ' ';
                map[y-1][x-1] = 'm';
              }
            }
          }
          else if (input == 'e'){
            if (x + 1 < map[0].length && y - 1 >= 0) {
              if (map[y - 1][x + 1] == ' ') {
                map[y][x] = ' ';
                map[y-1][x+1] = 'm';
              }
            }
          }
        }
      }
    }
  }
  /**
  * This method detects if there is empty space beneath the player and will display a "falling animation" so that it falls.
  *
  */
  public static void fall(){
    for (int y = 0; y < map.length; y++){
      for (int x = 0; x < map[0].length; x++){
        if (map[y][x] == 'm'){
          while (y < map.length - 1 && map[y + 1][x] == ' ') {
            try {
              Thread.sleep(500);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
            if (map[y + 1][x] == ' '){
              map[y][x] = ' ';
              map[y+1][x] = 'm';
              printBoard();
            }
          }
        }

      }
    }

  }
  /**
  * The method which prints out the map onto the screen for the player to view.
  *
  */
  public static void printBoard() {
    System.out.println("----------------");
    for (int i = 0; i < map.length; i++) {
      String row = "";
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] == 'b' || map[i][j] == 'u' || map[i][j] == 'x' || map[i][j] == 'm' ) {
          row += map[i][j];
        } else {
          row += " ";
        }
      }
      System.out.println(row);
    }
    System.out.println("----------------");
  }
}
