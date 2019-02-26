import java.util.Scanner;

public class RunGame(){
  // basically just how the game is run
  private Board b;
  public static void main(String[] args){
    b = new Board();
    Scanner input = new Scanner(System.in);
    
    	System.out.println("Welcome to our adventure game");
   	System.out.println("Please enter 1 to start");
	boolean start = false;
	Scanner startIn= new Scanner(System.in);
	while (!start){
		int startNumber= startIn.nextInt();
		if(startNumber==1) {
			init();
			start = true;
		}
	  }
		
	startIn.close();
    
    while (true){
      // essentially: keeps checking for input, calls movement methods (b.moveLeft(), b.moveRight(), etc.) accordingly...
      // basically manages all user interaction stuff here.
      char command = input.nextLine();
      
      switch (command) {
        case 'q':  b.moveUpLeft();
                   break;
        case 'w':
	case ' ':
		   b.jump();
                   break;
        case 'e':  b.moveUpRight();
                   break;
        case 'a':  b.moveLeft();
                   break;
        case 'd':  b.moveRight();
                   break;
      }
      
      printBoard();
    }
  }
  
  private void printBoard() {
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
