import java.util.Scanner;

public class RunGame {
	//initalizes the game by creating the board and player
	public static void init() {
		Board b= new Board();
		Player p= new Player();
		
	}
	//Basically just how the game is run
	public static void main(String[] args) {
		//Opens "start menu" that allows player to start game
		System.out.println("Welcome to our adventure game");
		System.out.println("Please enter 1 to start");
		Scanner startIn= new Scanner(System.in);
		int startNumber= startIn.nextInt();
		if(startNumber==1) {
			init();
		}
		startIn.close();
		
	}

}

/**
public class RunGame(){
// basically just how the game is run
public static void main(String[] args){
  Board b = new Board();
  while (true){
    // essentially: keeps checking for input, calls movement methods (b.moveLeft(), b.moveRight(), etc.) accordingly...
    // basically manages all user interaction stuff here.
  }
}
}
**/
