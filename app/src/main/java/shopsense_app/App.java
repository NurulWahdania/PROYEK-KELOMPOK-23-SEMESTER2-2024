package shopsense_app;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shopsense_app.scenes.FormPane;
import shopsense_app.scenes.FromBarang;
import shopsense_app.scenes.ListPane2;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setResizable(false);
        stage.setTitle("ShopSense");
        Image imageIcon = new Image(getClass().getClassLoader().getResourceAsStream("image/Logo.jpg"));
        stage.getIcons().add(imageIcon);
        
        FormPane form = new FormPane(stage);
        form.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
