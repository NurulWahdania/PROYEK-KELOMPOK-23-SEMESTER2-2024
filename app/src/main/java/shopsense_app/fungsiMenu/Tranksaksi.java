package shopsense_app.fungsiMenu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import shopsense_app.scenes.Menuisi;

public class Tranksaksi{
        Stage stage;

    public Tranksaksi(Stage stage){
        this.stage = stage;
    }

    public void show(){
        Label label = new Label("Tranksaksi");
        label.getStyleClass().add("judul3");

        Button main = new Button("<\t\t\tMain Menu\t\t\t>");
        main.getStyleClass().add("buton7");

        Button add = new Button("+");
        add.getStyleClass().add("buton6");

        Button less = new Button("-");
        less.getStyleClass().add("buton6");

        Button home = new Button("Home");
        home.getStyleClass().add("home2");
        home.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            menu.show();
        });

        VBox home2 = new VBox(home);
        home2.setAlignment(Pos.BOTTOM_RIGHT);
        home2.setPadding(new Insets(60, 0, 0, 0));

        HBox buton = new HBox(10,add, less);
        buton.setAlignment(Pos.CENTER);

        Rectangle rectangle = new Rectangle(350,340);
        rectangle.setFill(Color.web("#ffff"));
        // rectangle.setOpacity(0.50);
        rectangle.setStrokeWidth(2);

        Rectangle rectangle2 = new Rectangle(350,300);
        rectangle2.setFill(Color.web("#ffff"));
        rectangle2.setX(400);

        Rectangle rectangle3 = new Rectangle(350,40);
        rectangle3.setFill(Color.web("#D9D9D9"));


        VBox rec = new VBox(rectangle2, rectangle3, buton);
        rec.setPadding(new Insets(85, 0, 0, 30));
        rec.setAlignment(Pos.CENTER);
        rec.setSpacing(10);

        VBox menu1 = new VBox(20, label, main, rectangle);
        HBox sejajar = new HBox(menu1, rec);

        sejajar.setSpacing(30);
        VBox all = new VBox(sejajar, home2);
        all.setPadding(new Insets(20));
        all. getStyleClass().add("background2");
        all.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        Scene scene = new Scene(all, 800,600);
        stage.setScene(scene);

        
    }
}
