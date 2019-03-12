import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.geometry.Insets;

public class JavaFxGui extends Application {
  private Board b = new Board();
  ImageView[][] renderedBoard = new ImageView[b.getMap().length][b.getMap()[0].length];

  // Images to be used for the render
  Image marioRight = new Image("sprites/marioRight.png");
  Image marioLeft = new Image("sprites/marioLeft.png");
  Image marioJumpRight = new Image("sprites/marioJumpRight.png");
  Image marioJumpLeft = new Image("sprites/marioJumpLeft.png");
  Image block = new Image("sprites/block.png");

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
        renderedBoard[i][j].setLayoutY(i*80);
        renderedBoard[i][j].setLayoutX(j*80);
      }
    }
    updateRender();

    Pane root = new Pane();
    // add all the images to the scene
    for (int i = 0; i < renderedBoard.length; i++) {
      for (int j = 0; j < renderedBoard[i].length; j++) {
        root.getChildren().add(renderedBoard[i][j]);
      }
    }

    Scene scene = new Scene(root, b.getMap()[0].length * 80, b.getMap().length * 80);
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

      while (b.getPlayer().getYPos() < b.getMap().length - 1 && b.getMap()[b.getPlayer().getYPos() + 1][b.getPlayer().getXPos()] == ' ') {
        try {
          Thread.sleep(500);
        } catch (InterruptedException ex) {
          Thread.currentThread().interrupt();
        }
        b.fall();
        updateRender();
      }
    });

    stage.setScene(scene);
    stage.show();

  }

  private void updateRender() {
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
