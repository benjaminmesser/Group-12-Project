import javafX.scene.input.*;

public class GuiGame extends Application {
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

      while (lag >= MS_PER_UPDATE) {
        // update board
        b = updateBoard(b);
        lag -= MS_PER_UPDATE;
      }
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
