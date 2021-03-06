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
import javafx.scene.text.Font;

/**
  * This is the central class for the game
  * It contains most of the code pertaining to the graphics, event handling, and much of the central logic of the game
  */

public class BadMario extends Application {
  // Movement constants, feel free to change these to what you think feels the best
  // Y-Values are inverted
  private final int HORIZONTAL_VELOCITY = 5;
  private final int JUMP_VELOCITY = -30;
  private final int GRAVITY = 5;
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
  Image heart = new Image("sprites/heart.png");
  Image flag = new Image("sprites/flag.png");

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
        b.handleFallingOffBoard();
        b.handleCollisions();
        renderGame(gc);
        checkAlive();
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
 
 /**
 * Renders the game based on the map and displays it on the screen.
 * @param gc is the GraphicsContext of the canvas for display.
 * It also displays if the player has won or not, and displays the health of both players.
 */

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
          if (((Mario)b.getEntities().get(i)).getSprite().equals("Right")) {
            gc.drawImage(marioRight, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          } else if (((Mario)b.getEntities().get(i)).getSprite().equals("Left")){
            gc.drawImage(marioLeft, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          } else if (((Mario)b.getEntities().get(i)).getSprite().equals("JumpLeft")){
            gc.drawImage(marioJumpLeft, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          } else if (((Mario)b.getEntities().get(i)).getSprite().equals("JumpRight")){
            gc.drawImage(marioJumpRight, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          } else {
            gc.drawImage(block, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          }
          break;
        case "Goomba":
          gc.drawImage(goomba, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          break;
        case "Flag":
          gc.drawImage(flag, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          break;
        case "Undefined":
        default:
          // Change this image to some default thing
          gc.drawImage(block, b.getEntities().get(i).getXPos(), b.getEntities().get(i).getYPos());
          break;
      }
      if (b.getGameStatus() == true){
        gc.setFont(new Font(100));
        gc.fillText("You Win!", b.getMap()[0].length * 10, b.getMap().length * 10);
      }
    }
    for (int i = 0; i < b.getCharacters().size(); i++) {
      if (b.getCharacters().get(i).getType() == "Mario" && ((Mario)b.getCharacters().get(i)).getPlayer() == 1) {
        for (int h = 0; h < ((Mario)(b.getCharacters().get(i))).getHealth(); h++){
          gc.drawImage(heart, h * 32, 0);
        }
      } else if (b.getCharacters().get(i).getType() == "Mario") {
        for (int h = 0; h < ((Mario)(b.getCharacters().get(i))).getHealth(); h++) {
          gc.drawImage(heart, ((b.getMap()[0].length - h) * 32) - 32, 0);
        }
      }
    }
  }
  
  /**
 * This method checks if either one of the Mario's is alive
 * If one or both of the Marios still present on the board then playersAlive returns true
 * however if both Mario's "die", hence the game is lost; a new board is generated
 */
public void checkAlive(){
    boolean playersAlive = false;
    for (int i = 0; i < b.getCharacters().size(); i++){
      if (b.getCharacters().get(i) instanceof Mario){
        playersAlive = true;
      }
    }
    if (playersAlive == false){
      // reset the game
      b = new Board();
    }
  }

 /**
 * Detects user input to move either Mario 1 or Mario 2
 * @param input arraylist of strings of user input
 */
  public void handleInput(ArrayList<String> input) {
    for (int i = 0; i < b.getCharacters().size(); i++) {
      if (b.getCharacters().get(i).getType() == "Mario") {
        if (((Mario)b.getCharacters().get(i)).getPlayer() == 1) {
        if ((input.contains("W") || input.contains("SPACE")) && b.getCharacters().get(i).isGrounded()) {
          b.getCharacters().get(i).addYVelocity(JUMP_VELOCITY);
          // change sprite here
          if (((Mario)b.getCharacters().get(i)).getSprite().equals("Left")){
            ((Mario)b.getCharacters().get(i)).setSprite("JumpLeft");
          }
          if (((Mario)b.getCharacters().get(i)).getSprite().equals("Right")){
            ((Mario)b.getCharacters().get(i)).setSprite("JumpRight");
          }
          if (input.contains("W")) input.remove("W");
          if (input.contains("SPACE")) input.remove("SPACE");
        }
        if (input.contains("A")) {
          b.getCharacters().get(i).setXVelocity(-HORIZONTAL_VELOCITY);
          ((Mario)b.getCharacters().get(i)).setSprite("Left");
        }
        if (input.contains("D")){
           b.getCharacters().get(i).setXVelocity(HORIZONTAL_VELOCITY);
           ((Mario)b.getCharacters().get(i)).setSprite("Right");
        }
        if (!input.contains("A") && !input.contains("D")) b.getCharacters().get(i).setXVelocity(0);
      } else {
        if (input.contains("I") && b.getCharacters().get(i).isGrounded()) {
          b.getCharacters().get(i).addYVelocity(JUMP_VELOCITY);
          input.remove("I");
        }
        if (input.contains("J")){
          b.getCharacters().get(i).setXVelocity(-HORIZONTAL_VELOCITY);
          ((Mario)b.getCharacters().get(i)).setSprite("Left");
        }
        if (input.contains("L")){
           b.getCharacters().get(i).setXVelocity(HORIZONTAL_VELOCITY);
           ((Mario)b.getCharacters().get(i)).setSprite("Right");
        }
        if (!input.contains("J") && !input.contains("L")) b.getCharacters().get(i).setXVelocity(0);
      }
     }
    }
  }

  /**
  * Handles the gravity of all moving characters.
  * Also controls the jumping sprites of the two Mario players.
  */
  public void handleGravity() {
    for (int i = 0; i < b.getCharacters().size(); i++) {
      if (!b.getCharacters().get(i).isGrounded()) {
        b.getCharacters().get(i).addYVelocity(GRAVITY);
      }
      if (b.getCharacters().get(i).getType() == "Mario" && b.getCharacters().get(i).isGrounded()){
        if (((Mario)b.getCharacters().get(i)).getSprite() == "JumpLeft"){
          ((Mario)b.getCharacters().get(i)).setSprite("Left");
        } else if (((Mario)b.getCharacters().get(i)).getSprite() == "JumpRight"){
          ((Mario)b.getCharacters().get(i)).setSprite("Right");
        }
      }
      if (b.getCharacters().get(i).getType() == "Mario" && !b.getCharacters().get(i).isGrounded()){
        if (((Mario)b.getCharacters().get(i)).getSprite() == "Left"){
          ((Mario)b.getCharacters().get(i)).setSprite("JumpLeft");
        } else if (((Mario)b.getCharacters().get(i)).getSprite() == "Right"){
          ((Mario)b.getCharacters().get(i)).setSprite("JumpRight");
        }
      }
    }
  }

  /**
 * This method updates Mario's position on the map
 */
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
