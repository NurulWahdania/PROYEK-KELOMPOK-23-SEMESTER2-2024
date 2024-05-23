package shopsense_app;

// import shopsense_app.controller.MahasiswaController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class dua {
    Stage stage;

    public dua(Stage stage){
        this.stage = stage;
    }

    public void show(){

        Button button = new Button("Back");
        button.setTextFill(Color.BLACK);
        button.setAlignment(Pos.CENTER);
        button.setPrefWidth(200);
        button.setOnAction(e -> {
            FormPane form = new FormPane(stage);
            form.show();
        });

        VBox vbox = new VBox(button);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 500, 500);
        stage.setScene(scene); 

    }
    
}
