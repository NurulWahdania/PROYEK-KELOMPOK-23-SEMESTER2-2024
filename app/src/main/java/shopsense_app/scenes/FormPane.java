package shopsense_app.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FormPane {
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
        // button.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(10), null)));
        // button.setTextFill(Color.BLACK);
        button.getStyleClass().add("buton");
        button.setAlignment(Pos.CENTER);
        button.setPrefWidth(100);
        button.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            menu.show();
        });

        Button buttonToStoreName = new Button("STORE NAME");
        // buttonToStoreName.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(10), null)));
        // buttonToStoreName.setTextFill(Color.BLACK);
        // buttonToStoreName.setAlignment(Pos.CENTER);
        buttonToStoreName.getStyleClass().add("buton");
        buttonToStoreName.setPrefWidth(100);
        buttonToStoreName.setOnAction(e -> {
            StoreNme name = new StoreNme(stage);
            name.show();
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
        all.setSpacing(20);
        all.setAlignment(Pos.TOP_CENTER);
        all.setPadding(new Insets(10, 10, 10, 10));
        all.getStyleClass().add("background");
        
        // all.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(10), null)));

        Scene scene = new Scene(all, 500, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setScene(scene);

        stage.show();
    }
    
}