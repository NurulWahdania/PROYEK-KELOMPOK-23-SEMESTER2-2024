package shopsense_app.scenes;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FormPane {
    static String namaToko;
    Stage stage;

    public FormPane(Stage stage){
        this.stage = stage;
    }

    public void show(){
        Label label = new Label("Sustainability");
        label.getStyleClass().add("depan");

        
        Label label2 = new Label("Plans");
        label2.getStyleClass().add("depan");


        Label shopscene = new Label("ShopSense");
        shopscene.getStyleClass().add("depan2");
        
        Label greet = new Label("Managing Sustainable Business Finance");
        greet.getStyleClass().add("depan2");

        Button button = new Button("START");
        button.getStyleClass().add("buton");
        button.setAlignment(Pos.CENTER);
        button.setPrefWidth(300);
        button.setPrefHeight(50);
        
        TextField buttonToStoreName = new TextField();
        buttonToStoreName.setPromptText("STOR NAME");
        // buttonToStoreName.setStyle("-fx-text-Alignment:center; -fx-text-fill: #ffff");
        buttonToStoreName.setId("tf-home");
        buttonToStoreName.setPrefWidth(300);
        buttonToStoreName.setPrefHeight(50);
        
        button.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            namaToko = buttonToStoreName.getText();
            menu.show();
        });

        VBox tittle = new VBox(label, label2);
        tittle.setSpacing(5);
        tittle.setAlignment(Pos.CENTER);

        VBox tittlegreet = new VBox(tittle, greet);
        tittlegreet.setSpacing(10);
        tittlegreet.setAlignment(Pos.CENTER);

        VBox fifty = new VBox(shopscene, tittlegreet);
        fifty.setSpacing(150);
        fifty.setAlignment(Pos.CENTER);

        HBox buttonbox = new HBox(button, buttonToStoreName);
        buttonbox.setSpacing(7);
        buttonbox.setAlignment(Pos.CENTER);

        VBox all = new VBox(fifty, buttonbox);
        all.setSpacing(40);
        all.setAlignment(Pos.TOP_CENTER);
        all.setPadding(new Insets(10, 10, 10, 10));
        all.getStyleClass().add("background");

        
        Scene scene = new Scene(all, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setScene(scene);

        stage.show();
    }
    
}