import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.util.Timer;
import java.util.TimerTask;

public class BadMario extends Application {
  private Board b = new Board();
  ImageView[][] renderedBoard = new ImageView[b.getMap().length][b.getMap()[0].length];

  ArrayList<String> input = new ArrayList<String>();

  // Images to be used
  Image marioRight = new Image("sprites/marioRight.png");
  Image marioLeft = new Image("sprites/marioLeft.png");
  Image marioJumpRight = new Image("sprites/marioJumpRight.png");
  Image marioJumpLeft = new Image("sprites/marioJumpLeft.png");
  Image grass = new Image("sprites/bottomBlock.png");
  Image block = new Image("sprites/block.png");
  Image qBlock = new Image("sprites/qBlock.png");
  Image goomba = new Image("sprites/goomba.png");
  Image coin = new Image("sprites/coin.png");

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
        renderedBoard[i][j].setLayoutY(i*32);
        renderedBoard[i][j].setLayoutX(j*32);
      }
    }


    // Need to add window size
    Canvas canvas = new Canvas(b.getMap()[0].length*32, b.getMap().length*32);
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
        // Handle input
        if (input.contains("Q")) b.moveUpLeft();
        if (input.contains("W") || input.contains("SPACE")) b.jump();
        if (input.contains("E")) b.moveUpRight();
        if (input.contains("A")) b.moveLeft();
        if (input.contains("D")) b.moveRight();

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
