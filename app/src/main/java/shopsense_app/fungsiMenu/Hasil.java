package shopsense_app.fungsiMenu;

import com.google.common.collect.HashBasedTable;
import com.google.common.math.Quantiles.Scale;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import shopsense_app.scenes.Menuisi;

public class Hasil {
    Stage stage;

    public Hasil(Stage stage){
        this.stage = stage;
    }

    public void show(){
        Label label = new Label("HASIL/CATATAN");
        label.getStyleClass().add("judul4");



        Button home = new Button("Menu");
        home.getStyleClass().add("home2");
        home.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            menu.show();
        });

        VBox home2 = new VBox(home);
        home2.setAlignment(Pos.BOTTOM_RIGHT);
        home2.setPadding(new Insets(0, 0, 0, 370));

        HBox all = new HBox(label, home2);
        all.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());

        all.setPadding(new Insets(20));
        Scene scene = new Scene(all, 800, 600);
        stage.setScene(scene);


    }
    
}
