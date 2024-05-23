package shopsense_app.scenes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StoreNme {
    Stage stage;

    public StoreNme(Stage stage){
        this.stage = stage;
    }

    public void show(){
        Label label = new Label("LAbel");
        label.setFont(Font.font("Arial", 20));
        
        VBox vbox = new VBox(label);

        Scene scene = new Scene(vbox, 500, 500);
        stage.setScene(scene);
        stage.show();

    }
}
