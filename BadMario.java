import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;
import java.util.Iterator;

public class BadMario extends Application {
  private Board b = new Board();
  ImageView[][] renderedBoard = new ImageView[b.getMap().length][b.getMap()[0].length];

  ArrayList<String> input = new ArrayList<String>();

  // Images to be used
  Image marioRight = new Image();
  Image marioLeft = new Image();
  Image marioJumpRight = new Image();
  Image marioJumpLeft = new Image();
  Image grass = new Image();
  Image qBlock = new Image();
  Image goomba = new image();
  Image coin = new Image();


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    stage.setTitle("Bad Mario");

    Group root = new Group();
    Scene scene = new Scene(root);
    stage.setScene(scene);

    for (int i = 0; i < b.getMap().length; i++) {
      for (int j = 0; j < b.getMap()[0].length; j++){
        renderedBoard[i][j] = new ImageView();
        renderedBoard[i][j].setLayoutY(i*80);
        renderedBoard[i][j].setLayoutX(j*80);

      }
    }


    // Need to add window size
    Canvas canvas = new Canvas(500, 500);
    root.getChildren().add(canvas);


    scene.setOnKeyPressed(e -> {
      String key = e.getCode().toString();
      if (!input.contains(key)) {
        input.add(key);
      }
    });

    scene.setOnKeyReleased(e -> {
      String key = e.getCode().toString();
      input.remove(key);
    });

    GraphicsContext gc = canvas.getGraphicsContext2D();

    // Add images to be used

    new AnimationTimer() {
      public void handle(long currentNanoTime) {
        renderGame();
      }
    }.start();

    stage.show();
  }

  public void renderGame() {
    for (int i = 0; i < b.getMap().length; i++) {
      for (int j = 0; j < b.getMap()[i].length; j++) {
        switch (b.getMap()[i][j]) {
          case 'x': renderedBoard[i][j].setImage(block);
                    break;
          case 'a': renderedBoard[i][j].setImage(marioLeft);
                    break;
          case 'd': renderedBoard[i][j].setImage(marioRight);
                    break;
          case 'q': renderedBoard[i][j].setImage(marioJumpLeft);
                    break;
          case 'e': renderedBoard[i][j].setImage(marioJumpRight);
                    break;
          case ' ': renderedBoard[i][j].setImage(null);
                    break;
          // Keeping these seperate for clarity
          default:  renderedBoard[i][j].setImage(null);
                    break;
        }
      }
    }
  }
}
