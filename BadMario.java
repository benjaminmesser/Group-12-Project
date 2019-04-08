import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.animation.AnimationTimer;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

public class BadMario extends Application {
  // Movement constants, feel free to change these to what you think feels the best
  // Y-Values are inverted
  private final int HORIZONTAL_VELOCITY = 8;
  private final int JUMP_VELOCITY = -40;
  private final int GRAVITY = 8;
  // FPS for the game's display
  private final int REFRESH_RATE = 60;

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
  Image dirt = new Image("sprites/dirt.png");

  Image background = new Image("sprites/background.png");

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
      if (input.contains(key)) {
        input.remove(key);
      }
    });

    GraphicsContext gc = canvas.getGraphicsContext2D();

   /*
    *
    * Main Game Loop
    *
    */
    new AnimationTimer() {
      public void handle(long currentNanoTime) {
        int startFrame = (int)System.currentTimeMillis();
        handleInput(input);
        updatePositions();
        handleGravity();
        b.handleCollisions();
        renderGame(gc);
        int endFrame = (int)System.currentTimeMillis();
        try {
          try {
            Thread.sleep((int)(1000/REFRESH_RATE - (endFrame-startFrame)));
          } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
          }
        } catch (Exception e) {}
      }
    }.start();
   /*
    *
    *
    *
    */
    stage.show();
  }

  public void renderGame(GraphicsContext gc) {
    gc.clearRect(0, 0, b.getMap()[0].length*32, b.getMap().length*32);
    gc.drawImage(background, 0, 0);
    for (int i = 0; i < b.getEntities().size(); i++) {
      switch (b.getEntities().get(i).getType()) {
        case "Coin":
          gc.drawImage(coin, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          break;
        case "Dirt":
          gc.drawImage(dirt, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          break;
        case "Grass":
          gc.drawImage(grass, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          break;
        case "Block":
          gc.drawImage(block, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          break;
        case "QuestionBlock":
          gc.drawImage(qBlock, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          break;
        case "Mario":
          gc.drawImage(marioRight, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          break;
        case "Goomba":
          gc.drawImage(goomba, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          break;
        case "Undefined":
        default:
          // Change this image to some default thing
          gc.drawImage(block, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          break;
      }
    }
  }

  public void handleInput(ArrayList<String> input) {
    boolean first = true;
    for (int i = 0; i < b.getCharacters().size(); i++) {
      if (b.getCharacters().get(i).getType() == "Mario" && first) {
        if ((input.contains("W") || input.contains("SPACE")) && b.getCharacters().get(i).isGrounded()) {
          b.getCharacters().get(i).addYVelocity(JUMP_VELOCITY);
          if (input.contains("W")) input.remove("W");
          if (input.contains("SPACE")) input.remove("SPACE");
        }
        if (input.contains("A")) b.getCharacters().get(i).setXVelocity(-HORIZONTAL_VELOCITY);
        if (input.contains("D")) b.getCharacters().get(i).setXVelocity(HORIZONTAL_VELOCITY);
        if (!input.contains("A") && !input.contains("D")) b.getCharacters().get(i).setXVelocity(0);
      } else if (b.getCharacters().get(i).getType() == "Mario") {
        if (input.contains("I") && b.getCharacters().get(i).isGrounded()) {
          b.getCharacters().get(i).addYVelocity(JUMP_VELOCITY);
          input.remove("I");
        }
        if (input.contains("J")) b.getCharacters().get(i).setXVelocity(-HORIZONTAL_VELOCITY);
        if (input.contains("L")) b.getCharacters().get(i).setXVelocity(HORIZONTAL_VELOCITY);
        if (!input.contains("J") && !input.contains("L")) b.getCharacters().get(i).setXVelocity(0);
      }
    }
  }

  public void handleGravity() {
    for (int i = 0; i < b.getCharacters().size(); i++) {
      if (!b.getCharacters().get(i).isGrounded()) {
        b.getCharacters().get(i).addYVelocity(GRAVITY);
      }
    }
  }

  public void updatePositions() {
    int charX;
    int charY;
    int velX;
    int velY;
    int mapX = b.getMap()[0].length * 32;
    int mapY = b.getMap().length * 32;
    for (int i = 0; i < b.getCharacters().size(); i++) {
      charX = b.getCharacters().get(i).getXPos();
      charY = b.getCharacters().get(i).getYPos();
      velX = b.getCharacters().get(i).getXVelocity();
      velY = b.getCharacters().get(i).getYVelocity();
      if (charX + velX <= mapX - 32 && charX + velX >= 0) {
        b.getCharacters().get(i).addXPos(velX);
      } else if (charX + velX <= mapX - 32) {
        b.getCharacters().get(i).setXPos(0);
      } else if (charX + velX >= 0) {
        b.getCharacters().get(i).setXPos(mapX - 32);
      }
      if (charY + velY <= mapY - 32 && charY + velY >= 0) {
        b.getCharacters().get(i).addYPos(velY);
      } else if (charY + velY <= mapY - 32) {
        b.getCharacters().get(i).setYPos(0);
      } else if (charY + velY >= 0) {
        b.getCharacters().get(i).setYPos(mapY - 32);
      }
    }
  }
}
