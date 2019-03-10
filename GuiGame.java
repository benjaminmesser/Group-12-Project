public class GuiGame {
  private double MS_PER_UPDATE = 0.0;

  public static void main(String[] args) {
    Board b = new Board();

    boolean play = true;

    double previous = getCurrentTime();
    double lag = 0.0;

    while (play) {
      double current = getCurrentTime();
      double elapsed = current - previous;
      previous = current;
      lag += elapsed
      // process input

      // update board
      b = updateBoard(b);

      // render game
      render(b);
    }
  }

  public void getInput() {

  }

  public Board updateBoard(Board b) {

  }

  public void render(Board b) {

  }
}



/*
// fixed update time step
// variable rendering time step

double previous = getCurrentTime();
double lag = 0.0;
while (true)
{
  double current = getCurrentTime();
  double elapsed = current - previous;
  previous = current;
  lag += elapsed;

  processInput();

  while (lag >= MS_PER_UPDATE) // tries to update the map on a set cycle speed
  {
    update();
    lag -= MS_PER_UPDATE;
  }

  render(); // renders whenever possible after an update
}
*/
