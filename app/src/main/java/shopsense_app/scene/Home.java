package shopsense_app.scene;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.shape.Line;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Home {
    Stage stage;

    public Home(Stage stage){
        this.stage = stage;
    }

    public void show(){
        Label label = new Label("Sustainability");
        label.getStyleClass().add("depan");

        Label label2 = new Label("Plans");
        label2.getStyleClass().add("depan");

        Label shopscene = new Label("ShopSense");
        shopscene.getStyleClass().add("depan2");

        Line line = new Line();
        line.setStartY(0);
        line.setStartX(20);
        line.setEndY(20);
        line.setEndX(20);
        line.setStrokeWidth(2);
        line.setStroke(Color.web("#20CD8D"));

        HBox lin2 = new HBox(line);
        HBox sence = new HBox(10, lin2, shopscene);
        sence.setAlignment(Pos.TOP_LEFT); // Set alignment to TOP_LEFT

        Label greet = new Label("Managing Sustainable Business Finance");
        greet.getStyleClass().add("depan2");

        Button button = new Button("START");
        button.getStyleClass().add("buton");
        button.setAlignment(Pos.CENTER);
        button.setPrefWidth(300);
        button.setPrefHeight(50);

        button.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            menu.show();
        });

        VBox tittle = new VBox(label, label2);
        tittle.setSpacing(5);
        tittle.setAlignment(Pos.CENTER);

        VBox tittlegreet = new VBox(tittle, greet);
        tittlegreet.setSpacing(10);
        tittlegreet.setAlignment(Pos.CENTER);

        VBox fifty = new VBox(sence, tittlegreet);
        fifty.setSpacing(150);
        fifty.setAlignment(Pos.CENTER);

        HBox buttonbox = new HBox(button);
        buttonbox.setSpacing(7);
        buttonbox.setAlignment(Pos.CENTER);

        VBox all = new VBox(fifty, buttonbox);
        all.setSpacing(40);
        all.setAlignment(Pos.TOP_CENTER);
        all.setPadding(new Insets(10, 10, 10, 10));
        all.getStyleClass().add("background");

        Scene scene = new Scene(all, 1290, 650);
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}