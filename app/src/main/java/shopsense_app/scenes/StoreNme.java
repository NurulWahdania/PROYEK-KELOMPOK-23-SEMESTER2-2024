package shopsense_app.scenes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StoreNme {
    Stage stage;

    public StoreNme(Stage stage){
        this.stage = stage;
    }

    public void show(){
        Label label = new Label("STORE NAME");
        label.getStyleClass().add("judul2");
        label.setAlignment(Pos.CENTER);
        
        Rectangle rec1 = new Rectangle(80, 20);
        rec1.setFill(Color.web("#20CD8D"));
        rec1.setArcWidth(25); // Set radius horizontal (X-axis)
        rec1.setArcHeight(25); // Set radius vertical (Y-axis)
        
        Rectangle rec2 = new Rectangle(60, 20);
        rec2.setFill(Color.web("#20CD8D"));
        rec2.setArcWidth(25);
        rec2.setArcHeight(25);
        
        Rectangle rec3 = new Rectangle(40, 20);
        rec3.setFill(Color.web("#20CD8D"));
        rec3.setArcWidth(25);
        rec3.setArcHeight(25);
        
        Rectangle rec4 = new Rectangle(20, 20);
        rec4.setFill(Color.web("#20CD8D"));
        rec4.setArcWidth(25);
        rec4.setArcHeight(25);
        
        VBox rectangel = new VBox(10, rec1, rec2, rec3, rec4);
        



        Button home = new Button("Home");
        home.getStyleClass().add("home2");
        home.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            menu.show();
        });

        VBox home2 = new VBox(home);
        home2.setAlignment(Pos.BOTTOM_RIGHT);
        home2.setPadding(new Insets(0, 0, 0, 370));


        HBox vbox = new HBox(rectangel,label, home2);
        vbox. setPadding(new Insets(20));
        vbox.getStyleClass().add("backgroundB");
        vbox.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());


        Scene scene = new Scene(vbox, 800, 600);
        stage.setScene(scene);
        stage.show();

    }
}
