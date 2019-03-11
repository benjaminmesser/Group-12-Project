import javafx.event.EventHandler;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFxGui extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    Board b = new Board();

    double previous = getCurrentTime();
    double lag = 0.0;

    Stage.setTitle("Good Waluigi");

    ImageView[][] renderedBoard = new ImageView[5][15];
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 15; j++){
        renderedBoard[i][j] = new ImageView();
      }
    }

    Image mario = new Image("sprites/mario.png");
    Image block = new Image("sprites/block.png");

    updateRender();


    Pane root = new Pane();
    // add all the images to the scene
    for (int i = 0; i < renderedBoard.length; i++) {
      for (int j = 0; j < renderedBoard[i].length; j++) {
        root.getChildren.add(renderedBoard[i][j], i*80, j*80);
      }
    }

    Scene scene = new Scene(root, x, y);
    stage.setScene(scene);
    stage.show();
  }
}
