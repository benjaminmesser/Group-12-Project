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

    new AnimationTimer() {
      public void handle(long currentNanoTime) {
        /*
        // I could use a more useful time
        long currentTime = System.nanoTime();

        while (System.nanoTime() <= currentTime + 200000000) {
          for (int i = 0; i < input.size(); i++) {
            if (!input.contains(input.get(i))) {
              input.add(input.get(i));
            }
          }
        }
        */

        // Handle input
        if (input.contains("Q")) b.moveUpLeft();
        if (input.contains("W") || input.contains("SPACE")) b.jump();
        if (input.contains("E")) b.moveUpRight();
        if (input.contains("A")) b.moveLeft();
        if (input.contains("D")) b.moveRight();

        renderGame(gc);
      }
    }.start();

    new Timer().scheduleAtFixedRate(new TimerTask() {
      public void run() {
        while (b.getMario().getYPos() < b.getMap().length - 1 && b.getMap()[b.getMario().getYPos() + 1][b.getMario().getXPos()] == ' ') {
          try {
            Thread.sleep(200);
          } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
          }
          b.fall();
          renderGame(gc);
        }

        if (b.getMario().getYPos() < b.getMap().length - 1){
          if (b.getMap()[b.getMario().getYPos() + 1][b.getMario().getXPos()] == 'x' && (b.getMario().getSprite() == 'q' || b.getMario().getSprite() == 'e')){
            try {
              Thread.sleep(100);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
            b.fall();
            renderGame(gc);
          }
        }
      }
    }, 100, 100);

    stage.show();
  }

  public void renderGame(GraphicsContext gc) {
    gc.clearRect(0, 0, b.getMap()[0].length*32, b.getMap().length*32);
    for (int i = 0; i < b.getMap().length; i++) {
      for (int j = 0; j < b.getMap()[i].length; j++) {
        switch (b.getMap()[i][j]) {
          case 'x': gc.drawImage(block, j*32, i*32);
                    break;
          case 'a': gc.drawImage(marioLeft, j*32, i*32);
                    break;
          case 'd': gc.drawImage(marioRight, j*32, i*32);
                    break;
          case 'q': gc.drawImage(marioJumpLeft, j*32, i*32);
                    break;
          case 'e': gc.drawImage(marioJumpRight, j*32, i*32);
                    break;
          case ' ': break;
          // Keeping these seperate for clarity
          default:  break;
        }
      }
    }
  }
}
