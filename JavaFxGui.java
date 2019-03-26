//import com.sun.prism.paint.ImagePattern;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import java.util.Timer;
import java.util.TimerTask;

public class JavaFxGui extends Application {
  private Board b = new Board();
  ImageView[][] renderedBoard = new ImageView[b.getMap().length][b.getMap()[0].length];

  // Images to be used for the render
  Image marioRight = new Image("sprites/marioRight.png");
  Image marioLeft = new Image("sprites/marioLeft.png");
  Image marioJumpRight = new Image("sprites/marioJumpRight.png");
  Image marioJumpLeft = new Image("sprites/marioJumpLeft.png");
  Image block = new Image("sprites/block.png");
  Image bottomBlock = new Image("sprites/bottomBlock.png");
  Image goomba = new Image("sprites/goomba.png");
  Image dirt= new Image("sprites/dirt.png");

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    stage.setTitle("Good Waluigi");

    // Setting up the board with all the images
    for (int i = 0; i < b.getMap().length; i++) {
      for (int j = 0; j < b.getMap()[0].length; j++){
        renderedBoard[i][j] = new ImageView();
        renderedBoard[i][j].setLayoutY(i*32);
        renderedBoard[i][j].setLayoutX(j*32);

      }
    }
    updateRender();

    Pane root = new Pane();
    //set background color
    //root.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, null, null)));
    // add all the images to the scene
    for (int i = 0; i < renderedBoard.length; i++) {
      for (int j = 0; j < renderedBoard[i].length; j++) {
        root.getChildren().add(renderedBoard[i][j]);
      }
    }
    Scene scene = new Scene(root, b.getMap()[0].length * 32, b.getMap().length * 32);
    // Process keyboard input and automatically update the rendered image

    scene.setOnKeyPressed(e -> {
      String input = e.getCode().toString();
      switch (input) {
        case "Q":  b.moveUpLeft();
        break;
        case "W":
        case "SPACE":  b.jump();
        break;
        case "E":  b.moveUpRight();
        break;
        case "A":  b.moveLeft();
        break;
        case "D":  b.moveRight();
        break;
      }

      updateRender();
    });

    new Timer().scheduleAtFixedRate(new TimerTask() {
    public void run() {
        while (b.getMario().getYPos() < b.getMap().length - 1 && b.getMap()[b.getMario().getYPos() + 1][b.getMario().getXPos()] == ' ') {
            try {
              Thread.sleep(200);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
            b.fall();
            updateRender();
          }

      if (b.getMario().getYPos() < b.getMap().length - 1){
            if (b.getMap()[b.getMario().getYPos() + 1][b.getMario().getXPos()] == 'x' && (b.getMario().getSprite() == 'q' || b.getMario().getSprite() == 'e')){
              try {
                Thread.sleep(100);
              } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
              }
              b.fall();
              updateRender();
            }
          }
        }
    }, 100, 100);
    stage.setScene(scene);
    stage.show();

  }

  private void updateRender() {
    for (int i = 0; i < b.getMap().length; i++) {
      for (int j = 0; j < b.getMap()[i].length; j++) {
        switch (b.getMap()[i][j]) {
          case 'x': renderedBoard[i][j].setImage(block);
                    break;
          case 'b': renderedBoard[i][j].setImage(bottomBlock);
					break;
		  case 'u': renderedBoard[i][j].setImage(dirt);
					break;
          case 'a': renderedBoard[i][j].setImage(marioLeft);
                    break;
          case 'd': renderedBoard[i][j].setImage(marioRight);
                    break;
          case 'q': renderedBoard[i][j].setImage(marioJumpLeft);
                    break;
          case 'e': renderedBoard[i][j].setImage(marioJumpRight);
                    break;
          case 'g': renderedBoard[i][j].setImage(goomba);
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