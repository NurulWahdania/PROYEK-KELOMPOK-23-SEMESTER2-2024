package shopsense_app;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        // Button button = new Button("Next");
        // button.setStyle("-fx-background-color: #0000ff");
        // button.setTextFill(Color.BLACK);
        // button.setAlignment(Pos.CENTER);
        // button.setPrefWidth(200);
        // button.setOnAction(e -> {
        FormPane form = new FormPane(stage);
        form.show();
       

        // Scene scene = new Scene(500, 500);
        // stage.setScene(scene);
        // // stage.setResizable(false);
        // stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
