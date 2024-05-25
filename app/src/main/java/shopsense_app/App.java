package shopsense_app;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shopsense_app.scenes.FormPane;
import shopsense_app.scenes.FromPane2;
import shopsense_app.scenes.ListPane2;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        

        // Button button = new Button("Next");
        // button.setStyle("-fx-background-color: #0000ff");
        // button.setTextFill(Color.BLACK);
        // button.setAlignment(Pos.CENTER);
        // button.setPrefWidth(200);
        // button.setOnAction(e -> {
        FormPane form = new FormPane(stage);
        form.show();
       
        ListPane2 listPane = new ListPane2();
        FromPane2 fromPane2 = new FromPane2(listPane);

        VBox hBox = new VBox(fromPane2.getFormPane());
        hBox.setPadding(new Insets(40));
        hBox.setStyle("-fx-background-color: #ccf4e5");

        Scene scene = new Scene(hBox, 800, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        // Scene scene = new Scene(500, 500);
        // stage.setScene(scene);
        // // stage.setResizable(false);
        // stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
