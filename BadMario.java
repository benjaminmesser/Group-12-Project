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
import java.util.ArrayList;
import java.util.Iterator;

public class BadMario extends Application {
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
    Canvas canvas = new Canvas(x, y);
    root.getChildren.add(canvas);

    ArrayList<String> input = new ArrayList<String>();

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

    new AnimationTimer(e -> {
      gc.clearRect(0, 0, x, y);


    });

    stage.show();
  }
}
