package shopsense_app.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StoreNme {
    Stage stage;

    public StoreNme(Stage stage){
        this.stage = stage;
    }

    public void show(){
        Label label = new Label("STORE NAME");
        label.getStyleClass().add("judul2");
        
        Rectangle rec1 = new Rectangle(80, 20);
        rec1.setFill(Color.web("#20CD8D"));
        rec1.setArcWidth(25); 
        rec1.setArcHeight(25); 
        
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

        Label store = new Label("Enter Your Store Name");
        store.getStyleClass().add("name");
        // store.setPadding(new Insets(0,0,0,300));
        store.setAlignment(Pos.CENTER);

        TextField text = new TextField();
        text.getStyleClass().add("text1");
        text.setMaxSize(300, 0);
        text.setAlignment(Pos.CENTER);

        VBox bawah = new VBox(20, store, text);
        bawah.setAlignment(Pos.CENTER);

        Button add = new Button("\tAdd\t\t");
        add.getStyleClass().add("butonn");
        Button delete = new Button("\tDelete\t");
        delete.getStyleClass().add("butonn");

        HBox buton = new HBox(10, add, delete);
        buton.setAlignment(Pos.CENTER);

        VBox all = new VBox(20, bawah, buton);
        all.setAlignment(Pos.CENTER);

        Button home = new Button("Home");
        home.getStyleClass().add("home");
        home.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            menu.show();
        });

        VBox home2 = new VBox(home);
        home2.setAlignment(Pos.BOTTOM_RIGHT);
        home2.setPadding(new Insets(90, 0, 0, 0));
        
        HBox yo = new HBox(label);
        yo.setPadding(new Insets(0, 0, 0, 150));

        HBox hbo = new HBox(rectangel, yo);
        
        VBox vbox = new VBox(100, hbo, all, home2);
        vbox.setPadding(new Insets(20));
        vbox.getStyleClass().add("backgroundB");
        vbox.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());

        Scene scene = new Scene(vbox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}
