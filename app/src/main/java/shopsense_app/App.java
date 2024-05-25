package shopsense_app;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shopsense_app.scenes.FormPane;
import shopsense_app.scenes.FromPane2;
import shopsense_app.scenes.ListPane2;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        FormPane form = new FormPane(stage);
        form.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
